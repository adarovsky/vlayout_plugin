// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface VLayoutTypes {

  IElementType ADD_SUB_EXPR = new VLayoutElementType("ADD_SUB_EXPR");
  IElementType ALTERNATIVE_EXPR = new VLayoutElementType("ALTERNATIVE_EXPR");
  IElementType BINDINGS_SECTION = new VLayoutElementType("BINDINGS_SECTION");
  IElementType BINDING_DECLARATION = new VLayoutElementType("BINDING_DECLARATION");
  IElementType COMMA_SEPARATED_LIST = new VLayoutElementType("COMMA_SEPARATED_LIST");
  IElementType COMPARE_EXPR = new VLayoutElementType("COMPARE_EXPR");
  IElementType COMPLEX_INPUT = new VLayoutElementType("COMPLEX_INPUT");
  IElementType COMPLEX_PROPERTY_DECLARATION = new VLayoutElementType("COMPLEX_PROPERTY_DECLARATION");
  IElementType COMPLEX_PROTOTYPE_CONTENT = new VLayoutElementType("COMPLEX_PROTOTYPE_CONTENT");
  IElementType COMPLEX_VIEW_PROPERTY = new VLayoutElementType("COMPLEX_VIEW_PROPERTY");
  IElementType CONDITIONAL_EXPR = new VLayoutElementType("CONDITIONAL_EXPR");
  IElementType CONSTANT_EXPR = new VLayoutElementType("CONSTANT_EXPR");
  IElementType ENUM_DECLARATION = new VLayoutElementType("ENUM_DECLARATION");
  IElementType ENUM_ELEMENT = new VLayoutElementType("ENUM_ELEMENT");
  IElementType EQUAL_EXPR = new VLayoutElementType("EQUAL_EXPR");
  IElementType EXPR = new VLayoutElementType("EXPR");
  IElementType FUNCTIONS_SECTION = new VLayoutElementType("FUNCTIONS_SECTION");
  IElementType FUNCTION_CALL = new VLayoutElementType("FUNCTION_CALL");
  IElementType FUNCTION_DECLARATION = new VLayoutElementType("FUNCTION_DECLARATION");
  IElementType FUNCTION_PARAMETER = new VLayoutElementType("FUNCTION_PARAMETER");
  IElementType INCLUDE = new VLayoutElementType("INCLUDE");
  IElementType INPUTS_SECTION = new VLayoutElementType("INPUTS_SECTION");
  IElementType INPUT_DECLARATION = new VLayoutElementType("INPUT_DECLARATION");
  IElementType LAYOUT_SECTION = new VLayoutElementType("LAYOUT_SECTION");
  IElementType LIST_DECLARATION = new VLayoutElementType("LIST_DECLARATION");
  IElementType LOGICAL_AND_EXPR = new VLayoutElementType("LOGICAL_AND_EXPR");
  IElementType LOGICAL_OR_EXPR = new VLayoutElementType("LOGICAL_OR_EXPR");
  IElementType MUL_DIV_EXPR = new VLayoutElementType("MUL_DIV_EXPR");
  IElementType NEGATE_EXPR = new VLayoutElementType("NEGATE_EXPR");
  IElementType PROPERTIES_SECTION = new VLayoutElementType("PROPERTIES_SECTION");
  IElementType PROPERTY_DECLARATION = new VLayoutElementType("PROPERTY_DECLARATION");
  IElementType PROPERTY_KEY = new VLayoutElementType("PROPERTY_KEY");
  IElementType PROTOTYPE_CONTENT = new VLayoutElementType("PROTOTYPE_CONTENT");
  IElementType PROTOTYPE_DESCRIPTION = new VLayoutElementType("PROTOTYPE_DESCRIPTION");
  IElementType REFERENCE_EXPR = new VLayoutElementType("REFERENCE_EXPR");
  IElementType SHORT_ENUM = new VLayoutElementType("SHORT_ENUM");
  IElementType SIMPLE_EXPR = new VLayoutElementType("SIMPLE_EXPR");
  IElementType SIMPLE_INPUT = new VLayoutElementType("SIMPLE_INPUT");
  IElementType SIMPLE_PROPERTY_DECLARATION = new VLayoutElementType("SIMPLE_PROPERTY_DECLARATION");
  IElementType SIMPLE_PROTOTYPE_CONTENT = new VLayoutElementType("SIMPLE_PROTOTYPE_CONTENT");
  IElementType SIMPLE_VIEW_PROPERTY = new VLayoutElementType("SIMPLE_VIEW_PROPERTY");
  IElementType SWITCH_CASE = new VLayoutElementType("SWITCH_CASE");
  IElementType SWITCH_EXPR = new VLayoutElementType("SWITCH_EXPR");
  IElementType TOKEN_EXPR = new VLayoutElementType("TOKEN_EXPR");
  IElementType TYPES_SECTION = new VLayoutElementType("TYPES_SECTION");
  IElementType TYPE_DECLARATION = new VLayoutElementType("TYPE_DECLARATION");
  IElementType VARIABLE_REFERENCE = new VLayoutElementType("VARIABLE_REFERENCE");
  IElementType VIEW_DECLARATION = new VLayoutElementType("VIEW_DECLARATION");
  IElementType VIEW_PROPERTY_DECLARATION = new VLayoutElementType("VIEW_PROPERTY_DECLARATION");
  IElementType VIEW_TYPE = new VLayoutElementType("VIEW_TYPE");

  IElementType COLOR = new VLayoutTokenType("color");
  IElementType CONST_FALSE = new VLayoutTokenType("false");
  IElementType CONST_TRUE = new VLayoutTokenType("true");
  IElementType ID = new VLayoutTokenType("id");
  IElementType LEFT_BRACE = new VLayoutTokenType("{");
  IElementType LEFT_PAREN = new VLayoutTokenType("(");
  IElementType LINE_COMMENT = new VLayoutTokenType("line_comment");
  IElementType LOCALIZED = new VLayoutTokenType("@");
  IElementType NUMBER = new VLayoutTokenType("number");
  IElementType OP_ALT = new VLayoutTokenType("|");
  IElementType OP_AND = new VLayoutTokenType("&&");
  IElementType OP_COLON = new VLayoutTokenType(":");
  IElementType OP_COMMA = new VLayoutTokenType(",");
  IElementType OP_DIVIDE = new VLayoutTokenType("/");
  IElementType OP_DOT = new VLayoutTokenType(".");
  IElementType OP_EQ = new VLayoutTokenType("=");
  IElementType OP_EQEQ = new VLayoutTokenType("==");
  IElementType OP_LESS = new VLayoutTokenType("<");
  IElementType OP_LESS_EQ = new VLayoutTokenType("<=");
  IElementType OP_MINUS = new VLayoutTokenType("-");
  IElementType OP_MOD = new VLayoutTokenType("%");
  IElementType OP_MORE = new VLayoutTokenType(">");
  IElementType OP_MORE_EQ = new VLayoutTokenType(">=");
  IElementType OP_MULTIPLY = new VLayoutTokenType("*");
  IElementType OP_NEQ = new VLayoutTokenType("!=");
  IElementType OP_NOT = new VLayoutTokenType("!");
  IElementType OP_OPT = new VLayoutTokenType("?");
  IElementType OP_OR = new VLayoutTokenType("||");
  IElementType OP_PLUS = new VLayoutTokenType("+");
  IElementType RIGHT_BRACE = new VLayoutTokenType("}");
  IElementType RIGHT_PAREN = new VLayoutTokenType(")");
  IElementType STRING = new VLayoutTokenType("string");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADD_SUB_EXPR) {
        return new VLayoutAddSubExprImpl(node);
      }
      else if (type == ALTERNATIVE_EXPR) {
        return new VLayoutAlternativeExprImpl(node);
      }
      else if (type == BINDINGS_SECTION) {
        return new VLayoutBindingsSectionImpl(node);
      }
      else if (type == BINDING_DECLARATION) {
        return new VLayoutBindingDeclarationImpl(node);
      }
      else if (type == COMMA_SEPARATED_LIST) {
        return new VLayoutCommaSeparatedListImpl(node);
      }
      else if (type == COMPARE_EXPR) {
        return new VLayoutCompareExprImpl(node);
      }
      else if (type == COMPLEX_INPUT) {
        return new VLayoutComplexInputImpl(node);
      }
      else if (type == COMPLEX_PROPERTY_DECLARATION) {
        return new VLayoutComplexPropertyDeclarationImpl(node);
      }
      else if (type == COMPLEX_PROTOTYPE_CONTENT) {
        return new VLayoutComplexPrototypeContentImpl(node);
      }
      else if (type == COMPLEX_VIEW_PROPERTY) {
        return new VLayoutComplexViewPropertyImpl(node);
      }
      else if (type == CONDITIONAL_EXPR) {
        return new VLayoutConditionalExprImpl(node);
      }
      else if (type == CONSTANT_EXPR) {
        return new VLayoutConstantExprImpl(node);
      }
      else if (type == ENUM_DECLARATION) {
        return new VLayoutEnumDeclarationImpl(node);
      }
      else if (type == ENUM_ELEMENT) {
        return new VLayoutEnumElementImpl(node);
      }
      else if (type == EQUAL_EXPR) {
        return new VLayoutEqualExprImpl(node);
      }
      else if (type == EXPR) {
        return new VLayoutExprImpl(node);
      }
      else if (type == FUNCTIONS_SECTION) {
        return new VLayoutFunctionsSectionImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new VLayoutFunctionCallImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new VLayoutFunctionDeclarationImpl(node);
      }
      else if (type == FUNCTION_PARAMETER) {
        return new VLayoutFunctionParameterImpl(node);
      }
      else if (type == INCLUDE) {
        return new VLayoutIncludeImpl(node);
      }
      else if (type == INPUTS_SECTION) {
        return new VLayoutInputsSectionImpl(node);
      }
      else if (type == INPUT_DECLARATION) {
        return new VLayoutInputDeclarationImpl(node);
      }
      else if (type == LAYOUT_SECTION) {
        return new VLayoutLayoutSectionImpl(node);
      }
      else if (type == LIST_DECLARATION) {
        return new VLayoutListDeclarationImpl(node);
      }
      else if (type == LOGICAL_AND_EXPR) {
        return new VLayoutLogicalAndExprImpl(node);
      }
      else if (type == LOGICAL_OR_EXPR) {
        return new VLayoutLogicalOrExprImpl(node);
      }
      else if (type == MUL_DIV_EXPR) {
        return new VLayoutMulDivExprImpl(node);
      }
      else if (type == NEGATE_EXPR) {
        return new VLayoutNegateExprImpl(node);
      }
      else if (type == PROPERTIES_SECTION) {
        return new VLayoutPropertiesSectionImpl(node);
      }
      else if (type == PROPERTY_DECLARATION) {
        return new VLayoutPropertyDeclarationImpl(node);
      }
      else if (type == PROPERTY_KEY) {
        return new VLayoutPropertyKeyImpl(node);
      }
      else if (type == PROTOTYPE_CONTENT) {
        return new VLayoutPrototypeContentImpl(node);
      }
      else if (type == PROTOTYPE_DESCRIPTION) {
        return new VLayoutPrototypeDescriptionImpl(node);
      }
      else if (type == REFERENCE_EXPR) {
        return new VLayoutReferenceExprImpl(node);
      }
      else if (type == SHORT_ENUM) {
        return new VLayoutShortEnumImpl(node);
      }
      else if (type == SIMPLE_EXPR) {
        return new VLayoutSimpleExprImpl(node);
      }
      else if (type == SIMPLE_INPUT) {
        return new VLayoutSimpleInputImpl(node);
      }
      else if (type == SIMPLE_PROPERTY_DECLARATION) {
        return new VLayoutSimplePropertyDeclarationImpl(node);
      }
      else if (type == SIMPLE_PROTOTYPE_CONTENT) {
        return new VLayoutSimplePrototypeContentImpl(node);
      }
      else if (type == SIMPLE_VIEW_PROPERTY) {
        return new VLayoutSimpleViewPropertyImpl(node);
      }
      else if (type == SWITCH_CASE) {
        return new VLayoutSwitchCaseImpl(node);
      }
      else if (type == SWITCH_EXPR) {
        return new VLayoutSwitchExprImpl(node);
      }
      else if (type == TOKEN_EXPR) {
        return new VLayoutTokenExprImpl(node);
      }
      else if (type == TYPES_SECTION) {
        return new VLayoutTypesSectionImpl(node);
      }
      else if (type == TYPE_DECLARATION) {
        return new VLayoutTypeDeclarationImpl(node);
      }
      else if (type == VARIABLE_REFERENCE) {
        return new VLayoutVariableReferenceImpl(node);
      }
      else if (type == VIEW_DECLARATION) {
        return new VLayoutViewDeclarationImpl(node);
      }
      else if (type == VIEW_PROPERTY_DECLARATION) {
        return new VLayoutViewPropertyDeclarationImpl(node);
      }
      else if (type == VIEW_TYPE) {
        return new VLayoutViewTypeImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
