// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ResVarSpec extends ResCompositeElement {

  @Nullable
  ResType getType();

  @NotNull
  List<ResVarDef> getVarDefList();

  @Nullable
  PsiElement getColon();

}
