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

public class ResOperationDeclImpl extends ResAbstractOperationLikeNode implements ResOperationDecl {

  public ResOperationDeclImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitOperationDecl(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ResEnsuresClause getEnsuresClause() {
    return findChildByClass(ResEnsuresClause.class);
  }

  @Override
  @NotNull
  public List<ResParamDecl> getParamDeclList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResParamDecl.class);
  }

  @Override
  @Nullable
  public ResRequiresClause getRequiresClause() {
    return findChildByClass(ResRequiresClause.class);
  }

  @Override
  @Nullable
  public ResType getType() {
    return findChildByClass(ResType.class);
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
  @NotNull
  public PsiElement getOperation() {
    return findNotNullChildByType(OPERATION);
  }

  @Override
  @Nullable
  public PsiElement getRparen() {
    return findChildByType(RPAREN);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}
