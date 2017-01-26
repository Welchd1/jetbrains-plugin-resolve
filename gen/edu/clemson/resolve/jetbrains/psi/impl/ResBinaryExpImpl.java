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

public class ResBinaryExpImpl extends ResExpImpl implements ResBinaryExp {

  public ResBinaryExpImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitBinaryExp(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ResExp> getExpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResExp.class);
  }

  @Override
  @NotNull
  public ResExp getLeft() {
    List<ResExp> p1 = getExpList();
    return p1.get(0);
  }

  @Override
  @Nullable
  public ResExp getRight() {
    List<ResExp> p1 = getExpList();
    return p1.size() < 2 ? null : p1.get(1);
  }

}
