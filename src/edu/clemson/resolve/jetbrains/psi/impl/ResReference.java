package edu.clemson.resolve.jetbrains.psi.impl;

import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.ResolveCache;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ArrayUtil;
import com.intellij.util.ObjectUtils;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.containers.OrderedSet;
import edu.clemson.resolve.jetbrains.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ResReference extends PsiPolyVariantReferenceBase<ResReferenceExpBase> {

    private static final Key<SmartPsiElementPointer<ResReferenceExpBase>> CONTEXT = Key.create("CONTEXT");
    private static final Key<String> ACTUAL_NAME = Key.create("ACTUAL_NAME");

    private static final ResolveCache.PolyVariantResolver<PsiPolyVariantReferenceBase> MY_RESOLVER =
            new ResolveCache.PolyVariantResolver<PsiPolyVariantReferenceBase>() {
                @NotNull
                @Override
                public ResolveResult[] resolve(@NotNull PsiPolyVariantReferenceBase psiPolyVariantReferenceBase,
                                               boolean incompleteCode) {
                    return ((ResReference) psiPolyVariantReferenceBase).resolveInner();
                }
            };

    @NotNull
    private PsiElement getIdentifier() {
        return myElement.getIdentifier();
    }

    ResReference(@NotNull ResReferenceExpBase o) {
        super(o, TextRange.from(o.getIdentifier().getStartOffsetInParent(), o.getIdentifier().getTextLength()));
    }

    @NotNull
    private ResolveResult[] resolveInner() {
        if (!myElement.isValid()) return ResolveResult.EMPTY_ARRAY;
        Collection<ResolveResult> result = new OrderedSet<ResolveResult>();
        processResolveVariants(createResolveProcessor(result, myElement));
        return result.toArray(new ResolveResult[result.size()]);
    }

    @NotNull
    static ResScopeProcessor createResolveProcessor(@NotNull final Collection<ResolveResult> result,
                                                    @NotNull final ResReferenceExpBase o) {
        return new ResScopeProcessor() {
            @Override
            public boolean execute(@NotNull PsiElement element, @NotNull ResolveState state) {
                if (element.equals(o)) {
                    return !result.add(new PsiElementResolveResult(element));
                }
                //TODO: Added 3/23/17 to keep program contexts from ref'ing math defns.
                //if (o instanceof ResReferenceExp && element instanceof ResMathDefnSig) {
                //    return true;
                //}
                String name = ObjectUtils.chooseNotNull(state.get(ACTUAL_NAME),
                        element instanceof PsiNamedElement ? ((PsiNamedElement) element).getName() : null);
                if (name != null && o.getIdentifier().textMatches(name)) {
                    result.add(new PsiElementResolveResult(element));
                    return false;
                }
                return true;
            }
        };
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        if (!myElement.isValid()) return ResolveResult.EMPTY_ARRAY;
        return ResolveCache.getInstance(myElement.getProject()).resolveWithCaching(this, MY_RESOLVER, false, false);
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return ArrayUtil.EMPTY_OBJECT_ARRAY;
    }

    public boolean processResolveVariants(@NotNull ResScopeProcessor processor) {
        PsiFile file = myElement.getContainingFile();
        if (!(file instanceof ResFile)) return false;
        ResolveState state = ResolveState.initial();
        ResReferenceExpBase qualifier = myElement.getQualifier();
        return qualifier != null ?
                processQualifierExpression(((ResFile) file), qualifier, processor, state) :
                processUnqualifiedResolve(((ResFile) file), processor, state, true);
    }

    public static boolean processQualifierExpression(@NotNull ResFile file,
                                                     @NotNull ResReferenceExpBase qualifier,
                                                     @NotNull ResScopeProcessor processor,
                                                     @NotNull ResolveState state) {
        PsiReference reference = qualifier.getReference();
        PsiElement target = reference != null ? reference.resolve() : null;
        if (target == null || target == qualifier) return false;
        if (target instanceof ResFacilityDecl) {
            ResFacilityDecl facility = ((ResFacilityDecl) target);
            ResFile resolvedSpec = facility.resolveSpecification();
            if (resolvedSpec != null) processModuleLevelEntities(resolvedSpec, processor, state, false, true);

            for (ResExtensionPairing p : facility.getExtensionPairingList()) {
                if (p.getModuleIdentifierList().isEmpty()) continue;
                ResFile extSpec = (ResFile) p.resolveSpecification();
                if (extSpec != null) processModuleLevelEntities(extSpec, processor, state, false, true);
            }
        }
        else if (target instanceof ResModuleIdentifierSpec) {
            PsiElement e = ((ResModuleIdentifierSpec) target).getModuleIdentifier().resolve();
            if (e != null && e instanceof ResFile) {
                processModuleLevelEntities((ResFile) e, processor, state, false, false);
            }
        }
        else if (target instanceof ResFile) {
            processModuleLevelEntities((ResFile) target, processor, state, false, false);
        }
        return true;
    }

    private boolean processUnqualifiedResolve(@NotNull ResFile file,
                                              @NotNull ResScopeProcessor processor,
                                              @NotNull ResolveState state,
                                              boolean localResolve) {

        PsiElement parent = myElement.getParent();
        if (parent instanceof ResSelectorExp) {
            boolean result = processSelector((ResSelectorExp) parent, processor, state, myElement);
            if (processor.isCompletion()) return result;
            if (!result || ResPsiImplUtil.prevDot(myElement)) return false;
        }
        PsiElement grandPa = parent.getParent();
        if (grandPa instanceof ResSelectorExp && !processSelector((ResSelectorExp) grandPa, processor, state, parent)) return false;
        if (ResPsiImplUtil.prevDot(parent)) return false;
        if (!processBlock(processor, state, true)) return false;
        if (!processModuleLevelEntities(file, processor, state, true)) return false;

        if (!processUsesImports(file, processor, state)) return false;
        if (!processFacilityImports(file, processor, state)) return false;

        return true;
    }

    @NotNull
    public static List<ResFile> resolveSuperModules(@NotNull ResFile file) {
        List<ResFile> result = new ArrayList<>();
        ResModuleDecl module = file.getEnclosedModule();
        if (module == null) return result;

        for (ResReferenceExp e : module.getModuleHeaderReferences()) {
            PsiElement resolve = e.resolve();
            if (resolve instanceof ResFile) {
                result.add((ResFile)resolve);
            }
        }
        return result;
    }

    private boolean processSelector(@NotNull ResSelectorExp parent,
                                    @NotNull ResScopeProcessor processor,
                                    @NotNull ResolveState state,
                                    @Nullable PsiElement another) {
        List<ResExp> list = parent.getExpList();
        if (list.size() > 1 && list.get(1).isEquivalentTo(another)) {
            ResType type = list.get(0).getResType(createContext());
            if (type != null && !processResType(type, processor, state)) return false;
        }
        return true;
    }

    private boolean processResType(@NotNull ResType type,
                                   @NotNull ResScopeProcessor processor,
                                   @NotNull ResolveState state) {
        if (!processExistingType(type, processor, state)) return false;
        return processTypeRef(type, processor, state);
    }

    private boolean processTypeRef(@Nullable ResType type,
                                   @NotNull ResScopeProcessor processor,
                                   @NotNull ResolveState state) {
        return processInTypeRef(getTypeReference(type), type, processor, state);
    }

    private boolean processInTypeRef(@Nullable ResTypeReferenceExp refExp,
                                     @Nullable ResType recursiveStopper,
                                     @NotNull ResScopeProcessor processor,
                                     @NotNull ResolveState state) {
        PsiReference reference = refExp != null ? refExp.getReference() : null;
        PsiElement resolve = reference != null ? reference.resolve() : null;
        if (resolve instanceof ResTypeOwner) {
            ResType type = ((ResTypeOwner) resolve).getResType(state);
            if (type != null && !processResType(type, processor, state)) return false;
        }
        return true;
    }

    private boolean processExistingType(@NotNull ResType type,
                                        @NotNull ResScopeProcessor processor,
                                        @NotNull ResolveState state) {
        PsiFile file = type.getContainingFile();
        if (!(file instanceof ResFile)) return true;
        PsiFile myFile = ObjectUtils.notNull(getContextFile(state), myElement.getContainingFile());
        if (!(myFile instanceof ResFile)) return true;
        boolean localResolve = true;
        if (type instanceof ResTypeReprDecl) type = ((ResTypeReprDecl) type).getType();
        if (type instanceof ResRecordType) {
            ResScopeProcessorBase delegate = createDelegate(processor);
            type.processDeclarations(delegate, ResolveState.initial(), null, myElement);
            List<ResTypeReferenceExp> structRefs = ContainerUtil.newArrayList();
            for (ResRecordVarDeclGroup d : ((ResRecordType) type).getRecordVarDeclGroupList()) {
                if (!processNamedElements(processor, state, d.getFieldVarDeclGroup().getFieldDefList(), localResolve))
                    return false;
            }
            if (!processCollectedRefs(type, structRefs, processor, state)) return false;
        }
        return true;
    }

    private boolean processCollectedRefs(@NotNull ResType type, @NotNull List<ResTypeReferenceExp> refs,
                                         @NotNull ResScopeProcessor processor, @NotNull ResolveState state) {
        for (ResTypeReferenceExp ref : refs) {
            if (!processInTypeRef(ref, type, processor, state)) return false;
        }
        return true;
    }

    @Nullable
    public static ResTypeReferenceExp getTypeReference(@Nullable ResType o) {
        if (o == null) return null;
        return o.getTypeReferenceExp();
    }

    @NotNull
    public ResolveState createContext() {
        return ResolveState.initial().put(CONTEXT, SmartPointerManager.getInstance(myElement.getProject())
                .createSmartPsiElementPointer(myElement));
    }

    private boolean processBlock(@NotNull ResScopeProcessor processor,
                                 @NotNull ResolveState state,
                                 boolean localResolve) {
        ResScopeProcessorBase delegate = createDelegate(processor);
        ResolveUtil.treeWalkUp(myElement, delegate);

        //process local parameters if we're in a local definition or an operation like thing (doesn't include module
        //params; that's in processModuleLevelEntities)
        processBlockParameters(myElement, delegate);
        return processNamedElements(processor, state, delegate.getVariants(), localResolve);
    }

    //Go plugin rolls this step into the "treeWalkUp" phase -- see processParameters in GoCompositeElementImpl.x
    //I just do it here for simplicity
    static boolean processBlockParameters(@NotNull ResCompositeElement e,
                                          @NotNull ResScopeProcessorBase processor) {
        ResMathDefnDecl def = PsiTreeUtil.getParentOfType(e, ResMathDefnDecl.class);
        ResOperationLikeNode operation = PsiTreeUtil.getParentOfType(e, ResOperationLikeNode.class);
        if (def != null) processDefinitionParams(processor, def);
        if (operation != null) processProgParamDecls(processor, operation.getParamDeclList());
        return true;
    }

    // TODO: Not sure why the logic here needs to be so complicated.. clean it up.
    /** Searches the specifications of any facility modules accessible from {@code file}. */
    public static boolean processFacilityImports(@NotNull ResFile file,
                                                 @NotNull ResScopeProcessor processor,
                                                 @NotNull ResolveState state) {
        List<ResModuleIdentifierSpec> usesItems = file.getModuleIdentifierSpecs();
        Set<ResModuleIdentifier> v = new LinkedHashSet<>();
        List<String> superModuleRefs = new ArrayList<>();
        if (file.getEnclosedModule() != null) {
            for (ResReferenceExp e : file.getEnclosedModule().getModuleHeaderReferences()) {
                superModuleRefs.add(e.getText());
            }
        }
        List<ResModuleDecl> superModuleDecls = new ArrayList<>();
        //get ModuleIdentifiers from facilities visible through any named uses items (remember: uses items currently
        //explicitly include header modules)
        for (ResModuleIdentifierSpec usesItem : usesItems) {
            PsiElement resolve = usesItem.getModuleIdentifier().resolve();

            if (resolve != null && resolve instanceof ResFile) {

                ResModuleDecl moduleDecl = ((ResFile) resolve).getEnclosedModule();
                if (moduleDecl == null) continue;
                if (superModuleRefs.contains(usesItem.getName())) {
                    superModuleDecls.add(moduleDecl);
                }
                for (ResFacilityDecl f : moduleDecl.getFacilities()) {
                    if (f.getModuleIdentifierList().size() != 2) continue;
                    v.add(f.getModuleIdentifierList().get(0));
                }
            }
        }

        //resolve into the ModuleIdentifiers named in each of the super modules' useslists looking for facilities.
        for (ResModuleDecl superModule : superModuleDecls) {
            for (ResModuleIdentifierSpec usesItem : superModule.getModuleIdentifierSpecs()) {
                PsiElement resolve = usesItem.getModuleIdentifier().resolve();
                if (resolve != null && resolve instanceof ResFile) {

                    ResModuleDecl moduleDecl = ((ResFile) resolve).getEnclosedModule();
                    if (moduleDecl == null) continue;
                    for (ResFacilityDecl f : moduleDecl.getFacilities()) {
                        if (f.getModuleIdentifierList().size() != 2) continue;
                        v.add(f.getModuleIdentifierList().get(0));
                    }
                }
            }
        }

        //now get ModuleIdentifiers from any local facilities
        for (ResFacilityDecl facility : file.getFacilities()) {
            //skip this facility if for some reason it's malformed: i.e. missing the spec or impl;
            //size 2 implies both are present and accounted for
            if (facility.getModuleIdentifierList().size() != 2) continue;
            v.add(facility.getModuleIdentifierList().get(0));
            if (!facility.getExtensionPairingList().isEmpty()) {
                for (ResExtensionPairing ext : facility.getExtensionPairingList()) {
                    if (ext.getModuleIdentifierList().size() == 2) {
                        v.add(ext.getModuleIdentifierList().get(0));
                    }
                }
            }
        }

        //resolve through their specifications
        for (ResModuleIdentifier identifier : v) {
            PsiElement resolve = identifier.resolve();
            if (resolve == null || !(resolve instanceof ResFile)) continue;
            if (!processModuleLevelEntities((ResFile) resolve, processor, state, true)) return false;
        }
        return true;
    }

    public static boolean processUsesImports(@NotNull ResFile file,
                                             @NotNull ResScopeProcessor processor,
                                             @NotNull ResolveState state) {
        if (file.getEnclosedModule() == null) return true;
        return processUsesImports(file.getEnclosedModule(), processor, state);
    }

    //OK: So it looks like this is the method that's going to have to initiate the search into the super modules...
    //Update: Ok so at least this method is doing what I *think* it needs to be doing right now. Don't get me wrong its a godawful
    //mess, but at least its working as I expect for the moment. TODO: Clean it up, improve names etc.
    private static boolean processUsesImports(@NotNull ResModuleDecl moduleDecl,
                                              @NotNull ResScopeProcessor processor,
                                              @NotNull ResolveState state) {
        List<ResModuleIdentifierSpec> usesItems = moduleDecl.getModuleIdentifierSpecs();

        List<ResReferenceExp> headerModules = moduleDecl.getModuleHeaderReferences();
        for (ResModuleIdentifierSpec o : usesItems) {
            //if (o.getAlias() != null) {
            //    if (!processor.execute(o, state.put(ACTUAL_NAME, o.getAlias().getText()))) return false;
            //}
            //else {
                PsiElement resolve = o.getModuleIdentifier().resolve();
                if (resolve != null && resolve instanceof ResFile) {
                    for (ResReferenceExp e : headerModules) {
                        //process the super module's uses clauses
                        List<ResModuleIdentifierSpec> superModuleUses = ((ResFile) resolve).getModuleIdentifierSpecs();

                        for (ResModuleIdentifierSpec e1 : superModuleUses) {
                            PsiElement eRes = e1.getModuleIdentifier().resolve();
                            if (eRes != null) {
                                if (!processModuleLevelEntities((ResFile) eRes, processor, state, false)) return false;
                            }
                        }
                    }
                    processor.execute(resolve, state.put(ACTUAL_NAME, o.getModuleIdentifier().getText()));
                    boolean forSuperModule = forSuperModule(moduleDecl, o.getName());
                    if (!processModuleLevelEntities((ResFile) resolve, processor, state, forSuperModule)) return false;
                }
            //}
        }
        return true;
    }

    /** Returns true if {@code currentUsesName} is named in a module's first line as a spec being implemented. */
    private static boolean forSuperModule(@NotNull ResModuleDecl module, @NotNull String currentUsesName) {
        for (ResReferenceExp e : module.getModuleHeaderReferences()) {
            if (e.getIdentifier().getText().equals(currentUsesName)) return true;
        }
        return false;
    }

    static boolean processModuleLevelEntities(@NotNull ResFile file,
                                              @NotNull ResScopeProcessor processor,
                                              @NotNull ResolveState state,
                                              boolean localProcessing) {
        return processModuleLevelEntities(file, processor, state, localProcessing, false);
    }

    static boolean processModuleLevelEntities(@NotNull ResFile file,
                                              @NotNull ResScopeProcessor processor,
                                              @NotNull ResolveState state,
                                              boolean localProcessing,
                                              boolean fromFacilities) {
        if (file.getEnclosedModule() == null) return true;
        return processModuleLevelEntities(file.getEnclosedModule(), processor, state, localProcessing, fromFacilities);
    }

    //TODO: Going to want to do some filtering here in the case where a uses clause initiates the processing
    // ... in which case if the module is a concept, only return the set of math
    //{defns}, if its facility -- then search {opproc decls} U {type reprs} U {math defns}.
    static boolean processModuleLevelEntities(@NotNull ResModuleDecl module,
                                              @NotNull ResScopeProcessor processor,
                                              @NotNull ResolveState state,
                                              boolean localProcessing,
                                              boolean fromFacility) {
        if (!processNamedElements(processor, state, module.getOperationLikeThings(), localProcessing, fromFacility)) return false;
        if (!processNamedElements(processor, state, module.getFacilities(), localProcessing, fromFacility)) return false;
        if (!processNamedElements(processor, state, module.getTypes(), localProcessing, fromFacility)) return false;

        //module parameter-like-things
        if (!processNamedElements(processor, state, module.getGenericTypeParams(), localProcessing, fromFacility)) return false;
        if (!processNamedElements(processor, state, module.getConstantParamDefs(), localProcessing, fromFacility)) return false;
        if (!processNamedElements(processor, state, module.getDefinitionParamSigs(), localProcessing, fromFacility)) return false;

        //TODO: Math defns, opers
        if (!processNamedElements(processor, state, module.getMathDefnSigs(), localProcessing, fromFacility)) return false;
        return true;
    }

    /** processing parameters of the definition we happen to be within */
    private static boolean processDefinitionParams(@NotNull ResScopeProcessorBase processor,
                                                   @NotNull ResMathDefnDecl o) {
        List<ResMathDefnSig> sigs = o.getSignatures();
        if (sigs.size() == 1) {
            ResMathDefnSig sig = o.getSignatures().get(0);
            if (!processDefinitionParams(processor, sig.getParameters())) return false;
        } //size > 1 ? then we're categorical; size == 0, we're null
        return true;
    }

    private static boolean processDefinitionParams(@NotNull ResScopeProcessorBase processor,
                                                   @NotNull List<ResMathVarDeclGroup> parameters) {
        for (ResMathVarDeclGroup declaration : parameters) {
            if (!processNamedElements(processor, ResolveState.initial(), declaration.getMathVarDefList(), true)) return false;
        }
        return true;
    }

    private static boolean processProgParamDecls(@NotNull ResScopeProcessorBase processor,
                                                 @NotNull List<ResParamDecl> parameters) {
        for (ResParamDecl declaration : parameters) {
            if (!processNamedElements(processor, ResolveState.initial(), declaration.getParamDefList(), true)) return false;
        }
        return true;
    }

    static boolean processNamedElements(@NotNull PsiScopeProcessor processor,
                                        @NotNull ResolveState state,
                                        @NotNull Collection<? extends ResNamedElement> elements,
                                        boolean localResolve) {
        return processNamedElements(processor, state, elements, localResolve, false);
    }

    static boolean processNamedElements(@NotNull PsiScopeProcessor processor,
                                        @NotNull ResolveState state,
                                        @NotNull Collection<? extends ResNamedElement> elements,
                                        boolean localResolve,
                                        boolean facilityResolve) {
        for (ResNamedElement definition : elements) {
            if ((localResolve || definition.isUsesClauseVisible() || facilityResolve) && !processor.execute(definition, state)) return false;
        }
        return true;
    }

    @NotNull
    private ResVarReference.ResVarProcessor createDelegate(@NotNull ResScopeProcessor processor) {
        return new ResVarReference.ResVarProcessor(getIdentifier(), myElement, processor.isCompletion(), true) {
            @Override
            protected boolean crossOff(@NotNull PsiElement e) {
                return e instanceof ResFieldDef || super.crossOff(e);
            }
        };
    }

    private String getName() {
        return myElement.getIdentifier().getText();
    }

    @Nullable
    private static PsiFile getContextFile(@NotNull ResolveState state) {
        SmartPsiElementPointer<ResReferenceExpBase> context = state.get(CONTEXT);
        return context != null ? context.getContainingFile() : null;
    }
}