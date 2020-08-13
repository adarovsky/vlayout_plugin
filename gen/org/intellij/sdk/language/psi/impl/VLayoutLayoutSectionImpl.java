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

public class VLayoutLayoutSectionImpl extends VLayoutLayoutSectionMixin implements VLayoutLayoutSection {

  public VLayoutLayoutSectionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VLayoutVisitor visitor) {
    visitor.visitLayoutSection(this);
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

}
