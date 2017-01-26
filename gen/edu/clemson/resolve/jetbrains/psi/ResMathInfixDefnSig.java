// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ResMathInfixDefnSig extends ResMathDefnSig {

  @Nullable
  ResMathExp getMathExp();

  @NotNull
  ResMathSymbolName getMathSymbolName();

  @NotNull
  List<ResMathVarDecl> getMathVarDeclList();

  @Nullable
  PsiElement getColon();

}
