// This is a generated file. Not intended for manual editing.
package edu.clemson.resolve.jetbrains.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ResMathStandardDefnDecl extends ResMathDefnDecl {

  @Nullable
  ResMathExp getMathExp();

  @Nullable
  ResMathInfixDefnSig getMathInfixDefnSig();

  @Nullable
  ResMathOutfixDefnSig getMathOutfixDefnSig();

  @Nullable
  ResMathPostfixDefnSig getMathPostfixDefnSig();

  @Nullable
  ResMathPrefixDefnSig getMathPrefixDefnSig();

  @Nullable
  PsiElement getChainable();

  @NotNull
  PsiElement getDefinition();

  @Nullable
  PsiElement getImplicit();

  @Nullable
  PsiElement getSemicolon();

  @Nullable
  PsiElement getIs();

}
