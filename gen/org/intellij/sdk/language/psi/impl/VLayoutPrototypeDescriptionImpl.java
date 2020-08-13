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

public class VLayoutPrototypeDescriptionImpl extends VLayoutPrototypeDescriptionMixin implements VLayoutPrototypeDescription {

  public VLayoutPrototypeDescriptionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VLayoutVisitor visitor) {
    visitor.visitPrototypeDescription(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VLayoutVisitor) accept((VLayoutVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VLayoutComplexPrototypeContent getComplexPrototypeContent() {
    return findNotNullChildByClass(VLayoutComplexPrototypeContent.class);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

}
