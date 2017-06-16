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
import com.intellij.psi.ResolveState;

public class ResVarDefImpl extends ResNamedElementImpl implements ResVarDef {

  public ResVarDefImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitVarDef(this);
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

  @Nullable
  public ResType getResTypeInner(ResolveState context) {
    return ResPsiImplUtil.getResTypeInner(this, context);
  }

  @Nullable
  public PsiReference getReference() {
    return ResPsiImplUtil.getReference(this);
  }

}
