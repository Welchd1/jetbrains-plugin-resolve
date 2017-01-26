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

public class ResMathAlternativeItemExpImpl extends ResMathExpImpl implements ResMathAlternativeItemExp {

  public ResMathAlternativeItemExpImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitMathAlternativeItemExp(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ResMathExp> getMathExpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResMathExp.class);
  }

  @Override
  @NotNull
  public PsiElement getSemicolon() {
    return findNotNullChildByType(SEMICOLON);
  }

  @Override
  @Nullable
  public PsiElement getIf() {
    return findChildByType(IF);
  }

  @Override
  @Nullable
  public PsiElement getOtherwise() {
    return findChildByType(OTHERWISE);
  }

}
