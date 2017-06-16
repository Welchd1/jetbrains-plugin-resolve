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
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;

public class ResConceptBlockImpl extends ResCompositeElementImpl implements ResConceptBlock {

  public ResConceptBlockImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitConceptBlock(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ResConstraintsClause> getConstraintsClauseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResConstraintsClause.class);
  }

  @Override
  @NotNull
  public List<ResMathStandardDefnDecl> getMathStandardDefnDeclList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResMathStandardDefnDecl.class);
  }

  @Override
  @NotNull
  public List<ResOperationDecl> getOperationDeclList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResOperationDecl.class);
  }

  @Override
  @NotNull
  public List<ResTypeModelDecl> getTypeModelDeclList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResTypeModelDecl.class);
  }

  public boolean processDeclarations(PsiScopeProcessor processor, ResolveState state, PsiElement lastParent, PsiElement place) {
    return ResPsiImplUtil.processDeclarations(this, processor, state, lastParent, place);
  }

}
