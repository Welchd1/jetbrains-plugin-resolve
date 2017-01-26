package edu.clemson.resolve.jetbrains.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.openapi.project.DumbAware;
import com.intellij.patterns.*;
import com.intellij.patterns.PsiElementPattern.Capture;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.util.ProcessingContext;
import edu.clemson.resolve.jetbrains.ResTypes;
import edu.clemson.resolve.jetbrains.psi.*;
import edu.clemson.resolve.jetbrains.psi.impl.ResPsiImplUtil;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PlatformPatterns.psiElement;
import static com.intellij.patterns.PlatformPatterns.psiFile;
import static com.intellij.patterns.StandardPatterns.instanceOf;

public class RESOLVEKeywordCompletionContributor extends CompletionContributor implements DumbAware {

    public RESOLVEKeywordCompletionContributor() {

        extend(CompletionType.BASIC, usesPattern(),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "uses"));

        extend(CompletionType.BASIC, modulePattern(ResFacilityModuleDecl.class, ResFacilityBlock.class),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "Definition", "Implicit"));

        extend(CompletionType.BASIC, modulePattern(ResPrecisModuleDecl.class, ResPrecisBlock.class),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY,
                        "Implicit", "Definition", "Theorem", "Corollary", "Inductive", "Categorical"));

        extend(CompletionType.BASIC, modulePattern(ResPrecisExtensionModuleDecl.class, ResPrecisBlock.class),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY,
                        "Implicit", "Definition", "Theorem", "Corollary", "Inductive"));


        extend(CompletionType.BASIC, modulePattern(ResImplModuleDecl.class, ResImplBlock.class),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "Definition"));

        extend(CompletionType.BASIC, modulePattern(ResConceptModuleDecl.class, ResConceptBlock.class),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY,
                        "Definition", "Def", "Implicit", "constraints"));

        extend(CompletionType.BASIC, modulePattern(ResConceptExtensionModuleDecl.class, ResConceptBlock.class),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "Definition", "Def", "Implicit"));

        extend(CompletionType.BASIC, parameterModePattern(),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY,
                        "evaluates", "updates", "alters", "clears", "preserves", "restores", "replaces"));

        extend(CompletionType.BASIC, recordTypePattern(),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "Record"));

        extend(CompletionType.BASIC, typeParamPattern(),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "type"));

        extend(CompletionType.BASIC, definitionParameterPattern(),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "Definition"));

        extend(CompletionType.BASIC, operationParamPattern(),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "OperationDeclaration"));

        extend(CompletionType.BASIC, statementPattern(),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "While", "If"));

        extend(CompletionType.BASIC, concVariablePattern(),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "conc"));

        //extend(CompletionType.BASIC, elseStatementPattern(),
        //        new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "else"));

        extend(CompletionType.BASIC, mathCartProdPattern(),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "Cart_Prod"));

        extend(CompletionType.BASIC, variablePattern(),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "Var"));

        extend(CompletionType.BASIC, moduleRequiresPattern(),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "requires"));

        extend(CompletionType.BASIC, keywordAfterSiblings(ResTypeReprDecl.class, psiElement(ResRecordType.class)),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "conventions"));

        extend(CompletionType.BASIC, keywordAfterSiblings(ResTypeReprDecl.class,
                psiElement().andOr(psiElement(ResRecordType.class), psiElement(ResConventionsClause.class))),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "correspondence"));

        extend(CompletionType.BASIC, keywordAfterSiblings(
                ResTypeReprDecl.class,
                psiElement().andOr(psiElement(ResRecordType.class),
                        psiElement(ResConventionsClause.class),
                        psiElement(ResCorrespondenceClause.class))),
                new RESOLVEKeywordCompletionProvider(
                        RESOLVECompletionUtil.KEYWORD_PRIORITY, "initialization_repr"));

        extend(CompletionType.BASIC, modelInitialization(),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "initialization"));
        extend(CompletionType.BASIC, initializationEnsures(),
                new RESOLVEKeywordCompletionProvider(RESOLVECompletionUtil.KEYWORD_PRIORITY, "ensures"));
    }



    private static Capture<PsiElement> concVariablePattern() {
        return psiElement(ResTypes.IDENTIFIER)
                .inside(ResTypeReprDecl.class)
                .withParent(psiElement(ResTypes.MATH_SYMBOL_NAME)
                    .withParent(psiElement(ResTypes.MATH_REFERENCE_EXP).andNot(psiElement()
                            .withParent(psiElement(ResTypes.MATH_SELECTOR_EXP)))));
    }

    private static Capture<PsiElement> mathCartProdPattern() {
        return psiElement(ResTypes.IDENTIFIER)
                .withParent(psiElement(ResTypes.MATH_SYMBOL_NAME)
                        .withParent(psiElement(ResTypes.MATH_REFERENCE_EXP)));
    }

    private static Capture<PsiElement> definitionParameterPattern() {
        return psiElement(ResTypes.IDENTIFIER).withParent(psiElement().withParent(psiElement(ResParamDecl.class)
                .withParent(ResSpecModuleParameters.class)));
    }

    private static Capture<PsiElement> typeParamPattern() {
        return psiElement(ResTypes.IDENTIFIER).withParent(ResParameterMode.class).inside(ResSpecModuleParameters.class);
    }

    private static Capture<PsiElement> operationParamPattern() {
        return psiElement(ResTypes.IDENTIFIER).withParent(ResParameterMode.class).inside(ResImplModuleParameters.class);
    }

    private static Capture<PsiElement> modelInitialization() {
        return psiElement(ResTypes.IDENTIFIER)
                .withParent(psiElement(PsiErrorElement.class)
                        .afterSibling(psiElement(ResTypeModelDecl.class)
                                .withLastChild(psiElement().andOr(psiElement(ResExemplarDecl.class),
                                        psiElement(ResConstraintsClause.class)))));
    }

    private static Capture<PsiElement> initializationEnsures() {
        return psiElement(ResTypes.IDENTIFIER)
                .withParent(psiElement(PsiErrorElement.class).afterLeaf(psiElement(ResTypes.INITIALIZATION)));
    }

    private static Capture<PsiElement> modulePattern() {
        return onKeywordStartWithParent(ResFile.class);
    }

    //if the parent is some ResBlock, whose parent in turn is a module decl then its ok to suggest a uses.
    //however: when the module is a concept impl or concept ext impl (meaning it ends with 'for' <moduleIdent>
    //the first accepted child will be that particular moduleIdent.. so the extra conditions allow this pattern
    //to accept uses clauses after moduleIdents that are part of the overall module header + module param lists.
    private static Capture<PsiElement> usesPattern() {
        return onKeywordStartWithParent(psiElement(ResBlock.class)
                .withParent(ResModuleDecl.class)
                .andOr(psiElement().isFirstAcceptedChild(psiElement()),
                        psiElement().afterSibling(psiElement(ResModuleIdentifier.class)),
                        psiElement().afterSibling(psiElement(ResModuleParameters.class))));
    }

    private static <T extends ResCompositeElement> Capture<PsiElement> keywordAfterSiblings(
            Class<T> immediateSiblingClass,
            ElementPattern<? extends PsiElement> prevSiblings) {
        return psiElement(ResTypes.IDENTIFIER).withParent(psiElement(PsiErrorElement.class)
                .afterSibling(psiElement(immediateSiblingClass).withLastChild(prevSiblings)));
    }

    private static Capture<PsiElement> otherUsesPattern() {
        return onKeywordStartWithParent(ResBlock.class);
    }

    //TreeElementPattern
    //TODO: Debug tip for the cookbook, breakpoints in "TreeElementPattern.java" line 122..
    private static Capture<PsiElement> statementPattern() {
        //IntellijIdeaRulezzz is what the psiElement(ResTypes.IDENTIFIER) bit with previous sibling = "::"
        return psiElement(ResTypes.IDENTIFIER).andNot(psiElement().afterLeaf(psiElement(ResTypes.COLON_COLON)))
                .withParent(psiElement(ResTypes.REFERENCE_EXP)
                .withParent(psiElement(ResTypes.SIMPLE_STATEMENT)));
    }

    /*private static Capture<PsiElement> elseStatementPattern() {
        return psiElement(ResTypes.IDENTIFIER).withParent(psiElement(ResTypes.REFERENCE_EXP)
                .withParent(psiElement(ResTypes.SIMPLE_STATEMENT).withParent(psiElement(ResTypes.IF_STATEMENT))));
    }*/

    private static Capture<PsiElement> variablePattern() {
        return psiElement(ResTypes.IDENTIFIER).withParent(psiElement(ResTypes.REFERENCE_EXP)
                .isFirstAcceptedChild(psiElement()));
    }

    private static Capture<PsiElement> recordTypePattern() {
        return psiElement(ResTypes.IDENTIFIER).withParent(psiElement(ResTypes.TYPE_REFERENCE_EXP)
                .withParent(psiElement().withParent(ResTypeReprDecl.class)));
    }

    private static Capture<PsiElement> moduleRequiresPattern() {
        return psiElement(ResTypes.IDENTIFIER)
                .withParent(psiElement(PsiErrorElement.class)
                        .withParent(ResBlock.class)
                        .atStartOf(psiElement(ResBlock.class)));
    }

    private static Capture<PsiElement> parameterModePattern() {
        return psiElement(ResTypes.IDENTIFIER).withParent(ResParameterMode.class);
    }

    private static Capture<PsiElement> onKeywordStartWithParent(Class<? extends PsiElement> parentClass) {
        return onKeywordStartWithParent(psiElement(parentClass));
    }

    private static Capture<PsiElement> onKeywordStartWithParent(Capture<? extends PsiElement> parentPattern) {
        return psiElement(ResTypes.IDENTIFIER).withParent(psiElement(PsiErrorElement.class).withParent(parentPattern));
    }

    private static Capture<PsiElement> modulePattern(Class<? extends ResModuleDecl> moduleType,
                                                     Class<? extends ResBlock> blockType) {
        return onKeywordStartWithParent(psiElement(blockType).withParent(moduleType));
    }
}