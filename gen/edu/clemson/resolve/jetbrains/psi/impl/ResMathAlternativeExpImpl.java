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

public class ResMathAlternativeExpImpl extends ResMathExpImpl implements ResMathAlternativeExp {

  public ResMathAlternativeExpImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitMathAlternativeExp(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ResMathAlternativesList getMathAlternativesList() {
    return findChildByClass(ResMathAlternativesList.class);
  }

  @Override
  @NotNull
  public PsiElement getDblLbrace() {
    return findNotNullChildByType(DBL_LBRACE);
  }

  @Override
  @Nullable
  public PsiElement getDblRbrace() {
    return findChildByType(DBL_RBRACE);
  }

}
