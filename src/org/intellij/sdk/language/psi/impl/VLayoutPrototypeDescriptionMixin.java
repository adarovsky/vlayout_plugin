package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.VLayoutSyntaxHighlighter;
import org.intellij.sdk.language.psi.VLayoutElementFactory;
import org.intellij.sdk.language.psi.VLayoutNamedElement;
import org.intellij.sdk.language.psi.VLayoutSelfAnnotating;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.intellij.lang.annotation.HighlightSeverity.INFORMATION;

public class VLayoutPrototypeDescriptionMixin extends ASTWrapperPsiElement implements VLayoutNamedElement, VLayoutSelfAnnotating, NavigatablePsiElement {
    public VLayoutPrototypeDescriptionMixin(@NotNull ASTNode node) {
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
        throw new IncorrectOperationException();
    }

    @Override
    public void annotate(@NotNull AnnotationHolder holder) {
        TextRange nameRange = getFirstChild().getTextRange();

        holder.newAnnotation(INFORMATION, "").range(nameRange).textAttributes(VLayoutSyntaxHighlighter.PROTOTYPE_NAME).create();
    }

    @Override
    public ItemPresentation getPresentation() {
        return VLayoutPsiImplUtil.getPresentation(this);
    }


    @Override
    public String getType() {
        return "list item prototype";
    }

    @Override
    public String getDescriptiveName() {
        return getName();
    }

}
