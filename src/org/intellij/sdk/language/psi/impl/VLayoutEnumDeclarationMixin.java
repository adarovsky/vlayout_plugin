package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.VLayoutSyntaxHighlighter;
import org.intellij.sdk.language.psi.VLayoutNamedElement;
import org.intellij.sdk.language.psi.VLayoutSelfAnnotating;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.lang.annotation.HighlightSeverity.INFORMATION;

public class VLayoutEnumDeclarationMixin extends ASTWrapperPsiElement implements VLayoutSelfAnnotating {
    public VLayoutEnumDeclarationMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void annotate(@NotNull AnnotationHolder holder) {
        TextRange typeRange = getFirstChild().getTextRange();

        holder.newAnnotation(INFORMATION, "").range(typeRange).textAttributes(VLayoutSyntaxHighlighter.KEYWORD).create();
    }


    @Override
    public String getType() {
        return "enumeration";
    }

    @Override
    public String getDescriptiveName() {
        return getFirstChild().getText();
    }

}
