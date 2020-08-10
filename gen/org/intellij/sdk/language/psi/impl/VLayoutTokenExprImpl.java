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

public class VLayoutTokenExprImpl extends ASTWrapperPsiElement implements VLayoutTokenExpr {

  public VLayoutTokenExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VLayoutVisitor visitor) {
    visitor.visitTokenExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VLayoutVisitor) accept((VLayoutVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VLayoutAlternativeExpr getAlternativeExpr() {
    return findChildByClass(VLayoutAlternativeExpr.class);
  }

  @Override
  @Nullable
  public VLayoutExpr getExpr() {
    return findChildByClass(VLayoutExpr.class);
  }

  @Override
  @Nullable
  public VLayoutSwitchExpr getSwitchExpr() {
    return findChildByClass(VLayoutSwitchExpr.class);
  }

}
