// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static edu.clemson.resolve.jetbrains.ResTypes.*;
import edu.clemson.resolve.jetbrains.psi.*;

public class ResMathPostfixDefnSigImpl extends ResAbstractMathSigImpl implements ResMathPostfixDefnSig {

  public ResMathPostfixDefnSigImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitMathPostfixDefnSig(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ResMathExp getMathExp() {
    return findNotNullChildByClass(ResMathExp.class);
  }

  @Override
  @NotNull
  public List<ResMathSymbolName> getMathSymbolNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResMathSymbolName.class);
  }

  @Override
  @NotNull
  public List<ResMathVarDecl> getMathVarDeclList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResMathVarDecl.class);
  }

  @Override
  @NotNull
  public PsiElement getColon() {
    return findNotNullChildByType(COLON);
  }

}
