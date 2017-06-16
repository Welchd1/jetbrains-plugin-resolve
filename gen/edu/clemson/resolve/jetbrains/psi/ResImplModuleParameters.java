// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ResImplModuleParameters extends ResModuleParameters {

  @NotNull
  List<ResOperationDecl> getOperationDeclList();

  @NotNull
  List<ResParamDecl> getParamDeclList();

  @NotNull
  PsiElement getLparen();

  @Nullable
  PsiElement getRparen();

}
