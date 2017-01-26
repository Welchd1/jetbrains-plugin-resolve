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

public class ResPrecisModuleDeclImpl extends ResAbstractModuleImpl implements ResPrecisModuleDecl {

  public ResPrecisModuleDeclImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitPrecisModuleDecl(this);
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
  public ResUsesList getUsesList() {
    return findChildByClass(ResUsesList.class);
  }

  @Override
  @NotNull
  public PsiElement getPrecis() {
    return findNotNullChildByType(PRECIS);
  }

  @Override
  @Nullable
  public PsiElement getEnd() {
    return findChildByType(END);
  }

}
