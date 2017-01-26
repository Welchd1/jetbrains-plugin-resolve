// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;

public interface ResFacilityBlock extends ResBlock {

  @NotNull
  List<ResFacilityDecl> getFacilityDeclList();

  @NotNull
  List<ResMathStandardDefnDecl> getMathStandardDefnDeclList();

  @NotNull
  List<ResOperationProcedureDecl> getOperationProcedureDeclList();

  @NotNull
  List<ResTypeReprDecl> getTypeReprDeclList();

  boolean processDeclarations(PsiScopeProcessor processor, ResolveState state, PsiElement lastParent, PsiElement place);

}
