package edu.clemson.resolve.jetbrains.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import edu.clemson.resolve.jetbrains.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class ResAbstractMathSigImpl extends ResMathNamedElementImpl implements ResMathDefnSig {

    public ResAbstractMathSigImpl(@NotNull ASTNode node) {
        super(node);
    }

    @NotNull
    @Override
    public List<ResMathVarDeclGroup> getParameters() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ResMathVarDeclGroup.class);
    }

    @Nullable
    @Override
    public ResMathExp getMathTypeExp() {
        return findChildByClass(ResMathExp.class);
    }

    @Nullable
    public String getCanonicalName() {
        if (this instanceof ResMathOutfixDefnSig) {
            ResMathOutfixDefnSig o = (ResMathOutfixDefnSig)this;
            List<ResMathSymbolName> l = o.getMathSymbolNameList();
            if (l.size() != 2) return null;
            String placeholder = joinParams(o.getParameters());
            return l.get(0).getText() + placeholder + l.get(1).getText();
        }
        else if (this instanceof ResMathPostfixDefnSig) {
            ResMathPostfixDefnSig o = (ResMathPostfixDefnSig)this;
            List<ResMathSymbolName> l = o.getMathSymbolNameList();
            if (l.size() != 2) return null;
            String outer = "∙ ";
            String inner = joinParams(o.getParameters());
            return outer + l.get(0).getText() + inner + l.get(1).getText();
        }
        return super.getName();
    }

    @NotNull
    private String joinParams(@NotNull List<ResMathVarDeclGroup> l) {
        String result = "";
        boolean first = true;
        for (ResMathVarDeclGroup g : l) {
            for (ResMathVarDef d : g.getMathVarDefList()) {
                if (first) {
                    result = "∙";
                    first = false;
                }
                else {
                    result = result + ", ∙";
                }
            }
        }
        return result;
    }
}
