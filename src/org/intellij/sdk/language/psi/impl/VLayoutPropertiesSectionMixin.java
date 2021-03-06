package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.NavigatablePsiElement;
import org.intellij.sdk.language.VLayoutSyntaxHighlighter;
import org.intellij.sdk.language.psi.VLayoutSelfAnnotating;
import org.jetbrains.annotations.NotNull;

import static com.intellij.lang.annotation.HighlightSeverity.INFORMATION;


public class VLayoutPropertiesSectionMixin extends VLayoutComplexBodyMixin implements NavigatablePsiElement, VLayoutSelfAnnotating {
    public VLayoutPropertiesSectionMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getName() {
        return "properties";
    }

    @Override
    public ItemPresentation getPresentation() {
        return VLayoutPsiImplUtil.getPresentation(this);
    }

    @Override
    public void annotate(@NotNull AnnotationHolder holder) {
        TextRange nameRange = getFirstChild().getTextRange();
        holder.newAnnotation(INFORMATION, "").range(nameRange).textAttributes(VLayoutSyntaxHighlighter.KEYWORD).create();
    }

    @Override
    public String getType() {
        return "properties";
    }

    @Override
    public String getDescriptiveName() {
        return getName();
    }
}
