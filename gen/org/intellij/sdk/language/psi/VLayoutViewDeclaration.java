// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VLayoutViewDeclaration extends PsiElement {

  @NotNull
  List<VLayoutInclude> getIncludeList();

  @NotNull
  List<VLayoutViewDeclaration> getViewDeclarationList();

  @NotNull
  List<VLayoutViewPropertyDeclaration> getViewPropertyDeclarationList();

  @NotNull
  PsiElement getId();

}
