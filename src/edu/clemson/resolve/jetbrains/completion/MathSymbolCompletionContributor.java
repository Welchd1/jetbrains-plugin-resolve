package edu.clemson.resolve.jetbrains.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.lookup.LookupElementPresentation;
import com.intellij.codeInsight.lookup.LookupElementRenderer;
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
        SYMBOL_MAP.put("Downarrow", "⇓");

    }

    public boolean invokeAutoPopup(@NotNull PsiElement position, char typeChar) {
        return typeChar == '\\';
    }
}
