// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface ResTypeReferenceExp extends ResReferenceExpBase {

  @NotNull
  PsiElement getIdentifier();

  @NotNull
  PsiReference getReference();

  @Nullable
  ResTypeReferenceExp getQualifier();

  @Nullable
  PsiElement resolve();

}
