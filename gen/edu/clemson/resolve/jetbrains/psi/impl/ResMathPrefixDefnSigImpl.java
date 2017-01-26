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

public class ResMathPrefixDefnSigImpl extends ResAbstractMathSigImpl implements ResMathPrefixDefnSig {

  public ResMathPrefixDefnSigImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitMathPrefixDefnSig(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ResMathExp getMathExp() {
    return findChildByClass(ResMathExp.class);
  }

  @Override
  @NotNull
  public List<ResMathSymbolName> getMathSymbolNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResMathSymbolName.class);
  }

  @Override
  @NotNull
  public List<ResMathVarDeclGroup> getMathVarDeclGroupList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResMathVarDeclGroup.class);
  }

  @Override
  @Nullable
  public PsiElement getColon() {
    return findChildByType(COLON);
  }

  @Override
  @Nullable
  public PsiElement getLparen() {
    return findChildByType(LPAREN);
  }

  @Override
  @Nullable
  public PsiElement getRparen() {
    return findChildByType(RPAREN);
  }

}
