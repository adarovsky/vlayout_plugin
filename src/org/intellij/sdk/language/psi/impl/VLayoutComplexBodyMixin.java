package org.intellij.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.Indent;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.formatting.ContainerBlock;
import org.intellij.sdk.language.formatting.VLayoutFormattable;
import org.intellij.sdk.language.psi.VLayoutNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VLayoutComplexBodyMixin extends ASTWrapperPsiElement implements VLayoutFormattable {
    public VLayoutComplexBodyMixin(@NotNull ASTNode node) {
        super(node);
    }


    @Override
    public Block formattingBlock(Alignment alignment, Indent indent, CodeStyleSettings settings) {
        return new ContainerBlock(getNode(), alignment, indent, settings);
    }
}
