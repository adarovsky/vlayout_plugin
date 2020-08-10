package org.intellij.sdk.language.psi.impl;

import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.VLayoutBindingDeclaration;
import org.intellij.sdk.language.psi.VLayoutTypes;

public class VLayoutPsiImplUtil {
    public static String getKey(VLayoutBindingDeclaration element) {
        ASTNode keyNode = element.getNode().findChildByType(VLayoutTypes.ID);
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    public static String getValue(VLayoutBindingDeclaration element) {
        ASTNode valueNode = element.getNode().findChildByType(VLayoutTypes.VIEW_TYPE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }
}