// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.intellij.sdk.language.psi.VLayoutTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class VLayoutParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return VLayoutFile(b, l + 1);
  }

  /* ********************************************************** */
  // !<<eof>> topDeclaration *
  static boolean VLayoutFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VLayoutFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VLayoutFile_0(b, l + 1);
    r = r && VLayoutFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<eof>>
  private static boolean VLayoutFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VLayoutFile_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // topDeclaration *
  private static boolean VLayoutFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VLayoutFile_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!topDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VLayoutFile_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // mulDivExpr addSubOp*
  public static boolean addSubExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addSubExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADD_SUB_EXPR, "<add sub expr>");
    r = mulDivExpr(b, l + 1);
    r = r && addSubExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // addSubOp*
  private static boolean addSubExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addSubExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!addSubOp(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "addSubExpr_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (OP_PLUS|OP_MINUS) mulDivExpr
  static boolean addSubOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addSubOp")) return false;
    if (!nextTokenIs(b, "", OP_MINUS, OP_PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_INNER_);
    r = addSubOp_0(b, l + 1);
    r = r && mulDivExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_PLUS|OP_MINUS
  private static boolean addSubOp_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addSubOp_0")) return false;
    boolean r;
    r = consumeToken(b, OP_PLUS);
    if (!r) r = consumeToken(b, OP_MINUS);
    return r;
  }

  /* ********************************************************** */
  // OP_ALT simpleExpr
  static boolean altOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "altOp")) return false;
    if (!nextTokenIs(b, OP_ALT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_INNER_);
    r = consumeToken(b, OP_ALT);
    r = r && simpleExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // simpleExpr altOp *
  public static boolean alternativeExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alternativeExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ALTERNATIVE_EXPR, "<alternative expr>");
    r = simpleExpr(b, l + 1);
    r = r && alternativeExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // altOp *
  private static boolean alternativeExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alternativeExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!altOp(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "alternativeExpr_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // id OP_COLON viewType
  public static boolean bindingDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindingDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BINDING_DECLARATION, "<binding declaration>");
    r = consumeTokens(b, 1, ID, OP_COLON);
    p = r; // pin = 1
    r = r && viewType(b, l + 1);
    exit_section_(b, l, m, r, p, pairRecover_parser_);
    return r || p;
  }

  /* ********************************************************** */
  // 'bindings' LEFT_BRACE bindingDeclaration * RIGHT_BRACE
  public static boolean bindingsSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindingsSection")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINDINGS_SECTION, "<bindings section>");
    r = consumeToken(b, "bindings");
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && bindingsSection_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // bindingDeclaration *
  private static boolean bindingsSection_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindingsSection_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bindingDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bindingsSection_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // <<param>> ( ',' <<param>> ) *
  public static boolean comma_separated_list(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "comma_separated_list")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _param.parse(b, l);
    r = r && comma_separated_list_1(b, l + 1, _param);
    exit_section_(b, m, COMMA_SEPARATED_LIST, r);
    return r;
  }

  // ( ',' <<param>> ) *
  private static boolean comma_separated_list_1(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "comma_separated_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!comma_separated_list_1_0(b, l + 1, _param)) break;
      if (!empty_element_parsed_guard_(b, "comma_separated_list_1", c)) break;
    }
    return true;
  }

  // ',' <<param>>
  private static boolean comma_separated_list_1_0(PsiBuilder b, int l, Parser _param) {
    if (!recursion_guard_(b, l, "comma_separated_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COMMA);
    r = r && _param.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // addSubExpr (compareOp addSubExpr)?
  public static boolean compareExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARE_EXPR, "<compare expr>");
    r = addSubExpr(b, l + 1);
    r = r && compareExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (compareOp addSubExpr)?
  private static boolean compareExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpr_1")) return false;
    compareExpr_1_0(b, l + 1);
    return true;
  }

  // compareOp addSubExpr
  private static boolean compareExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = compareOp(b, l + 1);
    r = r && addSubExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OP_MORE | OP_MORE_EQ | OP_LESS | OP_LESS_EQ | OP_EQEQ | OP_NEQ
  static boolean compareOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareOp")) return false;
    boolean r;
    r = consumeToken(b, OP_MORE);
    if (!r) r = consumeToken(b, OP_MORE_EQ);
    if (!r) r = consumeToken(b, OP_LESS);
    if (!r) r = consumeToken(b, OP_LESS_EQ);
    if (!r) r = consumeToken(b, OP_EQEQ);
    if (!r) r = consumeToken(b, OP_NEQ);
    return r;
  }

  /* ********************************************************** */
  // id LEFT_BRACE inputDeclaration * RIGHT_BRACE
  public static boolean complexInput(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexInput")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, LEFT_BRACE);
    r = r && complexInput_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, COMPLEX_INPUT, r);
    return r;
  }

  // inputDeclaration *
  private static boolean complexInput_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexInput_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inputDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "complexInput_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // id LEFT_BRACE propertyDeclaration * RIGHT_BRACE
  public static boolean complexPropertyDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexPropertyDeclaration")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, LEFT_BRACE);
    r = r && complexPropertyDeclaration_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, COMPLEX_PROPERTY_DECLARATION, r);
    return r;
  }

  // propertyDeclaration *
  private static boolean complexPropertyDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexPropertyDeclaration_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!propertyDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "complexPropertyDeclaration_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // id LEFT_BRACE (complexType|simpleType) * RIGHT_BRACE
  public static boolean complexType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexType")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, LEFT_BRACE);
    r = r && complexType_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, COMPLEX_TYPE, r);
    return r;
  }

  // (complexType|simpleType) *
  private static boolean complexType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexType_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!complexType_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "complexType_2", c)) break;
    }
    return true;
  }

  // complexType|simpleType
  private static boolean complexType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexType_2_0")) return false;
    boolean r;
    r = complexType(b, l + 1);
    if (!r) r = simpleType(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // propertyKey LEFT_BRACE simpleViewProperty * RIGHT_BRACE
  public static boolean complexViewProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexViewProperty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPLEX_VIEW_PROPERTY, "<complex view property>");
    r = propertyKey(b, l + 1);
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && complexViewProperty_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // simpleViewProperty *
  private static boolean complexViewProperty_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "complexViewProperty_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!simpleViewProperty(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "complexViewProperty_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // logicalOrExpr (OP_OPT expr OP_COLON conditionalExpr)?
  public static boolean conditionalExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_EXPR, "<conditional expr>");
    r = logicalOrExpr(b, l + 1);
    r = r && conditionalExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_OPT expr OP_COLON conditionalExpr)?
  private static boolean conditionalExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalExpr_1")) return false;
    conditionalExpr_1_0(b, l + 1);
    return true;
  }

  // OP_OPT expr OP_COLON conditionalExpr
  private static boolean conditionalExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_OPT);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, OP_COLON);
    r = r && conditionalExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // string | number | color | CONST_TRUE | CONST_FALSE
  public static boolean constantExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constantExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_EXPR, "<constant expr>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, COLOR);
    if (!r) r = consumeToken(b, CONST_TRUE);
    if (!r) r = consumeToken(b, CONST_FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // id OP_COLON 'enum' LEFT_PAREN enumItems * RIGHT_PAREN
  public static boolean enumDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDeclaration")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, OP_COLON);
    r = r && consumeToken(b, "enum");
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && enumDeclaration_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, ENUM_DECLARATION, r);
    return r;
  }

  // enumItems *
  private static boolean enumDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDeclaration_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enumItems(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enumDeclaration_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // <<comma_separated_list id>>
  static boolean enumItems(PsiBuilder b, int l) {
    return comma_separated_list(b, l + 1, ID_parser_);
  }

  /* ********************************************************** */
  // compareExpr (OP_EQEQ compareExpr)?
  public static boolean equalExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EQUAL_EXPR, "<equal expr>");
    r = compareExpr(b, l + 1);
    r = r && equalExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_EQEQ compareExpr)?
  private static boolean equalExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalExpr_1")) return false;
    equalExpr_1_0(b, l + 1);
    return true;
  }

  // OP_EQEQ compareExpr
  private static boolean equalExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_EQEQ);
    r = r && compareExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // conditionalExpr
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = conditionalExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (id|'@') LEFT_PAREN <<comma_separated_list expr>> RIGHT_PAREN
  public static boolean functionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
    r = functionCall_0(b, l + 1);
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && comma_separated_list(b, l + 1, expr_parser_);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // id|'@'
  private static boolean functionCall_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_0")) return false;
    boolean r;
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, "@");
    return r;
  }

  /* ********************************************************** */
  // id LEFT_PAREN <<comma_separated_list functionParameter>> RIGHT_PAREN '=>' expr
  public static boolean functionDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, LEFT_PAREN);
    r = r && comma_separated_list(b, l + 1, functionParameter_parser_);
    r = r && consumeToken(b, RIGHT_PAREN);
    r = r && consumeToken(b, "=>");
    r = r && expr(b, l + 1);
    exit_section_(b, m, FUNCTION_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // id OP_COLON id
  public static boolean functionParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionParameter")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, OP_COLON, ID);
    exit_section_(b, m, FUNCTION_PARAMETER, r);
    return r;
  }

  /* ********************************************************** */
  // 'functions' LEFT_BRACE functionDeclaration * RIGHT_BRACE
  public static boolean functionsSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionsSection")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTIONS_SECTION, "<functions section>");
    r = consumeToken(b, "functions");
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && functionsSection_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // functionDeclaration *
  private static boolean functionsSection_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionsSection_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!functionDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionsSection_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'include' OP_COLON string
  public static boolean include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE, "<include>");
    r = consumeToken(b, "include");
    r = r && consumeTokens(b, 0, OP_COLON, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PAREN expr RIGHT_PAREN
  static boolean innerExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "innerExpr")) return false;
    if (!nextTokenIs(b, LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // simpleInput | complexInput
  public static boolean inputDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inputDeclaration")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simpleInput(b, l + 1);
    if (!r) r = complexInput(b, l + 1);
    exit_section_(b, m, INPUT_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // 'inputs' LEFT_BRACE inputDeclaration * RIGHT_BRACE
  public static boolean inputsSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inputsSection")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INPUTS_SECTION, "<inputs section>");
    r = consumeToken(b, "inputs");
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && inputsSection_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // inputDeclaration *
  private static boolean inputsSection_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inputsSection_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!inputDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inputsSection_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'layout' LEFT_BRACE (viewDeclaration | include) * RIGHT_BRACE
  public static boolean layoutSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layoutSection")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAYOUT_SECTION, "<layout section>");
    r = consumeToken(b, "layout");
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && layoutSection_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (viewDeclaration | include) *
  private static boolean layoutSection_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layoutSection_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!layoutSection_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "layoutSection_2", c)) break;
    }
    return true;
  }

  // viewDeclaration | include
  private static boolean layoutSection_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "layoutSection_2_0")) return false;
    boolean r;
    r = viewDeclaration(b, l + 1);
    if (!r) r = include(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // id OP_COLON 'list' LEFT_PAREN listPrototype * RIGHT_PAREN
  public static boolean listDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listDeclaration")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, OP_COLON);
    r = r && consumeToken(b, "list");
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && listDeclaration_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, LIST_DECLARATION, r);
    return r;
  }

  // listPrototype *
  private static boolean listDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listDeclaration_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!listPrototype(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "listDeclaration_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // <<comma_separated_list complexType>>
  static boolean listPrototype(PsiBuilder b, int l) {
    return comma_separated_list(b, l + 1, complexType_parser_);
  }

  /* ********************************************************** */
  // equalExpr logicalAndOp *
  public static boolean logicalAndExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_AND_EXPR, "<logical and expr>");
    r = equalExpr(b, l + 1);
    r = r && logicalAndExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // logicalAndOp *
  private static boolean logicalAndExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logicalAndOp(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logicalAndExpr_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OP_AND equalExpr
  static boolean logicalAndOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndOp")) return false;
    if (!nextTokenIs(b, OP_AND)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_INNER_);
    r = consumeToken(b, OP_AND);
    r = r && equalExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // logicalAndExpr logicalOrOp *
  public static boolean logicalOrExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_OR_EXPR, "<logical or expr>");
    r = logicalAndExpr(b, l + 1);
    r = r && logicalOrExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // logicalOrOp *
  private static boolean logicalOrExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logicalOrOp(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logicalOrExpr_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OP_OR logicalAndExpr
  static boolean logicalOrOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrOp")) return false;
    if (!nextTokenIs(b, OP_OR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_INNER_);
    r = consumeToken(b, OP_OR);
    r = r && logicalAndExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // negateExpr mulDivOp *
  public static boolean mulDivExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mulDivExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MUL_DIV_EXPR, "<mul div expr>");
    r = negateExpr(b, l + 1);
    r = r && mulDivExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // mulDivOp *
  private static boolean mulDivExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mulDivExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mulDivOp(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mulDivExpr_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (OP_MULTIPLY | OP_DIVIDE | OP_MOD) negateExpr
  static boolean mulDivOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mulDivOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_INNER_);
    r = mulDivOp_0(b, l + 1);
    r = r && negateExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_MULTIPLY | OP_DIVIDE | OP_MOD
  private static boolean mulDivOp_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mulDivOp_0")) return false;
    boolean r;
    r = consumeToken(b, OP_MULTIPLY);
    if (!r) r = consumeToken(b, OP_DIVIDE);
    if (!r) r = consumeToken(b, OP_MOD);
    return r;
  }

  /* ********************************************************** */
  // (OP_NOT | OP_MINUS)? tokenExpr
  public static boolean negateExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negateExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEGATE_EXPR, "<negate expr>");
    r = negateExpr_0(b, l + 1);
    r = r && tokenExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_NOT | OP_MINUS)?
  private static boolean negateExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negateExpr_0")) return false;
    negateExpr_0_0(b, l + 1);
    return true;
  }

  // OP_NOT | OP_MINUS
  private static boolean negateExpr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negateExpr_0_0")) return false;
    boolean r;
    r = consumeToken(b, OP_NOT);
    if (!r) r = consumeToken(b, OP_MINUS);
    return r;
  }

  /* ********************************************************** */
  // OP_COLON
  static boolean pairRecover(PsiBuilder b, int l) {
    return consumeToken(b, OP_COLON);
  }

  /* ********************************************************** */
  // 'properties' LEFT_BRACE propertyDeclaration * RIGHT_BRACE
  public static boolean propertiesSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertiesSection")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTIES_SECTION, "<properties section>");
    r = consumeToken(b, "properties");
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && propertiesSection_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // propertyDeclaration *
  private static boolean propertiesSection_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertiesSection_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!propertyDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "propertiesSection_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // simplePropertyDeclaration | complexPropertyDeclaration
  public static boolean propertyDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyDeclaration")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = simplePropertyDeclaration(b, l + 1);
    if (!r) r = complexPropertyDeclaration(b, l + 1);
    exit_section_(b, m, PROPERTY_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // 'padding'|'size'|'fixedSize'|'contentPadding'
  public static boolean propertyKey(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyKey")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_KEY, "<property key>");
    r = consumeToken(b, "padding");
    if (!r) r = consumeToken(b, "size");
    if (!r) r = consumeToken(b, "fixedSize");
    if (!r) r = consumeToken(b, "contentPadding");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (id OP_DOT refPathList) | id
  static boolean refPathList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refPathList")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = refPathList_0(b, l + 1);
    if (!r) r = consumeToken(b, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // id OP_DOT refPathList
  private static boolean refPathList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "refPathList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, OP_DOT);
    r = r && refPathList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // shortEnum | functionCall | variableReference
  public static boolean referenceExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REFERENCE_EXPR, "<reference expr>");
    r = shortEnum(b, l + 1);
    if (!r) r = functionCall(b, l + 1);
    if (!r) r = variableReference(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OP_DOT id
  public static boolean shortEnum(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shortEnum")) return false;
    if (!nextTokenIs(b, OP_DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OP_DOT, ID);
    exit_section_(b, m, SHORT_ENUM, r);
    return r;
  }

  /* ********************************************************** */
  // constantExpr | referenceExpr
  public static boolean simpleExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_EXPR, "<simple expr>");
    r = constantExpr(b, l + 1);
    if (!r) r = referenceExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // id OP_COLON id
  public static boolean simpleInput(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleInput")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, OP_COLON, ID);
    exit_section_(b, m, SIMPLE_INPUT, r);
    return r;
  }

  /* ********************************************************** */
  // id OP_COLON expr
  public static boolean simplePropertyDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simplePropertyDeclaration")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, OP_COLON);
    r = r && expr(b, l + 1);
    exit_section_(b, m, SIMPLE_PROPERTY_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // id OP_COLON id
  public static boolean simpleType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleType")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, OP_COLON, ID);
    exit_section_(b, m, SIMPLE_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // id OP_COLON expr
  public static boolean simpleViewProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simpleViewProperty")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, OP_COLON);
    r = r && expr(b, l + 1);
    exit_section_(b, m, SIMPLE_VIEW_PROPERTY, r);
    return r;
  }

  /* ********************************************************** */
  // 'case' ((LEFT_PAREN <<comma_separated_list expr>> RIGHT_PAREN) | <<comma_separated_list expr>>) '=>' expr
  public static boolean switchCase(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchCase")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_CASE, "<switch case>");
    r = consumeToken(b, "case");
    r = r && switchCase_1(b, l + 1);
    r = r && consumeToken(b, "=>");
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LEFT_PAREN <<comma_separated_list expr>> RIGHT_PAREN) | <<comma_separated_list expr>>
  private static boolean switchCase_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchCase_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = switchCase_1_0(b, l + 1);
    if (!r) r = comma_separated_list(b, l + 1, expr_parser_);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_PAREN <<comma_separated_list expr>> RIGHT_PAREN
  private static boolean switchCase_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchCase_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PAREN);
    r = r && comma_separated_list(b, l + 1, expr_parser_);
    r = r && consumeToken(b, RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'switch' LEFT_PAREN <<comma_separated_list expr>> RIGHT_PAREN LEFT_BRACE switchCase * RIGHT_BRACE
  public static boolean switchExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_EXPR, "<switch expr>");
    r = consumeToken(b, "switch");
    r = r && consumeToken(b, LEFT_PAREN);
    r = r && comma_separated_list(b, l + 1, expr_parser_);
    r = r && consumeTokens(b, 0, RIGHT_PAREN, LEFT_BRACE);
    r = r && switchExpr_5(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // switchCase *
  private static boolean switchExpr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchExpr_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!switchCase(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "switchExpr_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // innerExpr | switchExpr | alternativeExpr
  public static boolean tokenExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tokenExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TOKEN_EXPR, "<token expr>");
    r = innerExpr(b, l + 1);
    if (!r) r = switchExpr(b, l + 1);
    if (!r) r = alternativeExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // bindingsSection | typesSection | inputsSection | propertiesSection | functionsSection | layoutSection
  public static boolean topDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TOP_DECLARATION, "<top declaration>");
    r = bindingsSection(b, l + 1);
    if (!r) r = typesSection(b, l + 1);
    if (!r) r = inputsSection(b, l + 1);
    if (!r) r = propertiesSection(b, l + 1);
    if (!r) r = functionsSection(b, l + 1);
    if (!r) r = layoutSection(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // enumDeclaration | listDeclaration
  public static boolean typeDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeDeclaration")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enumDeclaration(b, l + 1);
    if (!r) r = listDeclaration(b, l + 1);
    exit_section_(b, m, TYPE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // 'types' LEFT_BRACE typeDeclaration * RIGHT_BRACE
  public static boolean typesSection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typesSection")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPES_SECTION, "<types section>");
    r = consumeToken(b, "types");
    r = r && consumeToken(b, LEFT_BRACE);
    r = r && typesSection_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // typeDeclaration *
  private static boolean typesSection_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typesSection_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typesSection_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // refPathList
  public static boolean variableReference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableReference")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = refPathList(b, l + 1);
    exit_section_(b, m, VARIABLE_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // id LEFT_BRACE (include|viewPropertyDeclaration|viewDeclaration) * RIGHT_BRACE
  public static boolean viewDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "viewDeclaration")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, LEFT_BRACE);
    r = r && viewDeclaration_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, VIEW_DECLARATION, r);
    return r;
  }

  // (include|viewPropertyDeclaration|viewDeclaration) *
  private static boolean viewDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "viewDeclaration_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!viewDeclaration_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "viewDeclaration_2", c)) break;
    }
    return true;
  }

  // include|viewPropertyDeclaration|viewDeclaration
  private static boolean viewDeclaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "viewDeclaration_2_0")) return false;
    boolean r;
    r = include(b, l + 1);
    if (!r) r = viewPropertyDeclaration(b, l + 1);
    if (!r) r = viewDeclaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // simpleViewProperty | complexViewProperty
  public static boolean viewPropertyDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "viewPropertyDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VIEW_PROPERTY_DECLARATION, "<view property declaration>");
    r = simpleViewProperty(b, l + 1);
    if (!r) r = complexViewProperty(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean viewType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "viewType")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, VIEW_TYPE, r);
    return r;
  }

  static final Parser ID_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return consumeToken(b, ID);
    }
  };
  static final Parser complexType_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return complexType(b, l + 1);
    }
  };
  static final Parser expr_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return expr(b, l + 1);
    }
  };
  static final Parser functionParameter_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return functionParameter(b, l + 1);
    }
  };
  static final Parser pairRecover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return pairRecover(b, l + 1);
    }
  };
}
