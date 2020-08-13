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
import org.intellij.sdk.language.psi.VLayoutBindingDeclaration;
import org.intellij.sdk.language.psi.VLayoutElementFactory;
import org.intellij.sdk.language.psi.VLayoutNamedElement;
import org.intellij.sdk.language.psi.VLayoutSelfAnnotating;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.lang.annotation.HighlightSeverity.ERROR;
import static com.intellij.lang.annotation.HighlightSeverity.INFORMATION;

public class VLayoutSimpleInputDeclarationMixin extends ASTWrapperPsiElement implements VLayoutSelfAnnotating {
    public VLayoutSimpleInputDeclarationMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void annotate(@NotNull AnnotationHolder holder) {
        TextRange typeRange = getLastChild().getTextRange();

        holder.newAnnotation(INFORMATION, "").range(typeRange).textAttributes(VLayoutSyntaxHighlighter.TYPE_REFERENCE).create();
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
