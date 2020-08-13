package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.openapi.util.TextRange;
import org.intellij.sdk.language.VLayoutSyntaxHighlighter;
import org.intellij.sdk.language.psi.VLayoutSelfAnnotating;
import org.jetbrains.annotations.NotNull;

import static com.intellij.lang.annotation.HighlightSeverity.INFORMATION;

public class VLayoutListDeclarationMixin extends ASTWrapperPsiElement implements VLayoutSelfAnnotating {
    public VLayoutListDeclarationMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void annotate(@NotNull AnnotationHolder holder) {
        TextRange typeRange = getFirstChild().getTextRange();

        holder.newAnnotation(INFORMATION, "").range(typeRange).textAttributes(VLayoutSyntaxHighlighter.KEYWORD).create();
    }


    @Override
    public String getType() {
        return "list declaration";
    }

    @Override
    public String getDescriptiveName() {
        return getName();
    }
}
