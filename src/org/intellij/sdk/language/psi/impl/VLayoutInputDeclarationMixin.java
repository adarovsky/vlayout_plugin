package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.VLayoutSyntaxHighlighter;
import org.intellij.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.intellij.lang.annotation.HighlightSeverity.INFORMATION;

public class VLayoutInputDeclarationMixin extends ASTWrapperPsiElement implements VLayoutNamedElement, VLayoutSelfAnnotating, NavigatablePsiElement {
    public VLayoutInputDeclarationMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        return getFirstChild();
    }

    @Override
    public String getName() {
        List<String> names = new ArrayList<String>();
        PsiElement element = this;
        while (element != null) {
            if (element instanceof VLayoutInputDeclaration) {
                names.add(0, element.getFirstChild().getText());
            }
            element = element.getParent();
        }

        return String.join(".", names);
    }

    @Override
    public PsiElement setName(@NotNull String s) throws IncorrectOperationException {
        VLayoutBindingDeclaration b = VLayoutElementFactory.createBinding(getProject(), s, getLastChild().getText());

        return b.getFirstChild();
    }

    @Override
    public void annotate(@NotNull AnnotationHolder holder) {
        TextRange nameRange = getFirstChild().getTextRange();

        holder.newAnnotation(INFORMATION, "").range(nameRange).textAttributes(VLayoutSyntaxHighlighter.INPUT).create();
    }

    @Override
    public ItemPresentation getPresentation() {
        return VLayoutPsiImplUtil.getPresentation(this);
    }

    @Override
    public String getType() {
        return "input";
    }

    @Override
    public String getDescriptiveName() {
        return getFirstChild().getText();
    }

}
