package org.intellij.sdk.language;

import com.intellij.lang.annotation.AnnotationBuilder;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import org.intellij.sdk.language.psi.VLayoutBindingDeclaration;
import org.intellij.sdk.language.psi.VLayoutSelfAnnotating;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.intellij.lang.annotation.HighlightSeverity.ERROR;
import static com.intellij.lang.annotation.HighlightSeverity.INFORMATION;


public class VLayoutAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        // Ensure the Psi Element is an expression
//        if (!(element instanceof PsiLiteralExpression)) return;

        // Ensure the Psi element contains a string that starts with the key and separator

        if (element instanceof VLayoutSelfAnnotating) {
//            System.out.println("found binding: " + element.toString());
            ((VLayoutSelfAnnotating) element).annotate(holder);
        }

    }

}