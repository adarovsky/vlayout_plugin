package org.intellij.sdk.language;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.intellij.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VLayoutRefactoringSupportProvider extends RefactoringSupportProvider {

    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement elementToRename, @Nullable PsiElement context) {
        return (elementToRename instanceof VLayoutBindingDeclaration) ||
               (elementToRename instanceof VLayoutInputDeclaration) ||
               (elementToRename instanceof VLayoutPropertyDeclaration) ||
               (elementToRename instanceof VLayoutTypeDeclaration)
                ;
    }

}