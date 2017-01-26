// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ResConceptModuleDecl extends ResModuleDecl {

  @Nullable
  ResConceptBlock getConceptBlock();

  @Nullable
  ResRequiresClause getRequiresClause();

  @Nullable
  ResSpecModuleParameters getSpecModuleParameters();

  @Nullable
  ResUsesList getUsesList();

  @NotNull
  PsiElement getConcept();

  @Nullable
  PsiElement getEnd();

}
