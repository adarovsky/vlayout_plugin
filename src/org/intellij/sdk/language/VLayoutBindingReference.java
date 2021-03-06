package org.intellij.sdk.language;

import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.psi.VLayoutBindingDeclaration;
import org.intellij.sdk.language.psi.VLayoutElementFactory;
import org.intellij.sdk.language.psi.VLayoutViewDeclaration;
import org.intellij.sdk.language.psi.impl.VLayoutPsiImplUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class VLayoutBindingReference extends PsiReferenceBase<VLayoutViewDeclaration> {

    private final String key;

    public VLayoutBindingReference(@NotNull VLayoutViewDeclaration element, @NotNull TextRange range) {
        super(element, range);
        key = element.getFirstChild().getText();
    }

    @NotNull
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        final VLayoutBindingDeclaration[] bindings = VLayoutPsiImplUtil.getBindings(getElement(), key);
        return Arrays
                .stream(bindings)
                .map(PsiElementResolveResult::new)
                .toArray(ResolveResult[]::new);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        final VLayoutBindingDeclaration[] bindings = VLayoutPsiImplUtil.getBindings(getElement(), key);
        return Arrays
                .stream(bindings)
                .map(binding -> LookupElementBuilder
                                .create(binding).withIcon(VLayoutIcons.FILE)
                                .withTypeText(binding.getContainingFile().getName()))
                .toArray();
    }

    @Override
    public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
        return VLayoutPsiImplUtil.setName(getElement(), newElementName);
    }
}
