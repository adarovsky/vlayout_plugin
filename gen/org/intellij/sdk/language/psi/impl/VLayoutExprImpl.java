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

public class VLayoutExprImpl extends ASTWrapperPsiElement implements VLayoutExpr {

  public VLayoutExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VLayoutVisitor visitor) {
    visitor.visitExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VLayoutVisitor) accept((VLayoutVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VLayoutConditionalExpr getConditionalExpr() {
    return findNotNullChildByClass(VLayoutConditionalExpr.class);
  }

}
