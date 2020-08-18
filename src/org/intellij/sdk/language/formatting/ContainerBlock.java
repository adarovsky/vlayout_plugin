package org.intellij.sdk.language.formatting;

import com.intellij.formatting.ASTBlock;
import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.ChildAttributes;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.FormatterUtil;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.formatter.java.BlockFactory;
import com.intellij.psi.tree.IElementType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.intellij.sdk.language.psi.VLayoutTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.intellij.sdk.language.psi.VLayoutTypes.LINE_COMMENT;

class ContainerBlock extends AbstractBlock {
    public static final Spacing NEW_LINE = Spacing.createSpacing(0, 0, 1, true, 2);
    public static final Spacing SPACE = Spacing.createSpacing(1, 1, 0, false, 0);
    public static final Spacing SPACE_OR_NEW_LINE = Spacing.createSpacing(1, 1, 0, true, 1);
    public static final Spacing NONE = Spacing.createSpacing(0, 0, 0, false, 0);


    private Alignment childAlignment;
    private CodeStyleSettings settings;
    ContainerBlock(@NotNull ASTNode node, @Nullable Alignment alignment,
                Indent indent, CodeStyleSettings settings) {
        super(node, null, alignment);
        childAlignment = Alignment.createAlignment();
        this.settings = settings;
    }

    private Block createBlock(@NotNull ASTNode element, @Nullable Alignment alignment,
                              Indent indent, CodeStyleSettings settings) {
        if (element.getPsi() instanceof VLayoutFormattable) {
            return ((VLayoutFormattable) element.getPsi()).formattingBlock(alignment, indent, settings);
        }
        else {
            return new LeafBlock(element, alignment, indent, settings);
        }
    }
    @Override
    protected List<Block> buildChildren() {
        ASTNode child = getNode().getFirstChildNode();
        State state = State.BEFORE_LEFT_CURLY_BRACE;
        List<Block> result = new ArrayList<>();
        while (child != null) {
            if (!FormatterUtil.containsWhiteSpacesOnly(child)) {
                IElementType elementType = child.getElementType();
                if (VLayoutTypes.LEFT_BRACE.equals(elementType)) {
                    state = State.AFTER_LEFT_CURLY_BRACE;
                    result.add(createBlock(child, myAlignment, Indent.getNoneIndent(), settings));
                } else if (VLayoutTypes.RIGHT_BRACE.equals(elementType)) {
                    result.add(createBlock(child, myAlignment, Indent.getNoneIndent(), settings));
                    state = State.AFTER_RIGHT_CURLY_BRACE;
                } else {
                    switch (state) {
                        case BEFORE_LEFT_CURLY_BRACE:
                            Block block = createBlock(child, myAlignment, Indent.getNoneIndent(), settings);
                            result.add(block);
                            break;
                        case AFTER_LEFT_CURLY_BRACE:
                            result.add(createBlock(child, childAlignment, Indent.getNormalIndent(true), settings));
                            break;
                        case AFTER_RIGHT_CURLY_BRACE:
                            result.add(createBlock(child, myAlignment, Indent.getNoneIndent(), settings));
                            break;
                        default:
                            throw new IllegalStateException(state.toString());
                    }
                }
            }
            child = child.getTreeNext();
        }
        return result;
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        if (child2 instanceof ASTBlock) {
            ASTBlock block = (ASTBlock) child2;
            // Do not move semicolon after '}' to new line.
            IElementType elementType = block.getNode().getElementType();
            // Do not move trailing comments to new line.
            if (LINE_COMMENT.equals(elementType)) {
                return SPACE_OR_NEW_LINE;
            }
        }
        return NEW_LINE;
    }

    @NotNull
    @Override
    public ChildAttributes getChildAttributes(int newChildIndex) {
        return new ChildAttributes(getChildIndent(), childAlignment);
    }

    @Nullable
    @Override
    protected Indent getChildIndent() {
        return Indent.getNormalIndent();
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    private enum State {
        BEFORE_LEFT_CURLY_BRACE,
        AFTER_LEFT_CURLY_BRACE,
        AFTER_RIGHT_CURLY_BRACE
    }
}