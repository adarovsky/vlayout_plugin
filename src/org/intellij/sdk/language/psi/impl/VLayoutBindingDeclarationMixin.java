package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.psi.VLayoutBindingDeclaration;
import org.intellij.sdk.language.psi.VLayoutElementFactory;
import org.intellij.sdk.language.psi.VLayoutNamedElement;
import org.intellij.sdk.language.psi.VLayoutSelfAnnotating;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

import static com.intellij.lang.annotation.HighlightSeverity.ERROR;
import static com.intellij.lang.annotation.HighlightSeverity.INFORMATION;

public class VLayoutBindingDeclarationMixin extends ASTWrapperPsiElement implements VLayoutNamedElement, VLayoutSelfAnnotating {
    public VLayoutBindingDeclarationMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        return getFirstChild();
    }

    @Override
    public PsiElement setName(@NotNull String s) throws IncorrectOperationException {
        VLayoutBindingDeclaration b = VLayoutElementFactory.createBinding(getProject(), s, getLastChild().getText());

        return b.getFirstChild();
    }

    @Override
    public void annotate(@NotNull AnnotationHolder holder) {
        System.out.println("this: " + this.toString());
        System.out.println("children: " + Arrays.toString(getChildren()));

        String text = getLastChild().getText();
        TextRange range = getLastChild().getTextRange();
        if (!text.equals("listButton") && !text.equals("button") && !text.equals("view") && !text.equals("listView")) {
            holder.newAnnotation(ERROR, "View type is not supported").range(range).create();
        }
        else {
            holder.newAnnotation(INFORMATION, "").range(range).textAttributes(DefaultLanguageHighlighterColors.KEYWORD).create();
        }
    }
}
