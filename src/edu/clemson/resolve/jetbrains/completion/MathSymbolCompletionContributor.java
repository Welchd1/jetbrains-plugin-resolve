package edu.clemson.resolve.jetbrains.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.IElementTypePattern;
import com.intellij.patterns.PatternCondition;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import edu.clemson.resolve.jetbrains.ResTypes;
import edu.clemson.resolve.jetbrains.psi.ResTokenType;
import edu.clemson.resolve.jetbrains.psi.ResType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PlatformPatterns.*;
import static com.intellij.patterns.StandardPatterns.instanceOf;

public class MathSymbolCompletionContributor extends CompletionContributor {

    public MathSymbolCompletionContributor() {
        extend(CompletionType.BASIC, symbolInsertCommandPattern(), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull final CompletionParameters parameters,
                                          ProcessingContext context,
                                          @NotNull CompletionResultSet result) {
                //POPULATE RESULT SET WITH STUFF That USERS CAN COMPLETE WITH...
            }
        });
    }

    private static PsiElementPattern.Capture<PsiElement> symbolInsertCommandPattern() {
        return psiElement().withElementType(ResTypes.COLON);
    }


}
