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

public class VLayoutSwitchExprImpl extends ASTWrapperPsiElement implements VLayoutSwitchExpr {

  public VLayoutSwitchExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VLayoutVisitor visitor) {
    visitor.visitSwitchExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VLayoutVisitor) accept((VLayoutVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VLayoutCommaSeparatedList getCommaSeparatedList() {
    return findNotNullChildByClass(VLayoutCommaSeparatedList.class);
  }

  @Override
  @NotNull
  public List<VLayoutSwitchCase> getSwitchCaseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VLayoutSwitchCase.class);
  }

}
