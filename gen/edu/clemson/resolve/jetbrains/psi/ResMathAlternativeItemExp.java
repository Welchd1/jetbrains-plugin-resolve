// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ResMathAlternativeItemExp extends ResMathExp {

  @NotNull
  List<ResMathExp> getMathExpList();

  @NotNull
  PsiElement getSemicolon();

  @Nullable
  PsiElement getIf();

  @Nullable
  PsiElement getOtherwise();

}
