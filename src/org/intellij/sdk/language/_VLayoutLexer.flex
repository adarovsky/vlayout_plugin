package org.intellij.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.sdk.language.psi.VLayoutTypes.*;

%%

%{
  public _VLayoutLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _VLayoutLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
ID=[a-zA-Z_0-9]+
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\\"|\\'|\\)*\")
NUMBER=[0-9]+(\.[0-9]*)?
COLOR=#([\dabcdefABCDEF]){6}
LINE_COMMENT="//".*

%%
<YYINITIAL> {
  {WHITE_SPACE}       { return WHITE_SPACE; }

  "="                 { return OP_EQ; }
  "=="                { return OP_EQEQ; }
  "!="                { return OP_NEQ; }
  "|"                 { return OP_ALT; }
  "?"                 { return OP_OPT; }
  "+"                 { return OP_PLUS; }
  "-"                 { return OP_MINUS; }
  "*"                 { return OP_MULTIPLY; }
  "/"                 { return OP_DIVIDE; }
  "%"                 { return OP_MOD; }
  "||"                { return OP_OR; }
  "&&"                { return OP_AND; }
  "!"                 { return OP_NOT; }
  ":"                 { return OP_COLON; }
  ","                 { return OP_COMMA; }
  "."                 { return OP_DOT; }
  ">"                 { return OP_MORE; }
  ">="                { return OP_MORE_EQ; }
  "<"                 { return OP_LESS; }
  "<="                { return OP_LESS_EQ; }
  "{"                 { return LEFT_BRACE; }
  "}"                 { return RIGHT_BRACE; }
  "("                 { return LEFT_PAREN; }
  ")"                 { return RIGHT_PAREN; }
  "true"              { return CONST_TRUE; }
  "false"             { return CONST_FALSE; }

  {SPACE}             { return SPACE; }
  {ID}                { return ID; }
  {STRING}            { return STRING; }
  {NUMBER}            { return NUMBER; }
  {COLOR}             { return COLOR; }
  {LINE_COMMENT}      { return LINE_COMMENT; }

}

[^] { return BAD_CHARACTER; }
