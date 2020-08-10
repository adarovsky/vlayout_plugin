package org.intellij.sdk.language;

import com.intellij.lang.*;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import org.intellij.sdk.language.parser.VLayoutParser;
import org.intellij.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;

public class VLayoutParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(VLayoutTypes.LINE_COMMENT);
    public static final TokenSet STRINGS = TokenSet.create(VLayoutTypes.STRING);

    public static final IFileElementType FILE = new IFileElementType(VLayoutLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new VLayoutLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return STRINGS;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new VLayoutParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new VLayoutFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        IElementType t1 = left.getElementType();
        if (t1.equals(VLayoutTypes.LINE_COMMENT)) {
            return SpaceRequirements.MUST_LINE_BREAK;
        }
        return SpaceRequirements.MAY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return VLayoutTypes.Factory.createElement(node);
    }
}