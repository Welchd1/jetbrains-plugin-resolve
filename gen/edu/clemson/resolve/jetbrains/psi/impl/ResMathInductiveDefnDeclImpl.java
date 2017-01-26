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

public class ResMathInductiveDefnDeclImpl extends ResAbstractMathDefnImpl implements ResMathInductiveDefnDecl {

  public ResMathInductiveDefnDeclImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitMathInductiveDefnDecl(this);
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
  @Nullable
  public ResMathInfixDefnSig getMathInfixDefnSig() {
    return findChildByClass(ResMathInfixDefnSig.class);
  }

  @Override
  @Nullable
  public ResMathOutfixDefnSig getMathOutfixDefnSig() {
    return findChildByClass(ResMathOutfixDefnSig.class);
  }

  @Override
  @Nullable
  public ResMathPostfixDefnSig getMathPostfixDefnSig() {
    return findChildByClass(ResMathPostfixDefnSig.class);
  }

  @Override
  @Nullable
  public ResMathPrefixDefnSig getMathPrefixDefnSig() {
    return findChildByClass(ResMathPrefixDefnSig.class);
  }

  @Override
  @NotNull
  public PsiElement getDefinition() {
    return findNotNullChildByType(DEFINITION);
  }

  @Override
  @NotNull
  public PsiElement getInductive() {
    return findNotNullChildByType(INDUCTIVE);
  }

  @Override
  @Nullable
  public PsiElement getIndBase() {
    return findChildByType(IND_BASE);
  }

  @Override
  @Nullable
  public PsiElement getIndHypo() {
    return findChildByType(IND_HYPO);
  }

  @Override
  @Nullable
  public PsiElement getIs() {
    return findChildByType(IS);
  }

}
