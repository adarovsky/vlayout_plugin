package org.intellij.sdk.language;

import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementResolveResult;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.psi.*;
import org.intellij.sdk.language.psi.impl.VLayoutPsiImplUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class VLayoutTypeReference extends PsiReferenceBase<VLayoutSimpleInput> {

    private final String key;

    public VLayoutTypeReference(@NotNull VLayoutSimpleInput element, @NotNull TextRange range) {
        super(element, range);
        key = element.getLastChild().getText();
    }

    @NotNull
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        final VLayoutTypeDeclaration[] types = VLayoutPsiImplUtil.getTypes(getElement(), key);
        return Arrays
                .stream(types)
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
        final VLayoutTypeDeclaration[] types = VLayoutPsiImplUtil.getTypes(getElement(), key);
        return Arrays
                .stream(types)
                .map(binding -> LookupElementBuilder
                                .create(binding).withIcon(VLayoutIcons.FILE)
                                .withTypeText(binding.getContainingFile().getName()))
                .toArray();
    }

    @Override
    public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
        return VLayoutPsiImplUtil.setLastName(getElement(), newElementName);
    }
}
