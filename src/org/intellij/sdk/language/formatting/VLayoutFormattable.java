package org.intellij.sdk.language.formatting;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.Indent;
import com.intellij.psi.codeStyle.CodeStyleSettings;

public interface VLayoutFormattable {
    public Block formattingBlock(Alignment alignment, Indent indent, CodeStyleSettings settings);
}
