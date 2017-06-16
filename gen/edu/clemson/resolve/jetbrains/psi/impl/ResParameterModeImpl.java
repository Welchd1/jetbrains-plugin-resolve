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

public class ResParameterModeImpl extends ResCompositeElementImpl implements ResParameterMode {

  public ResParameterModeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitParameterMode(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getAlters() {
    return findChildByType(ALTERS);
  }

  @Override
  @Nullable
  public PsiElement getClears() {
    return findChildByType(CLEARS);
  }

  @Override
  @Nullable
  public PsiElement getEvaluates() {
    return findChildByType(EVALUATES);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getPreserves() {
    return findChildByType(PRESERVES);
  }

  @Override
  @Nullable
  public PsiElement getReplaces() {
    return findChildByType(REPLACES);
  }

  @Override
  @Nullable
  public PsiElement getRestores() {
    return findChildByType(RESTORES);
  }

  @Override
  @Nullable
  public PsiElement getUpdates() {
    return findChildByType(UPDATES);
  }

}
