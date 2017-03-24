package edu.clemson.resolve.jetbrains.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveState;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import edu.clemson.resolve.jetbrains.psi.*;
import edu.clemson.resolve.jetbrains.psi.impl.ResMathVarLikeReference;
import edu.clemson.resolve.jetbrains.psi.impl.ResReference;
import edu.clemson.resolve.jetbrains.psi.impl.ResScopeProcessor;
import edu.clemson.resolve.jetbrains.psi.impl.ResTypeReference;
import edu.clemson.resolve.jetbrains.psi.impl.imports.ResModuleReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static edu.clemson.resolve.jetbrains.completion.RESOLVECompletionUtil.createPrefixMatcher;

public class RESOLVEReferenceCompletionProvider extends CompletionProvider<CompletionParameters> {

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters,
                                  ProcessingContext context,
                                  @NotNull CompletionResultSet set) {
        ResReferenceExpBase expression = PsiTreeUtil.getParentOfType(parameters.getPosition(), ResReferenceExpBase.class);
        if (expression != null) {
            set = set.withPrefixMatcher(createPrefixMatcher(set.getPrefixMatcher()));
            fillVariantsByReference(expression.getReference(), set);
        }
        //TODO: Commented out as of 3/24/17 can't seem to remember why I thought below was necessary..
        /*PsiElement parent = parameters.getPosition().getParent();
        if (parent != null) {
            fillVariantsByReference(parent.getReference(),
                    set.withPrefixMatcher(createPrefixMatcher(set.getPrefixMatcher())));
        }*/
    }

    private static void fillVariantsByReference(@Nullable PsiReference reference,
                                                @NotNull CompletionResultSet result) {
        if (reference == null) return;
        /*if (reference instanceof PsiMultiReference) {
            PsiReference[] references = ((PsiMultiReference)reference).getReferences();
            ContainerUtil.sort(references, PsiMultiReference.COMPARATOR);
            fillVariantsByReference(ArrayUtil.getFirstElement(references), result);
        }*/
        else if (reference instanceof ResReference) {
            ((ResReference) reference).processResolveVariants(new MyRESOLVEScopeProcessor(result, false) {
                @Override
                protected boolean accept(@NotNull PsiElement e) {
                    return !(e instanceof ResMathDefnSig);
                }
            });
        }
        else if (reference instanceof ResTypeReference) {
            PsiElement element = reference.getElement();
            ResScopeProcessor aProcessor = new MyRESOLVEScopeProcessor(result, true) {
                @Override
                protected boolean accept(@NotNull PsiElement e) {
                    return e instanceof ResTypeLikeNodeDecl ||
                            e instanceof ResFacilityDecl ||
                            e instanceof ResTypeParamDecl ||
                            e instanceof ResFile;
                }
            };
            ((ResTypeReference) reference).processResolveVariants(aProcessor);
        }
        else if (reference instanceof ResMathVarLikeReference) {

            //Handle wildcard math queries.
            //UPDATE: We don't need this actually. Just type control + space to provide a list of all possible
            //completions.

            ResScopeProcessor aProcessor = new MyRESOLVEScopeProcessor(result, true) {
                @Override
                protected boolean accept(@NotNull PsiElement e) {
                    return e instanceof ResMathDefnSig ||
                            e instanceof ResMathVarDef ||
                            e instanceof ResFieldDef ||
                            e instanceof ResParamDef ||
                            e instanceof ResTypeParamDecl ||
                            e instanceof ResExemplarDecl ||
                            e instanceof ResFile;
                }
            };
            ((ResMathVarLikeReference) reference).processResolveVariants(aProcessor);
        }
    }

    private static void addElement(@NotNull PsiElement o,
                                   @NotNull ResolveState state,
                                   boolean forTypes,
                                   @NotNull CompletionResultSet set) {
        LookupElement lookup = createLookupElement(o, state, forTypes);
        if (lookup != null) {
            set.addElement(lookup);
        }
    }

    @Nullable
    private static LookupElement createLookupElement(@NotNull PsiElement o,
                                                     @NotNull ResolveState state,
                                                     boolean forTypes) {
        if (o instanceof ResNamedElement) {
            if (o instanceof ResMathDefnSig) {
                String name = ((ResMathDefnSig) o).getName();
                if (name != null) {
                    return RESOLVECompletionUtil.createMathDefinitionLookupElement((ResMathDefnSig) o, name,
                            RESOLVECompletionUtil.DEFINITION_PRIORITY);
                }
            }
            else if (o instanceof ResMathVarDef) {
                return RESOLVECompletionUtil.createMathVarLookupElement((ResMathVarDef) o);
            }
            else if (o instanceof ResTypeLikeNodeDecl || o instanceof ResTypeParamDecl) {
                return RESOLVECompletionUtil.createTypeLookupElement((ResNamedElement) o);
            }
            else if (o instanceof ResFacilityDecl) {
                return RESOLVECompletionUtil.createFacilityLookupElement(((ResFacilityDecl) o));
            }
            else if (o instanceof ResModuleDecl) {
                return RESOLVECompletionUtil.createResModuleLookupElement((ResModuleDecl) o);
            }
            else if (o instanceof ResOperationLikeNode) {
                String name = ((ResOperationLikeNode) o).getName();
                if (name != null) {
                    return RESOLVECompletionUtil.createOpLikeLookupElement((ResOperationLikeNode) o, name, null,
                            RESOLVECompletionUtil.FUNCTION_PRIORITY);
                }
            }
            else {
                return RESOLVECompletionUtil.createVariableLikeLookupElement((ResNamedElement) o);
            }
        }
        /**
         * If you look in {@link ResModuleReference#createLookupItem(PsiElement)} you'll see
         * handling of whats below there as well.. this one is here for {@link ResReference}s and
         * {@link ResTypeReference}s (for instance, modules/psiFiles) can be referenced in a type qualifier or in
         * a facility decl, etc.
         */
        else if (o instanceof ResFile) {
            return RESOLVECompletionUtil.createResolveFileLookupElement((ResFile) o, forTypes);
        }
        return null;
    }

    private static class MyRESOLVEScopeProcessor extends ResScopeProcessor {

        private final CompletionResultSet result;
        private final boolean forTypes;

        MyRESOLVEScopeProcessor(@NotNull CompletionResultSet result, boolean forTypes) {
            this.result = result;
            this.forTypes = forTypes;
        }

        @Override
        public boolean execute(@NotNull PsiElement o, @NotNull ResolveState state) {
            if (accept(o)) {
                addElement(o, state, forTypes, result);
            }
            return true;
        }

        protected boolean accept(@NotNull PsiElement e) {
            return true;
        }

        @Override
        public boolean isCompletion() {
            return true;
        }
    }
}