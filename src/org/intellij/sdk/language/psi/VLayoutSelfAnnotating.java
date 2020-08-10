package org.intellij.sdk.language.psi;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public interface VLayoutSelfAnnotating {
    public void annotate(@NotNull AnnotationHolder holder);
}
