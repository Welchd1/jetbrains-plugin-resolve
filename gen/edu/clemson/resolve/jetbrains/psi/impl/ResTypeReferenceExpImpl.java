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
import com.intellij.psi.PsiReference;

public class ResTypeReferenceExpImpl extends ResCompositeElementImpl implements ResTypeReferenceExp {

  public ResTypeReferenceExpImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitTypeReferenceExp(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

  @NotNull
  public PsiReference getReference() {
    return ResPsiImplUtil.getReference(this);
  }

  @Nullable
  public ResTypeReferenceExp getQualifier() {
    return ResPsiImplUtil.getQualifier(this);
  }

  @Nullable
  public PsiElement resolve() {
    return ResPsiImplUtil.resolve(this);
  }

}
