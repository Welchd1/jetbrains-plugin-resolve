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

public class ResMathLambdaExpImpl extends ResMathExpImpl implements ResMathLambdaExp {

  public ResMathLambdaExpImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitMathLambdaExp(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ResMathExp getMathExp() {
    return findChildByClass(ResMathExp.class);
  }

  @Override
  @Nullable
  public ResMathVarDecl getMathVarDecl() {
    return findChildByClass(ResMathVarDecl.class);
  }

  @Override
  @Nullable
  public PsiElement getComma() {
    return findChildByType(COMMA);
  }

  @Override
  @NotNull
  public PsiElement getLambda() {
    return findNotNullChildByType(LAMBDA);
  }

}
