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

public class ResPrecisExtensionModuleDeclImpl extends ResAbstractModuleImpl implements ResPrecisExtensionModuleDecl {

  public ResPrecisExtensionModuleDeclImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitPrecisExtensionModuleDecl(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ResPrecisBlock getPrecisBlock() {
    return findChildByClass(ResPrecisBlock.class);
  }

  @Override
  @Nullable
  public ResReferenceExp getReferenceExp() {
    return findChildByClass(ResReferenceExp.class);
  }

  @Override
  @Nullable
  public ResUsesList getUsesList() {
    return findChildByClass(ResUsesList.class);
  }

  @Override
  @NotNull
  public PsiElement getExtension() {
    return findNotNullChildByType(EXTENSION);
  }

  @Override
  @Nullable
  public PsiElement getEnd() {
    return findChildByType(END);
  }

  @Override
  @Nullable
  public PsiElement getFor() {
    return findChildByType(FOR);
  }

}
