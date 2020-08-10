package org.intellij.sdk.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.VLayoutTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class VLayoutSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey OPERATION =
            createTextAttributesKey("VLAYOUT_OPERATION", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("VLAYOUT_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("VLAYOUT_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("VLAYOUT_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("VLAYOUT_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("VLAYOUT_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] OPERATION_KEYS = new TextAttributesKey[]{OPERATION};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new VLayoutLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {

        if (tokenType.equals(VLayoutTypes.OP_EQ) ||
            tokenType.equals(VLayoutTypes.OP_ALT) ||
            tokenType.equals(VLayoutTypes.OP_AND) ||
            tokenType.equals(VLayoutTypes.OP_COLON) ||
            tokenType.equals(VLayoutTypes.OP_COMMA) ||
            tokenType.equals(VLayoutTypes.OP_DIVIDE) ||
            tokenType.equals(VLayoutTypes.OP_EQEQ) ||
            tokenType.equals(VLayoutTypes.OP_LESS) ||
            tokenType.equals(VLayoutTypes.OP_LESS_EQ) ||
            tokenType.equals(VLayoutTypes.OP_MINUS) ||
            tokenType.equals(VLayoutTypes.OP_MOD) ||
            tokenType.equals(VLayoutTypes.OP_MORE) ||
            tokenType.equals(VLayoutTypes.OP_MORE_EQ) ||
            tokenType.equals(VLayoutTypes.OP_MULTIPLY) ||
            tokenType.equals(VLayoutTypes.OP_NEQ) ||
            tokenType.equals(VLayoutTypes.OP_NOT) ||
            tokenType.equals(VLayoutTypes.OP_OPT) ||
            tokenType.equals(VLayoutTypes.OP_OR) ||
            tokenType.equals(VLayoutTypes.OP_PLUS)) {
            return OPERATION_KEYS;
        } else if (tokenType.equals(VLayoutTypes.LINE_COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(VLayoutTypes.STRING)) {
            return STRING_KEYS;
        } else if (tokenType.equals(VLayoutTypes.NUMBER)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(VLayoutTypes.COLOR)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}