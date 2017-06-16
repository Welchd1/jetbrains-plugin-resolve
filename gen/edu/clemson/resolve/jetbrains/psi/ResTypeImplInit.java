// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ResTypeImplInit extends ResCompositeElement {

  @Nullable
  ResEnsuresClause getEnsuresClause();

  @NotNull
  ResOpBlock getOpBlock();

  @Nullable
  ResRequiresClause getRequiresClause();

  @NotNull
  PsiElement getSemicolon();

  @NotNull
  PsiElement getEnd();

  @NotNull
  PsiElement getInitialization();

}
