// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.psi.VLayoutTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.sdk.language.psi.*;

public class VLayoutTopDeclarationImpl extends ASTWrapperPsiElement implements VLayoutTopDeclaration {

  public VLayoutTopDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VLayoutVisitor visitor) {
    visitor.visitTopDeclaration(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VLayoutVisitor) accept((VLayoutVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VLayoutBindingsSection getBindingsSection() {
    return findChildByClass(VLayoutBindingsSection.class);
  }

  @Override
  @Nullable
  public VLayoutFunctionsSection getFunctionsSection() {
    return findChildByClass(VLayoutFunctionsSection.class);
  }

  @Override
  @Nullable
  public VLayoutInputsSection getInputsSection() {
    return findChildByClass(VLayoutInputsSection.class);
  }

  @Override
  @Nullable
  public VLayoutLayoutSection getLayoutSection() {
    return findChildByClass(VLayoutLayoutSection.class);
  }

  @Override
  @Nullable
  public VLayoutPropertiesSection getPropertiesSection() {
    return findChildByClass(VLayoutPropertiesSection.class);
  }

  @Override
  @Nullable
  public VLayoutTypesSection getTypesSection() {
    return findChildByClass(VLayoutTypesSection.class);
  }

}
