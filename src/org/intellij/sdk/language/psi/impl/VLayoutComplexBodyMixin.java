package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.psi.VLayoutNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VLayoutComplexBodyMixin extends ASTWrapperPsiElement {
    public VLayoutComplexBodyMixin(@NotNull ASTNode node) {
        super(node);
    }


}
