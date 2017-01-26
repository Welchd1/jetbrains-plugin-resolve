// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ResMathQuantifiedExp extends ResMathExp {

  @Nullable
  ResMathExp getMathExp();

  @Nullable
  ResMathVarDeclGroup getMathVarDeclGroup();

  @Nullable
  PsiElement getComma();

  @Nullable
  PsiElement getExists();

  @Nullable
  PsiElement getForall();

}
