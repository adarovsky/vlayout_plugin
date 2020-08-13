package org.intellij.sdk.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.VLayoutFileType;

public class VLayoutElementFactory {
    public static VLayoutBindingDeclaration createBinding(Project project, String name, String value) {
        final VLayoutFile file = createFile(project, "bindings { " + name + ": " + value + "}");
        return (VLayoutBindingDeclaration) file.getFirstChild().getFirstChild();
    }

    public static PsiElement createName(Project project, String name) {
        final VLayoutFile file = createFile(project, "bindings { " + name + ": button }");
        PsiElement binding = PsiTreeUtil.findChildOfType(file, VLayoutBindingDeclaration.class);
        return binding.getFirstChild();
    }

    public static VLayoutFile createFile(Project project, String text) {
        String name = "dummy.vlayout";
        return (VLayoutFile) PsiFileFactory.getInstance( project).createFileFromText(name, VLayoutFileType.INSTANCE, text);
    }

}