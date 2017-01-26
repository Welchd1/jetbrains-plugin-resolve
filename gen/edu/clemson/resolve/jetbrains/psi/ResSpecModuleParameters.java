// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ResSpecModuleParameters extends ResModuleParameters {

  @NotNull
  List<ResMathStandardDefnDecl> getMathStandardDefnDeclList();

  @NotNull
  List<ResParamDecl> getParamDeclList();

  @NotNull
  List<ResTypeParamDecl> getTypeParamDeclList();

  @NotNull
  PsiElement getLparen();

  @Nullable
  PsiElement getRparen();

}
