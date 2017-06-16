// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import edu.clemson.resolve.jetbrains.psi.impl.ResMathVarLikeReference;

public interface ResMathReferenceExp extends ResMathExp, ResReferenceExpBase {

  @NotNull
  ResMathSymbolName getMathSymbolName();

  @NotNull
  ResMathVarLikeReference getReference();

  @Nullable
  ResMathReferenceExp getQualifier();

  @NotNull
  PsiElement getIdentifier();

}
