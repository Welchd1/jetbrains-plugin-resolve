// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiReference;

public interface ResModuleIdentifier extends ResCompositeElement {

  @NotNull
  PsiElement getIdentifier();

  @NotNull
  PsiReference[] getReferences();

  @NotNull
  TextRange getModuleIdentiferTextRange();

  @Nullable
  PsiElement resolve();

}
