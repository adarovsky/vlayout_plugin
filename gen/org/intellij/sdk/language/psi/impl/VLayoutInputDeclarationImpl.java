// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.psi.VLayoutTypes.*;
import org.intellij.sdk.language.psi.*;

public class VLayoutInputDeclarationImpl extends VLayoutInputDeclarationMixin implements VLayoutInputDeclaration {

  public VLayoutInputDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VLayoutVisitor visitor) {
    visitor.visitInputDeclaration(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VLayoutVisitor) accept((VLayoutVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VLayoutComplexInput getComplexInput() {
    return findChildByClass(VLayoutComplexInput.class);
  }

  @Override
  @Nullable
  public VLayoutSimpleInput getSimpleInput() {
    return findChildByClass(VLayoutSimpleInput.class);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

}
