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

public class VLayoutBindingDeclarationImpl extends VLayoutBindingDeclarationMixin implements VLayoutBindingDeclaration {

  public VLayoutBindingDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VLayoutVisitor visitor) {
    visitor.visitBindingDeclaration(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VLayoutVisitor) accept((VLayoutVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VLayoutViewType getViewType() {
    return findChildByClass(VLayoutViewType.class);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

  @Override
  public String getKey() {
    return VLayoutPsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return VLayoutPsiImplUtil.getValue(this);
  }

}
