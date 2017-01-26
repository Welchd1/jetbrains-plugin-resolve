// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.ResolveState;

public interface ResVarDef extends ResNamedElement {

  @NotNull
  PsiElement getIdentifier();

  @Nullable
  ResType getResTypeInner(ResolveState context);

  @Nullable
  PsiReference getReference();

}
