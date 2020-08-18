package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.VLayoutSyntaxHighlighter;
import org.intellij.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

import static com.intellij.lang.annotation.HighlightSeverity.ERROR;
import static com.intellij.lang.annotation.HighlightSeverity.INFORMATION;

public class VLayoutBindingDeclarationMixin extends VLayoutNamedBaseMixin implements VLayoutSelfAnnotating, NavigatablePsiElement {
    public VLayoutBindingDeclarationMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public void annotate(@NotNull AnnotationHolder holder) {
        String text = getLastChild().getText();
        TextRange nameRange = getFirstChild().getTextRange();
        TextRange typeRange = getLastChild().getTextRange();

        holder.newAnnotation(INFORMATION, "").range(nameRange).textAttributes(VLayoutSyntaxHighlighter.BINDING).create();

        if (!text.equals("listButton") && !text.equals("button") && !text.equals("view") && !text.equals("listView")) {
            holder.newAnnotation(ERROR, "View type is not supported").range(typeRange).create();
        }
        else {
            holder.newAnnotation(INFORMATION, "").range(typeRange).textAttributes(VLayoutSyntaxHighlighter.KEYWORD).create();
        }
    }

    @Override
    public ItemPresentation getPresentation() {
        return VLayoutPsiImplUtil.getPresentation(this);
    }

    @Override
    public String getType() {
        return "view binding";
    }

    @Override
    public String getDescriptiveName() {
        return getName();
    }
}
