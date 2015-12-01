package edu.clemson.resolve.plugin.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.completion.impl.CamelHumpMatcher;
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.lookup.LookupElementPresentation;
import com.intellij.codeInsight.lookup.LookupElementRenderer;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import edu.clemson.resolve.plugin.RESOLVEIcons;
import edu.clemson.resolve.plugin.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class RESOLVECompletionUtil {

    public static final int VAR_PRIORITY = 10;

    public static final int DEFINITION_PRIORITY = 15;

    public static final LookupElementRenderer<LookupElement> VARIABLE_RENDERER =
            new LookupElementRenderer<LookupElement>() {
                @Override
                public void renderElement(LookupElement element,
                                          LookupElementPresentation p) {
                    PsiElement o = element.getPsiElement();
                    if (!(o instanceof ResNamedElement)) return;
                    ResNamedElement v = (ResNamedElement)o;
                    String typeText = "";
                    Icon icon = v instanceof ResMathVarDef ? RESOLVEIcons.VARIABLE :
             /*       v instanceof ResParamDefinition ? RESOLVEIcons.PARAMETER :
                            v instanceof ResFieldDefinition ? RESOLVEIcons.FIELD :
                                    v instanceof ResReceiver ? RESOLVEIcons.RECEIVER :
                                            v instanceof ResConstDefinition ? RESOLVEIcons.CONSTANT :*/
                            null;

                    if (v instanceof ResMathVarDef) {
                        //Todo: Need to write a getResTypeInner method and put it into the psi util class;
                        //should be called from ResMathVarDefImpl...
                        //typeText += v.get
                    }
                    p.setIcon(icon);
                    //p.setTailText(calcTailTextForFields(v), true);
                    //p.setTypeText(text);
                    p.setTypeGrayed(true);
                    p.setItemText(element.getLookupString());
                }
            };

    public static final InsertHandler<LookupElement> DEFINITION_INSERT_HANDLER =
            new InsertHandler<LookupElement>() {
                @Override public void handleInsert(InsertionContext context,
                                                   LookupElement item) {
                    PsiElement element = item.getPsiElement();
                    if (!(element instanceof ResMathDefinitionSignature)) return;
                    ResMathDefinitionSignature signature = (ResMathDefinitionSignature)element;
                    int paramsCount = signature.getParameters().size();
                    //we don't want empty parens for nullary function applications
                    InsertHandler<LookupElement> handler =
                            paramsCount == 0 ?
                                    new BasicInsertHandler<LookupElement>() :
                                    ParenthesesInsertHandler.WITH_PARAMETERS;
                    handler.handleInsert(context, item);
                }
            };

    public static final LookupElementRenderer<LookupElement> DEFINITION_RENDERER =
            new LookupElementRenderer<LookupElement>() {
                @Override public void renderElement(LookupElement element,
                                                    LookupElementPresentation p) {
                    PsiElement o = element.getPsiElement();
                    if (!(o instanceof ResMathDefinitionSignature)) return;
                    String rangeTypeText = "";
                    ResMathDefinitionSignature signature = (ResMathDefinitionSignature)o;
                    String typeText = "";

                    ResCompositeElement mathType = signature.getMathTypeExp();
                    boolean first = true;
                    for (ResMathVarDeclGroup grp : signature.getParameters()) {
                        if (grp.getMathExp() != null) {
                            for (PsiElement e : grp.getMathVarDefList()) {
                                if (first) {
                                    first = false;
                                    typeText += grp.getMathExp().getText();
                                }
                                else {
                                    typeText +=  " * " +
                                            grp.getMathExp().getText();
                                }
                            }
                        }
                    }
                    if (mathType != null) rangeTypeText = mathType.getText();
                    if (!typeText.equals("")) typeText += " -> ";
                    typeText += rangeTypeText;
                    p.setIcon(RESOLVEIcons.DEF);
                    p.setTypeText(rangeTypeText);
                    p.setTypeGrayed(true);
                    // p.setTailText(calcTailText(f), true);
                    p.setItemText(element.getLookupString() + " : " + typeText);
                }
            };

    @NotNull public static CamelHumpMatcher createPrefixMatcher(
            @NotNull PrefixMatcher original) {
        return createPrefixMatcher(original.getPrefix());
    }

    @NotNull public static CamelHumpMatcher createPrefixMatcher(
            @NotNull String prefix) {
        return new CamelHumpMatcher(prefix, false);
    }

    @Nullable public static LookupElement createVariableLikeLookupElement(
            @NotNull ResNamedElement v) {
        String name = v.getName();
        if (StringUtil.isEmpty(name)) return null;
        return createVariableLikeLookupElement(v, name, /*v instanceof ResFieldDef
                ? new SingleCharInsertHandler(':') {
            @Override
            public void handleInsert(@NotNull InsertionContext context, LookupElement item) {
                PsiFile file = context.getFile();
                if (!(file instanceof ResFile)) return;
                context.commitDocument();
                int offset = context.getStartOffset();
                PsiElement at = file.findElementAt(offset);
                ResCompositeElement ref = PsiTreeUtil.getParentOfType(at, GoValue.class, GoReferenceExpression.class);
                if (ref instanceof ResRefExp && (((ResRefExp)ref).getQualifier() != null || GoPsiImplUtil.prevDot(ref))) {
                    return;
                }
                ResValue value = PsiTreeUtil.getParentOfType(at, ResValue.class);
                if (value == null || PsiTreeUtil.getPrevSiblingOfType(value, ResKey.class) != null) return;
                super.handleInsert(context, item);
            }
        } :*/ null, VAR_PRIORITY);
    }

    @NotNull public static LookupElement createVariableLikeLookupElement(
            @NotNull ResNamedElement v, @NotNull String lookupString,
            @Nullable InsertHandler<LookupElement> insertHandler,
            double priority) {
        return PrioritizedLookupElement.withPriority(LookupElementBuilder
                .createWithSmartPointer(lookupString, v)
                .withRenderer(VARIABLE_RENDERER)
                .withInsertHandler(insertHandler), priority);
    }

    @NotNull public static LookupElement createDefinitionLookupElement(
            @NotNull ResMathDefinitionSignature signature,
            @NotNull String lookupString,
            @Nullable InsertHandler<LookupElement> h,
            double priority) {
        return PrioritizedLookupElement.withPriority(LookupElementBuilder
                        .createWithSmartPointer(lookupString, signature)
                        .withRenderer(DEFINITION_RENDERER)
                        .withInsertHandler(h != null ? h : DEFINITION_INSERT_HANDLER),
                priority);
    }
}