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

public class ResConceptModuleDeclImpl extends ResAbstractModuleImpl implements ResConceptModuleDecl {

  public ResConceptModuleDeclImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitConceptModuleDecl(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ResConceptBlock getConceptBlock() {
    return findChildByClass(ResConceptBlock.class);
  }

  @Override
  @Nullable
  public ResRequiresClause getRequiresClause() {
    return findChildByClass(ResRequiresClause.class);
  }

  @Override
  @Nullable
  public ResSpecModuleParameters getSpecModuleParameters() {
    return findChildByClass(ResSpecModuleParameters.class);
  }

  @Override
  @Nullable
  public ResUsesList getUsesList() {
    return findChildByClass(ResUsesList.class);
  }

  @Override
  @NotNull
  public PsiElement getConcept() {
    return findNotNullChildByType(CONCEPT);
  }

  @Override
  @Nullable
  public PsiElement getEnd() {
    return findChildByType(END);
  }

}
