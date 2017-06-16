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

public class ResWhileStatementImpl extends ResStatementImpl implements ResWhileStatement {

  public ResWhileStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitWhileStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ResChangingClause getChangingClause() {
    return findChildByClass(ResChangingClause.class);
  }

  @Override
  @Nullable
  public ResDecreasingClause getDecreasingClause() {
    return findChildByClass(ResDecreasingClause.class);
  }

  @Override
  @Nullable
  public ResExp getExp() {
    return findChildByClass(ResExp.class);
  }

  @Override
  @Nullable
  public ResMaintainingClause getMaintainingClause() {
    return findChildByClass(ResMaintainingClause.class);
  }

  @Override
  @NotNull
  public List<ResStatement> getStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResStatement.class);
  }

  @Override
  @Nullable
  public PsiElement getSemicolon() {
    return findChildByType(SEMICOLON);
  }

  @Override
  @NotNull
  public PsiElement getWhile() {
    return findNotNullChildByType(WHILE);
  }

  @Override
  @Nullable
  public PsiElement getDo() {
    return findChildByType(DO);
  }

  @Override
  @Nullable
  public PsiElement getEnd() {
    return findChildByType(END);
  }

}
