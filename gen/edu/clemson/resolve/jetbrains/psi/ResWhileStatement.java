// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ResWhileStatement extends ResStatement {

  @Nullable
  ResChangingClause getChangingClause();

  @Nullable
  ResDecreasingClause getDecreasingClause();

  @Nullable
  ResExp getExp();

  @Nullable
  ResMaintainingClause getMaintainingClause();

  @NotNull
  List<ResStatement> getStatementList();

  @Nullable
  PsiElement getSemicolon();

  @NotNull
  PsiElement getWhile();

  @Nullable
  PsiElement getDo();

  @Nullable
  PsiElement getEnd();

}
