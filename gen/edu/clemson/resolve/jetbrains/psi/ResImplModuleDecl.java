// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ResImplModuleDecl extends ResModuleDecl {

  @Nullable
  ResImplBlock getImplBlock();

  @Nullable
  ResImplModuleParameters getImplModuleParameters();

  @NotNull
  List<ResReferenceExp> getReferenceExpList();

  @Nullable
  ResRequiresClause getRequiresClause();

  @Nullable
  ResUsesList getUsesList();

  @NotNull
  PsiElement getRealization();

  @Nullable
  PsiElement getEnd();

  @Nullable
  PsiElement getFor();

  @Nullable
  PsiElement getOf();

}
