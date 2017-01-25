package edu.clemson.resolve.jetbrains.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.patterns.IElementTypePattern;
import com.intellij.patterns.PatternCondition;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import edu.clemson.resolve.jetbrains.RESOLVEParserDefinition;
import edu.clemson.resolve.jetbrains.ResTypes;
import edu.clemson.resolve.jetbrains.psi.ResTokenType;
import edu.clemson.resolve.jetbrains.psi.ResType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PlatformPatterns.*;
import static com.intellij.patterns.StandardPatterns.instanceOf;

public class MathSymbolCompletionContributor extends CompletionContributor {

    public static final InsertHandler<LookupElement> MATH_SYMBOL_INSERT_HANDLER =
            new InsertHandler<LookupElement>() {
                @Override
                public void handleInsert(InsertionContext context, LookupElement element) {
                }
            };

    public MathSymbolCompletionContributor() {
        extend(CompletionType.BASIC, psiElement(), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull final CompletionParameters parameters,
                                          ProcessingContext context,
                                          @NotNull CompletionResultSet result) {
                Editor editor = parameters.getEditor();
                Document doc = editor.getDocument();
                if (parameters.getOffset() > 1 &&
                        doc.getCharsSequence().charAt(parameters.getOffset() - 1) == '\\') {
                    result.addElement(LookupElementBuilder.create("Hello"));
                }
            }
        });
    }

    public boolean invokeAutoPopup(@NotNull PsiElement position, char typeChar) {
        return typeChar == '\\';
    }
}
