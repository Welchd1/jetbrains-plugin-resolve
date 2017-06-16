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

public class ResVarSpecImpl extends ResCompositeElementImpl implements ResVarSpec {

  public ResVarSpecImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitVarSpec(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ResType getType() {
    return findChildByClass(ResType.class);
  }

  @Override
  @NotNull
  public List<ResVarDef> getVarDefList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResVarDef.class);
  }

  @Override
  @Nullable
  public PsiElement getColon() {
    return findChildByType(COLON);
  }

}
