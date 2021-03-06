package org.intellij.sdk.language.formatting;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.FormatterUtil;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.intellij.sdk.language.psi.VLayoutTypes.*;

public class PropertyBlock extends AbstractBlock {
    public static final Spacing NEW_LINE = Spacing.createSpacing(0, 0, 1, true, 2);
    public static final Spacing SPACE = Spacing.createSpacing(1, 1, 0, false, 0);
    public static final Spacing SPACE_OR_NEW_LINE = Spacing.createSpacing(1, 1, 0, true, 1);
    public static final Spacing NONE = Spacing.createSpacing(0, 0, 0, false, 0);


    private Alignment childAlignment;
    private CodeStyleSettings settings;
    private Indent myIndent;
    public PropertyBlock(@NotNull ASTNode node, @Nullable Alignment alignment,
                         Indent indent, CodeStyleSettings settings) {
        super(node, null, alignment);
        childAlignment = Alignment.createAlignment();
        this.settings = settings;
        myIndent = indent;
        System.out.println("PropertyBlock(" + node.toString() + ", indent: " + indent.toString());
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
        State state = State.BEFORE_COLON;
        List<Block> result = new ArrayList<>();
        while (child != null) {
            if (!FormatterUtil.containsWhiteSpacesOnly(child)) {
                IElementType elementType = child.getElementType();
                if (OP_COLON.equals(elementType)) {
                    state = State.AFTER_COLON;
                    result.add(createBlock(child, myAlignment, Indent.getNoneIndent(), settings));
                } else {
                    switch (state) {
                        case BEFORE_COLON:
                            Block block = createBlock(child, myAlignment, Indent.getNoneIndent(), settings);
                            result.add(block);
                            break;
                        case AFTER_COLON:
                            result.add(createBlock(child, childAlignment, Indent.getSmartIndent(Indent.Type.CONTINUATION_WITHOUT_FIRST), settings));
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
        if (child1 instanceof ASTBlock && child2 instanceof ASTBlock) {
            ASTBlock block1 = (ASTBlock) child1;
            ASTBlock block2 = (ASTBlock) child2;
            IElementType elementType1 = Objects.requireNonNull(block1.getNode()).getElementType();
            IElementType elementType2 = Objects.requireNonNull(block2.getNode()).getElementType();

            if (ID.equals(elementType1)) {
                if (OP_COLON.equals(elementType2)) {
                    return NONE;
                }
                else if (LEFT_BRACE.equals(elementType2)) {
                    return SPACE;
                }
            }
            else if (OP_COLON.equals(elementType1)) {
                return SPACE;
            }
        }

        return NEW_LINE;
    }

    @Override
    public Indent getIndent() {
        return myIndent;
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

    @Override
    public String toString() {
        return "PropertyBlock{" +
                "node=" + myNode +
                ", alignment=" + myAlignment +
                ", myIndent=" + getIndent() +
                '}';
    }

    private enum State {
        BEFORE_COLON,
        AFTER_COLON
    }
}