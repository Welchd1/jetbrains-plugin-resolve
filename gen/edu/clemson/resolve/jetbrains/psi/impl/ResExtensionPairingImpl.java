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

public class ResExtensionPairingImpl extends ResCompositeElementImpl implements ResExtensionPairing {

  public ResExtensionPairingImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ResVisitor visitor) {
    visitor.visitExtensionPairing(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ResVisitor) accept((ResVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ResModuleIdentifier> getModuleIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResModuleIdentifier.class);
  }

  @Override
  @NotNull
  public List<ResModuleLibraryIdentifier> getModuleLibraryIdentifierList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ResModuleLibraryIdentifier.class);
  }

  @Override
  @Nullable
  public ResModuleRealizArgList getModuleRealizArgList() {
    return findChildByClass(ResModuleRealizArgList.class);
  }

  @Override
  @Nullable
  public ResModuleSpecArgList getModuleSpecArgList() {
    return findChildByClass(ResModuleSpecArgList.class);
  }

  @Override
  @NotNull
  public PsiElement getEnhanced() {
    return findNotNullChildByType(ENHANCED);
  }

  @Override
  @Nullable
  public PsiElement getExternally() {
    return findChildByType(EXTERNALLY);
  }

  @Override
  @Nullable
  public PsiElement getRealized() {
    return findChildByType(REALIZED);
  }

  @Nullable
  public ResFile resolveSpecification() {
    return ResPsiImplUtil.resolveSpecification(this);
  }

  @Nullable
  public ResFile resolveImplementation() {
    return ResPsiImplUtil.resolveImplementation(this);
  }

}
