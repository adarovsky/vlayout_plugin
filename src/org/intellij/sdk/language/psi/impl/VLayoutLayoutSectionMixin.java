package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import org.jetbrains.annotations.NotNull;

public class VLayoutLayoutSectionMixin extends ASTWrapperPsiElement implements NavigatablePsiElement {
    public VLayoutLayoutSectionMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getName() {
        return "layout";
    }

    @Override
    public ItemPresentation getPresentation() {
        return VLayoutPsiImplUtil.getPresentation(this);
    }
}
