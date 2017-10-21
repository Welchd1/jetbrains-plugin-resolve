package edu.clemson.resolve.jetbrains.completion;

import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.completion.PrefixMatcher;
import com.intellij.codeInsight.completion.PrioritizedLookupElement;
import com.intellij.codeInsight.completion.impl.CamelHumpMatcher;
import com.intellij.codeInsight.completion.util.ParenthesesInsertHandler;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.lookup.LookupElementPresentation;
import com.intellij.codeInsight.lookup.LookupElementRenderer;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.Function;
import com.intellij.util.ui.UIUtil;
import edu.clemson.resolve.jetbrains.RESOLVEIcons;
import edu.clemson.resolve.jetbrains.psi.*;
import edu.clemson.resolve.jetbrains.psi.impl.ResPsiImplUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class RESOLVECompletionUtil {

  public static final int VAR_PRIORITY = 30;
  public static final int FUNCTION_PRIORITY = 15;
  public static final int FACILITY_PRIORITY = 5;
  public static final int DEFINITION_PRIORITY = 10;
  public static final int TYPE_PRIORITY = 20;
  public static final int KEYWORD_PRIORITY = 1;

  private static class Lazy {
    private static final QualifierInsertHandler FACILITY_OR_MODULE_INSERT_HANDLER =
        new QualifierInsertHandler("::", true);
  }

  private static final InsertHandler<LookupElement> FUNCTION_INSERT_HANDLER =
      new InsertHandler<LookupElement>() {
        @Override
        public void handleInsert(InsertionContext context, LookupElement item) {
          PsiElement element = item.getPsiElement();
          if (!(element instanceof ResOperationLikeNode)) return;
          ResOperationLikeNode elementAsOp = (ResOperationLikeNode) element;
          int paramsCount = elementAsOp.getParamDeclList().size();
          InsertHandler<LookupElement> handler =
              paramsCount == 0
                  ? ParenthesesInsertHandler.NO_PARAMETERS
                  : ParenthesesInsertHandler.WITH_PARAMETERS;
          handler.handleInsert(context, item);
        }
      };

  private static final LookupElementRenderer<LookupElement> VARIABLE_RENDERER =
      new LookupElementRenderer<LookupElement>() {
        @Override
        public void renderElement(LookupElement element, LookupElementPresentation p) {
          PsiElement o = element.getPsiElement();
          if (!(o instanceof ResNamedElement)) return;
          ResNamedElement v = (ResNamedElement) o;
          ResType type = v.getResType(null);
          String text = ResPsiImplUtil.getText(type);
          Icon icon =
              v instanceof ResMathVarDef
                  ? RESOLVEIcons.VARIABLE
                  : v instanceof ResVarDef
                      ? RESOLVEIcons.VARIABLE
                      : v instanceof ResExemplarDecl
                          ? RESOLVEIcons.EXEMPLAR
                          : v instanceof ResParamDef
                              ? RESOLVEIcons.PARAMETER
                              : v instanceof ResTypeParamDecl
                                  ? RESOLVEIcons.GENERIC_TYPE
                                  : v instanceof ResFieldDef ? RESOLVEIcons.RECORD_FIELD : null;
          if (v instanceof ResMathVarDef) {
            //Todo: Need to write a getResTypeInner method and put it into the psi util class;
            //should be called from ResMathVarDefImpl...
            //typeText += v.get
          }
          p.setIcon(icon);
          p.setTailText(calcTailTextForFields(v), true);
          p.setTypeText(text);
          p.setTypeGrayed(true);
          p.setItemText(element.getLookupString());
        }
      };

  private static final LookupElementRenderer<LookupElement> FUNCTION_RENDERER =
      new LookupElementRenderer<LookupElement>() {
        @Override
        public void renderElement(LookupElement element, LookupElementPresentation p) {
          PsiElement o = element.getPsiElement();
          if (!(o instanceof ResOperationLikeNode)) return;
          ResOperationLikeNode oAsOp = (ResOperationLikeNode) o;
          String typeText = "";
          String paramText = "";

          paramText +=
              "("
                  + StringUtil.join(
                      oAsOp.getParamDeclList(),
                      new Function<ResParamDecl, String>() {
                        @Override
                        public String fun(ResParamDecl resParamDecl) {
                          return resParamDecl.getText();
                        }
                      },
                      ", ")
                  + ")";

          ResType type = oAsOp.getType();
          if (type != null) typeText = type.getText();

          p.setIcon(oAsOp.getIcon(0));
          p.setTypeText(typeText);
          p.setTypeGrayed(true);
          //p.setTailText(calcTailText(f), true);
          p.setItemText(element.getLookupString() + paramText);
        }
      };

  private static final LookupElementRenderer<LookupElement> DEFINITION_RENDERER =
      new LookupElementRenderer<LookupElement>() {
        @Override
        public void renderElement(LookupElement element, LookupElementPresentation p) {
          PsiElement o = element.getPsiElement();
          if (!(o instanceof ResMathDefnSig)) return;
          String rangeTypeText = "";
          ResMathDefnSig signature = (ResMathDefnSig) o;
          String typeText = "";

          //Todo, move the following printing business logic into a method somewhere in ResPsiImplUtil
          ResCompositeElement mathType = signature.getMathTypeExp();
          boolean first = true;
          for (ResMathVarDeclGroup grp : signature.getParameters()) {
            if (grp.getMathExp() != null) {
              for (PsiElement e : grp.getMathVarDefList()) {
                if (first) {
                  first = false;
                  typeText += grp.getMathExp().getText();
                } else {
                  typeText += " × " + grp.getMathExp().getText();
                }
              }
            }
          }
          if (mathType != null) rangeTypeText = mathType.getText();
          if (!typeText.equals("")) typeText += " ⟶ ";
          typeText += rangeTypeText;
          p.setIcon(RESOLVEIcons.DEF);
          p.setTypeText(rangeTypeText);
          p.setTypeGrayed(true);
          // p.setTailText(calcTailText(f), true);
          String name =
              signature instanceof ResMathOutfixDefnSig
                      || signature instanceof ResMathPostfixDefnSig
                  ? signature.getCanonicalName()
                  : element.getLookupString();
          p.setItemText(name + " : " + typeText);
        }
      };

  @NotNull
  static PrefixMatcher createPrefixMatcher(@NotNull PrefixMatcher original) {
    return new CamelHumpMatcher(original.getPrefix(), true);
  }

  @NotNull
  static LookupElement createOpLikeLookupElement(
      @NotNull ResOperationLikeNode f,
      @NotNull String lookupString,
      @Nullable InsertHandler<LookupElement> h,
      double priority) {
    return PrioritizedLookupElement.withPriority(
        LookupElementBuilder.createWithSmartPointer(lookupString, f)
            .withRenderer(FUNCTION_RENDERER)
            .withInsertHandler(h != null ? h : FUNCTION_INSERT_HANDLER),
        priority);
  }

  @Nullable
  static LookupElement createVariableLikeLookupElement(@NotNull ResNamedElement v) {
    String name = v.getName();
    if (StringUtil.isEmpty(name)) return null;
    return createVariableLikeLookupElement(v, name, null, VAR_PRIORITY);
  }

  @NotNull
  static LookupElement createVariableLikeLookupElement(
      @NotNull ResNamedElement v,
      @NotNull String lookupString,
      @Nullable InsertHandler<LookupElement> insertHandler,
      double priority) {
    return PrioritizedLookupElement.withPriority(
        LookupElementBuilder.createWithSmartPointer(lookupString, v)
            .withRenderer(VARIABLE_RENDERER)
            .withInsertHandler(insertHandler),
        priority);
  }

  @NotNull
  static LookupElement createMathDefinitionLookupElement(
      @NotNull ResMathDefnSig signature, @NotNull String lookupString, double priority) {
    return PrioritizedLookupElement.withPriority(
        LookupElementBuilder.createWithSmartPointer(lookupString, signature)
            .withRenderer(DEFINITION_RENDERER)
            .withInsertHandler(new MathSymbolInsertHandler()),
        priority);
  }

  @NotNull
  static LookupElement createMathVarLookupElement(@NotNull ResMathVarDef v) {
    return PrioritizedLookupElement.withPriority(
        LookupElementBuilder.createWithSmartPointer(v.getMathSymbolName().getText(), v)
            .withRenderer(VARIABLE_RENDERER)
            .withInsertHandler(new MathSymbolInsertHandler()),
        VAR_PRIORITY);
  }

  @NotNull
  static LookupElement createTypeLookupElement(@NotNull ResNamedElement t) {
    return createTypeLookupElement(t, StringUtil.notNullize(t.getName()), null, TYPE_PRIORITY);
  }

  @NotNull
  private static LookupElement createTypeLookupElement(
      @NotNull ResNamedElement t,
      @NotNull String lookupString,
      @Nullable InsertHandler<LookupElement> handler,
      double priority) {
    LookupElementBuilder builder =
        LookupElementBuilder.createWithSmartPointer(lookupString, t)
            .withInsertHandler(handler)
            .withIcon(t.getIcon(0));
    return PrioritizedLookupElement.withPriority(builder, priority);
  }

  @Nullable
  static LookupElement createFacilityLookupElement(@NotNull ResFacilityDecl facility) {
    return createFacilityLookupElement(facility, facility.getIdentifier().getText());
  }

  @Nullable
  static LookupElement createResModuleLookupElement(@NotNull ResModuleDecl module) {
    return createResModuleLookupElement(module, module.getName());
  }

  @Nullable
  private static LookupElement createResModuleLookupElement(
      @NotNull ResModuleDecl module, String name) {
    return PrioritizedLookupElement.withPriority(
        LookupElementBuilder.create(name)
            .withInsertHandler(Lazy.FACILITY_OR_MODULE_INSERT_HANDLER)
            .withIcon(module.getIcon(0)),
        FACILITY_PRIORITY);
  }

  @Nullable
  private static LookupElement createFacilityLookupElement(
      @NotNull ResFacilityDecl facility, @NotNull String name) {
    return PrioritizedLookupElement.withPriority(
        LookupElementBuilder.create(name)
            .withInsertHandler(Lazy.FACILITY_OR_MODULE_INSERT_HANDLER)
            .withIcon(RESOLVEIcons.FACILITY),
        FACILITY_PRIORITY);
  }

  @Nullable
  private static String calcTailTextForFields(@NotNull ResNamedElement v) {
    String name = null;
    if (v instanceof ResFieldDef) {
      ResTypeLikeNodeDecl spec = PsiTreeUtil.getParentOfType(v, ResTypeLikeNodeDecl.class);
      name = spec != null ? spec.getName() : null;
    }
    return StringUtil.isNotEmpty(name) ? " " + UIUtil.rightArrow() + " " + name : null;
  }

  @NotNull
  public static LookupElementBuilder createDirectoryLookupElement(@NotNull PsiDirectory directory) {
    return LookupElementBuilder.createWithSmartPointer(directory.getName(), directory)
        .withIcon(RESOLVEIcons.DIRECTORY);
  }

  @NotNull
  public static LookupElementBuilder createResolveFileLookupElement(@NotNull ResFile resolveFile) {
    return createResolveFileLookupElement(resolveFile, false);
  }

  @NotNull
  public static LookupElementBuilder createResolveFileLookupElement(
      @NotNull ResFile resolveFile, boolean forTypes) {
    LookupElementBuilder result =
        LookupElementBuilder.create(resolveFile.getVirtualFile().getNameWithoutExtension())
            .withIcon(resolveFile.getIcon(0));
    if (forTypes) {
      result = result.withInsertHandler(Lazy.FACILITY_OR_MODULE_INSERT_HANDLER);
    }
    return result;
  }
}
