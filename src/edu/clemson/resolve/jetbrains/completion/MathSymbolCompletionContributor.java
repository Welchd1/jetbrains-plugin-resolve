package edu.clemson.resolve.jetbrains.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.*;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.intellij.patterns.PlatformPatterns.*;

//TODO: Z and Q don't complete
public class MathSymbolCompletionContributor extends CompletionContributor {

    public static final Map<String, String> SYMBOL_MAP = new LinkedHashMap<>();

    public MathSymbolCompletionContributor() {
        populateMap();
        extend(CompletionType.BASIC, psiElement(), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull final CompletionParameters parameters,
                                          ProcessingContext context,
                                          @NotNull CompletionResultSet result) {
                Editor editor = parameters.getEditor();
                Document doc = editor.getDocument();
                if (parameters.getOffset() > 1 &&
                        doc.getCharsSequence().charAt(parameters.getOffset() - 1) == '\\') {
                    //so I think we want to pretty much add all elements in our symbol map
                    Map<String, String> x = SYMBOL_MAP;
                    for (Map.Entry<String, String> keyword : SYMBOL_MAP.entrySet()) {
                        result.addElement(createMathSymbolLookupElement(keyword.getKey(), keyword.getValue()));
                    }
                }
            }
        });
    }

    @NotNull
    private LookupElement createMathSymbolLookupElement(@NotNull final String symbolCommand, String symbol) {
        final InsertHandler<LookupElement> handler = createMathSymbolInsertHandler(symbolCommand, symbol);
        return createKeywordLookupElement(symbolCommand, symbol, handler);
    }

    @NotNull
    public static InsertHandler<LookupElement> createMathSymbolInsertHandler(
            @NotNull final String symbolCommand,
            @NotNull final String symbol) {
        return new InsertHandler<LookupElement>() {
            @Override
            public void handleInsert(@NotNull InsertionContext context, LookupElement item) {
                Editor editor = context.getEditor();
                if (context.getStartOffset() - 1 > 0) {
                    editor.getDocument().deleteString(context.getStartOffset() - 1, context.getTailOffset());
                    EditorModificationUtil.insertStringAtCaret(editor, symbol);
                }
            }
        };
    }

    @NotNull
    private static LookupElement createKeywordLookupElement(@NotNull final String symbolCommand,
                                                            @NotNull final String symbol,
                                                            @Nullable InsertHandler<LookupElement> insertHandler) {
        LookupElementBuilder builder = LookupElementBuilder.create(symbolCommand)
                .withBoldness(true)
                .withInsertHandler(insertHandler)
                .withRenderer(new LookupElementRenderer<LookupElement>() {
                    @Override
                    public void renderElement(LookupElement element, LookupElementPresentation p) {
                        p.setItemText(symbolCommand);
                        p.setTypeText(symbol);
                    }
                });
        return PrioritizedLookupElement.withPriority(builder, RESOLVECompletionUtil.VAR_PRIORITY);
    }

    private void populateMap() {
        //Arrows
        SYMBOL_MAP.put("leftarrow", "←");
        SYMBOL_MAP.put("Leftarrow", "⇐");
        SYMBOL_MAP.put("longleftarrow", "⟵");
        SYMBOL_MAP.put("Longleftarrow", "⟸");
        SYMBOL_MAP.put("rightarrow", "→");
        SYMBOL_MAP.put("Rightarrow", "⇒");
        SYMBOL_MAP.put("longrightarrow", "⟶");
        SYMBOL_MAP.put("Longrightarrow", "⟹");
        SYMBOL_MAP.put("leftrightarrow", "↔");
        SYMBOL_MAP.put("Leftrightarrow", "⇔");
        SYMBOL_MAP.put("longleftrightarrow", "⟷");
        SYMBOL_MAP.put("Longleftrightarrow", "⟺");
        SYMBOL_MAP.put("hookleftarrow", "↩");
        SYMBOL_MAP.put("hookrightarrow", "↪");
        SYMBOL_MAP.put("leftharpoondown", "↽");
        SYMBOL_MAP.put("rightharpoondown", "⇁");
        SYMBOL_MAP.put("leftharpoonup", "↼");
        SYMBOL_MAP.put("rightharpoonup", "⇀");
        SYMBOL_MAP.put("leftrightharpoons", "⇌");
        SYMBOL_MAP.put("leadsto", "↝");
        SYMBOL_MAP.put("downharpoonleft", "⇃");
        SYMBOL_MAP.put("downharpoonright", "⇂");
        SYMBOL_MAP.put("upharpoonleft", "↿");
        SYMBOL_MAP.put("upharpoonright", "↾");
        SYMBOL_MAP.put("uparrow", "↑");
        SYMBOL_MAP.put("Uparrow", "⇑");
        SYMBOL_MAP.put("downarrow", "↓");
        SYMBOL_MAP.put("Downarrow", "⇓");

        //Greek
        SYMBOL_MAP.put("alpha", "α");
        SYMBOL_MAP.put("beta", "β");
        SYMBOL_MAP.put("gamma", "γ");
        SYMBOL_MAP.put("delta", "δ");
        SYMBOL_MAP.put("epsilon", "ε");
        SYMBOL_MAP.put("zeta", "ζ");
        SYMBOL_MAP.put("eta", "η");
        SYMBOL_MAP.put("theta", "θ");
        SYMBOL_MAP.put("iota", "ι");
        SYMBOL_MAP.put("kappa", "κ");
        SYMBOL_MAP.put("mu", "μ");
        SYMBOL_MAP.put("nu", "ν");
        SYMBOL_MAP.put("xi", "ξ");
        SYMBOL_MAP.put("pi", "π");
        SYMBOL_MAP.put("rho", "ρ");
        SYMBOL_MAP.put("sigma", "σ");
        SYMBOL_MAP.put("tau", "τ");
        SYMBOL_MAP.put("phi", "ϕ");
        SYMBOL_MAP.put("varphi", "φ");
        SYMBOL_MAP.put("chi", "χ");
        SYMBOL_MAP.put("psi", "ψ");
        SYMBOL_MAP.put("omega", "ω");

        SYMBOL_MAP.put("Gamma", "Γ");
        SYMBOL_MAP.put("Delta", "Δ");
        SYMBOL_MAP.put("Theta", "Θ");
        SYMBOL_MAP.put("Lambda", "Λ");
        SYMBOL_MAP.put("Xi", "Ξ");
        SYMBOL_MAP.put("Sigma", "Σ");
        SYMBOL_MAP.put("Phi", "Φ");
        SYMBOL_MAP.put("Psi", "Ψ");
        SYMBOL_MAP.put("Omega", "Ω");

        //Letters
        SYMBOL_MAP.put("Bool", "\uD835\uDD39");
        SYMBOL_MAP.put("Complex", "ℂ");
        SYMBOL_MAP.put("Nat", "ℕ");
        SYMBOL_MAP.put("Rat", "ℚ");
        SYMBOL_MAP.put("Real", "ℝ");
        SYMBOL_MAP.put("Int", "ℤ");
        SYMBOL_MAP.put("Powerset", "℘");

        //Logic
        SYMBOL_MAP.put("wedge", "∧");
        SYMBOL_MAP.put("bigwedge", "⋀");
        SYMBOL_MAP.put("vee", "∨");
        SYMBOL_MAP.put("bigvee", "⋁");
        SYMBOL_MAP.put("neg", "¬");

        //Fundamental
        SYMBOL_MAP.put("forall", "∀");
        SYMBOL_MAP.put("exists", "∃");
        SYMBOL_MAP.put("vdash", "⊢");
        SYMBOL_MAP.put("lambda", "λ");
        SYMBOL_MAP.put("triangleq", "≜");
        SYMBOL_MAP.put("tricolon", "ː");

        //Punctuation and Brackets
        SYMBOL_MAP.put("langle", "⟨");
        SYMBOL_MAP.put("rangle", "⟩");
        SYMBOL_MAP.put("lceil", "⌈");
        SYMBOL_MAP.put("rceil", "⌉");
        SYMBOL_MAP.put("lcup", "⎝");
        SYMBOL_MAP.put("rcup", "⎠");
        SYMBOL_MAP.put("dblbar", "∥");

        //Operators
        SYMBOL_MAP.put("cap", "∩");
        SYMBOL_MAP.put("bigcap", "⋂");
        SYMBOL_MAP.put("cup", "∪");
        SYMBOL_MAP.put("bicup", "⋃");
        SYMBOL_MAP.put("sqcup", "⊔");
        SYMBOL_MAP.put("bigsqcup", "⨆");
        SYMBOL_MAP.put("sqcap", "⊓");
        SYMBOL_MAP.put("bigsqcap", "⨅");
        SYMBOL_MAP.put("propto", "∝");
        SYMBOL_MAP.put("uplus", "⊎");
        SYMBOL_MAP.put("biguplus", "⨄");
        SYMBOL_MAP.put("pm", "±");
        SYMBOL_MAP.put("mp", "∓");
        SYMBOL_MAP.put("times", "×");
        SYMBOL_MAP.put("div", "÷");
        SYMBOL_MAP.put("cdot", "⋅");
        SYMBOL_MAP.put("star", "⋆");
        SYMBOL_MAP.put("bullet", "∙");
        SYMBOL_MAP.put("circ", "∘");
        SYMBOL_MAP.put("oplus", "⊕");
        SYMBOL_MAP.put("bigoplus", "⨁");
        SYMBOL_MAP.put("bigoplus", "⊗");
        SYMBOL_MAP.put("bigotimes", "⨂");
        SYMBOL_MAP.put("odot", "⊙");
        SYMBOL_MAP.put("bigodot", "⨀");
        SYMBOL_MAP.put("ominus", "⊖");
        SYMBOL_MAP.put("sum", "∑");
        SYMBOL_MAP.put("prod", "∏");
        SYMBOL_MAP.put("coprod", "∐");
        SYMBOL_MAP.put("bowtie", "⋈");
        SYMBOL_MAP.put("ltimes", "⋉");
        SYMBOL_MAP.put("rtimes", "⋊");
        SYMBOL_MAP.put("boxtimes", "⊠");
        SYMBOL_MAP.put("blacksquare", "∎");
        SYMBOL_MAP.put("multimap", "⊸");
        SYMBOL_MAP.put("multimap", "⊸");

        //Relations
        SYMBOL_MAP.put("leq", "≤");
        SYMBOL_MAP.put("geq", "≥");
        SYMBOL_MAP.put("neq", "≠");
        SYMBOL_MAP.put("ll", "≪");
        SYMBOL_MAP.put("gg", "≫");
        SYMBOL_MAP.put("lesssim", "≲");
        SYMBOL_MAP.put("gtrsim", "≳");
        SYMBOL_MAP.put("lessapprox", "⪅");
        SYMBOL_MAP.put("gtrapprox", "⪆");
        SYMBOL_MAP.put("in", "∈");
        SYMBOL_MAP.put("notin", "∉");
        SYMBOL_MAP.put("subset", "⊂");
        SYMBOL_MAP.put("supset", "⊃");
        SYMBOL_MAP.put("subseteq", "⊆");
        SYMBOL_MAP.put("supseteq", "⊇");
        SYMBOL_MAP.put("sqsubset", "⊏");
        SYMBOL_MAP.put("sqsupset", "⊐");
        SYMBOL_MAP.put("sqsubseteq", "⊑");
        SYMBOL_MAP.put("sqsupseteq", "⊒");
        SYMBOL_MAP.put("sim", "∼");
        SYMBOL_MAP.put("doteq", "≐");
        SYMBOL_MAP.put("simeq", "≃");
        SYMBOL_MAP.put("approx", "≈");
        SYMBOL_MAP.put("asymp", "≍");
        SYMBOL_MAP.put("cong", "≅");
        SYMBOL_MAP.put("equiv", "≡");
        SYMBOL_MAP.put("preccurlyeq", "≼");
        SYMBOL_MAP.put("succcurlyeq", "≽");
        SYMBOL_MAP.put("triangleleft", "⊲");
        SYMBOL_MAP.put("triangleright", "⊳");
        SYMBOL_MAP.put("trianglelefteq", "⊴");
        SYMBOL_MAP.put("trianglerighteq", "⊵");
    }

    public boolean invokeAutoPopup(@NotNull PsiElement position, char typeChar) {
        return typeChar == '\\';
    }
}
