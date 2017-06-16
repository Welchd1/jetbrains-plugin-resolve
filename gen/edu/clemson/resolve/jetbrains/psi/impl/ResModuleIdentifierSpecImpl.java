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

public class ResModuleIdentifierSpecImpl extends ResNamedElementImpl implements ResModuleIdentifierSpec {

  public ResModuleIdentifierSpecImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitModuleIdentifierSpec(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ResModuleIdentifier getModuleIdentifier() {
    return findNotNullChildByClass(ResModuleIdentifier.class);
  }

  @Override
  @Nullable
  public ResModuleLibraryIdentifier getModuleLibraryIdentifier() {
    return findChildByClass(ResModuleLibraryIdentifier.class);
  }

  @Override
  @Nullable
  public PsiElement getFrom() {
    return findChildByType(FROM);
  }

  @Nullable
  public ResModuleLibraryIdentifier getFromLibraryIdentifier() {
    return ResPsiImplUtil.getFromLibraryIdentifier(this);
  }

  @NotNull
  public String getName() {
    return ResPsiImplUtil.getName(this);
  }

  @Nullable
  public PsiElement getIdentifier() {
    return ResPsiImplUtil.getIdentifier(this);
  }

  public boolean shouldGoDeeper() {
    return ResPsiImplUtil.shouldGoDeeper(this);
  }

}
