package org.intellij.sdk.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.FoldingGroup;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.psi.VLayoutEnumDeclaration;
import org.intellij.sdk.language.psi.VLayoutListDeclaration;
import org.intellij.sdk.language.psi.VLayoutTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VLayoutFoldingBuilder extends FoldingBuilderEx implements DumbAware {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        // Initialize the group of folding regions that will expand/collapse together.
//        FoldingGroup group = FoldingGroup.newGroup("{");
        // Initialize the list of folding regions
        List< FoldingDescriptor > descriptors = new ArrayList<>();
        System.out.println("folding" + root.toString());

        // Get a collection of the literal expressions in the document below root
        Collection< LeafPsiElement > literalExpressions =
                PsiTreeUtil.findChildrenOfType(root, LeafPsiElement.class);
        // Evaluate the collection
        for ( final LeafPsiElement element : literalExpressions ) {
            if ( element.getNode().getElementType().equals(VLayoutTypes.LEFT_BRACE) ) {
                PsiElement parent = element.getParent();

                descriptors.add(new FoldingDescriptor(parent.getNode(),
                        new TextRange(element.getTextRange().getStartOffset() + 1,
                                parent.getTextRange().getEndOffset() - 1)) );

            }
            else if (element.getNode().getElementType().equals(VLayoutTypes.LEFT_PAREN) ) {
                PsiElement parent = element.getParent();
                if (parent instanceof VLayoutListDeclaration || parent instanceof VLayoutEnumDeclaration) {
                    descriptors.add(new FoldingDescriptor(parent.getNode(),
                            new TextRange(element.getTextRange().getStartOffset() + 1,
                                    parent.getTextRange().getEndOffset() - 1)) );
                }
            }
        }
        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    /**
     * Gets the VLayout Language 'value' string corresponding to the 'key'
     * @param node  Node corresponding to PsiLiteralExpression containing a string in the format
     *              SIMPLE_PREFIX_STR + SIMPLE_SEPARATOR_STR + Key, where Key is
     *              defined by the VLayout language file.
     */
    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        String retTxt = "...";
        return retTxt;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return true;
    }
}