package edu.clemson.resolve.jetbrains.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.template.Template;
import com.intellij.codeInsight.template.TemplateManager;
import com.intellij.codeInsight.template.impl.TemplateSettings;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.patterns.IElementTypePattern;
import com.intellij.patterns.PatternCondition;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ObjectUtils;
import com.intellij.util.ProcessingContext;
import edu.clemson.resolve.jetbrains.RESOLVEParserDefinition;
import edu.clemson.resolve.jetbrains.ResTypes;
import edu.clemson.resolve.jetbrains.psi.ResTokenType;
import edu.clemson.resolve.jetbrains.psi.ResType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.intellij.patterns.PlatformPatterns.*;
import static com.intellij.patterns.StandardPatterns.instanceOf;

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

    //@NotNull
    private LookupElement createMathSymbolLookupElement(@NotNull final String symbolCommand, String symbol) {
        final InsertHandler<LookupElement> handler = createMathSymbolInsertHandler(symbolCommand, symbol);
        return createKeywordLookupElement(symbolCommand, RESOLVECompletionUtil.VAR_PRIORITY, handler);
    }

    public static LookupElement createKeywordLookupElement(@NotNull final String symbolCommand,
                                                           int priority,
                                                           @Nullable InsertHandler<LookupElement> insertHandler) {
        LookupElementBuilder builder = LookupElementBuilder.create(symbolCommand)
                .withBoldness(true).withInsertHandler(insertHandler);
        return PrioritizedLookupElement.withPriority(builder, priority);
    }

    @Nullable
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

    private void populateMap() {
        SYMBOL_MAP.put("rightarrow", "→");
        SYMBOL_MAP.put("Rightarrow", "→");

    }

    public boolean invokeAutoPopup(@NotNull PsiElement position, char typeChar) {
        return typeChar == '\\';
    }
}
