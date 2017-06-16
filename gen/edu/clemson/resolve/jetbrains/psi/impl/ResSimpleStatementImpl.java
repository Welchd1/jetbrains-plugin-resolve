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

public class ResSimpleStatementImpl extends ResStatementImpl implements ResSimpleStatement {

  public ResSimpleStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitSimpleStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ResExp getExp() {
    return findChildByClass(ResExp.class);
  }

  @Override
  @Nullable
  public ResStatement getStatement() {
    return findChildByClass(ResStatement.class);
  }

  @Override
  @Nullable
  public PsiElement getSemicolon() {
    return findChildByType(SEMICOLON);
  }

}
