package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.VLayoutBindingReference;
import org.intellij.sdk.language.VLayoutSyntaxHighlighter;
import org.intellij.sdk.language.VLayoutTypeReference;
import org.intellij.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

import static com.intellij.lang.annotation.HighlightSeverity.ERROR;
import static com.intellij.lang.annotation.HighlightSeverity.INFORMATION;
import static org.intellij.sdk.language.psi.impl.VLayoutTypeDeclarationMixin.PREDEFINED_TYPES;

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

    @Override
    public PsiReference getReference() {
        String text = getLastChild().getText();
        if (Arrays.asList(PREDEFINED_TYPES).contains(text)) {
            return super.getReference();
        }
        TextRange range = getLastChild().getTextRangeInParent();
        return new VLayoutTypeReference((VLayoutSimpleInput) this, range);
    }

}
