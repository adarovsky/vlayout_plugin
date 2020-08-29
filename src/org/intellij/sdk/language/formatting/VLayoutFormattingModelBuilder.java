package org.intellij.sdk.language.formatting;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.tree.TokenSet;
import org.intellij.sdk.language.VLayoutLanguage;
import org.intellij.sdk.language.psi.VLayoutTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VLayoutFormattingModelBuilder implements FormattingModelBuilder {
    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, VLayoutLanguage.INSTANCE)
                .around(TokenSet.create(
                        VLayoutTypes.OP_AND,
                        VLayoutTypes.OP_OPT,
                        VLayoutTypes.OP_OR,
                        VLayoutTypes.OP_COLON,
                        VLayoutTypes.OP_DIVIDE,
                        VLayoutTypes.OP_PLUS,
                        VLayoutTypes.OP_MINUS,
                        VLayoutTypes.OP_MULTIPLY,
                        VLayoutTypes.OP_EQ,
                        VLayoutTypes.OP_EQEQ,
                        VLayoutTypes.OP_MOD,
                        VLayoutTypes.OP_MORE,
                        VLayoutTypes.OP_MORE_EQ,
                        VLayoutTypes.OP_LESS,
                        VLayoutTypes.OP_LESS_EQ,
                        VLayoutTypes.OP_NEQ
                ))
                .spaceIf(settings.getCommonSettings(VLayoutLanguage.INSTANCE.getID()).SPACE_AROUND_ASSIGNMENT_OPERATORS);
    }

    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        return FormattingModelProvider
                .createFormattingModelForPsiFile(element.getContainingFile(),
                        new ContainerBlock(element.getNode(),
                                Alignment.createAlignment(),
                                Indent.getNoneIndent(),
                                settings),
                        settings);
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
        return null;
    }
}
