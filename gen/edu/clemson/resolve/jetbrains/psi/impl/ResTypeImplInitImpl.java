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

public class ResTypeImplInitImpl extends ResCompositeElementImpl implements ResTypeImplInit {

  public ResTypeImplInitImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitTypeImplInit(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ResEnsuresClause getEnsuresClause() {
    return findChildByClass(ResEnsuresClause.class);
  }

  @Override
  @NotNull
  public ResOpBlock getOpBlock() {
    return findNotNullChildByClass(ResOpBlock.class);
  }

  @Override
  @Nullable
  public ResRequiresClause getRequiresClause() {
    return findChildByClass(ResRequiresClause.class);
  }

  @Override
  @NotNull
  public PsiElement getSemicolon() {
    return findNotNullChildByType(SEMICOLON);
  }

  @Override
  @NotNull
  public PsiElement getEnd() {
    return findNotNullChildByType(END);
  }

  @Override
  @NotNull
  public PsiElement getInitialization() {
    return findNotNullChildByType(INITIALIZATION);
  }

}
