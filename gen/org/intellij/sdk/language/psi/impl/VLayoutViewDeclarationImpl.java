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

public class VLayoutViewDeclarationImpl extends ASTWrapperPsiElement implements VLayoutViewDeclaration {

  public VLayoutViewDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VLayoutVisitor visitor) {
    visitor.visitViewDeclaration(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VLayoutVisitor) accept((VLayoutVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<VLayoutInclude> getIncludeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VLayoutInclude.class);
  }

  @Override
  @NotNull
  public List<VLayoutViewDeclaration> getViewDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VLayoutViewDeclaration.class);
  }

  @Override
  @NotNull
  public List<VLayoutViewPropertyDeclaration> getViewPropertyDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VLayoutViewPropertyDeclaration.class);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

}
