// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ResOperationDecl extends ResOperationLikeNode {

  @Nullable
  ResEnsuresClause getEnsuresClause();

  @NotNull
  List<ResParamDecl> getParamDeclList();

  @Nullable
  ResRequiresClause getRequiresClause();

  @Nullable
  ResType getType();

  @Nullable
  PsiElement getColon();

  @Nullable
  PsiElement getLparen();

  @NotNull
  PsiElement getOperation();

  @Nullable
  PsiElement getRparen();

  @NotNull
  PsiElement getIdentifier();

}
