// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ResMathPostfixDefnSig extends ResMathDefnSig {

  @NotNull
  ResMathExp getMathExp();

  @NotNull
  List<ResMathSymbolName> getMathSymbolNameList();

  @NotNull
  List<ResMathVarDecl> getMathVarDeclList();

  @NotNull
  PsiElement getColon();

}
