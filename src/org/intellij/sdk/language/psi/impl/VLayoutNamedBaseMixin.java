package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.psi.VLayoutNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VLayoutNamedBaseMixin extends ASTWrapperPsiElement implements VLayoutNamedElement {
    public VLayoutNamedBaseMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        return getFirstChild();
    }

    @Override
    public String getName() {
        return getFirstChild().getText();
    }

    @Override
    public PsiElement setName(@NotNull String s) throws IncorrectOperationException {
        return VLayoutPsiImplUtil.setName(this, s);
    }
}
