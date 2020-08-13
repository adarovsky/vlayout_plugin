package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.intellij.sdk.language.VLayoutBindingReference;
import org.intellij.sdk.language.VLayoutSyntaxHighlighter;
import org.intellij.sdk.language.psi.VLayoutBindingDeclaration;
import org.intellij.sdk.language.psi.VLayoutSelfAnnotating;
import org.intellij.sdk.language.psi.VLayoutViewDeclaration;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.intellij.lang.annotation.HighlightSeverity.ERROR;
import static com.intellij.lang.annotation.HighlightSeverity.INFORMATION;

public class VLayoutViewDeclarationMixin extends ASTWrapperPsiElement implements NavigatablePsiElement, VLayoutSelfAnnotating {
    public VLayoutViewDeclarationMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getName() {
        List<String> names = new ArrayList<String>();
        PsiElement element = this;
        while (element != null) {
            if (element instanceof VLayoutViewDeclaration) {
                names.add(0, element.getFirstChild().getText());
            }
            element = element.getParent();
        }

        return String.join(".", names);
    }

    @Override
    public ItemPresentation getPresentation() {
        return VLayoutPsiImplUtil.getPresentation(this);
    }

    @Override
    public void annotate(@NotNull AnnotationHolder holder) {
        String text = getFirstChild().getText();
        TextRange nameRange = getFirstChild().getTextRange();

        if (Arrays.asList(PREDEFINED_VIEW_TYPES).contains(text)) {
            holder.newAnnotation(INFORMATION, "").range(nameRange).textAttributes(VLayoutSyntaxHighlighter.PREDEFINED_VIEW).create();
        }
        else if(VLayoutPsiImplUtil.getBindings(this, text).length > 0) {
            holder.newAnnotation(INFORMATION, "").range(nameRange).textAttributes(VLayoutSyntaxHighlighter.BINDING).create();
        }
        else {
            holder.newAnnotation(ERROR, "View is not registered").range(nameRange).create();
        }
    }


    @Override
    public String getType() {
        return "view reference";
    }

    @Override
    public String getDescriptiveName() {
        return getName();
    }

    @Override
    public PsiReference getReference() {
        String text = getFirstChild().getText();
        if (Arrays.asList(PREDEFINED_VIEW_TYPES).contains(text)) {
            return super.getReference();
        }
        return new VLayoutBindingReference((VLayoutViewDeclaration) this);
    }

    public static final String[] PREDEFINED_VIEW_TYPES = {
            "layout",
            "layer",
            "absolute",
            "horizontal",
            "vertical",
            "stack",
            "horizontalList",
            "verticalList",
            "label",
            "roundRect",
            "gradient",
            "progress",
            "image",
    };

}
