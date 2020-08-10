package org.intellij.sdk.language;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class VLayoutLexerAdapter extends FlexAdapter {
    public VLayoutLexerAdapter() {
        super(new _VLayoutLexer((Reader) null));
    }
}