package org.intellij.sdk.language;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.psi.VLayoutBindingDeclaration;
import org.intellij.sdk.language.psi.VLayoutFile;
import org.intellij.sdk.language.psi.VLayoutNamedElement;

import java.util.*;

public class VLayoutUtil {
    public static List<VLayoutNamedElement> findNamedElements(Project project, String key) {
        List<VLayoutNamedElement> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(VLayoutFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            VLayoutFile file = (VLayoutFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (file != null) {
                Collection<VLayoutNamedElement> children = PsiTreeUtil.findChildrenOfType(file, VLayoutNamedElement.class);
                for (VLayoutNamedElement child : children) {
                    if (child.getName() != null && child.getName().equals(key)) {
                        result.add(child);
                    }
                }
            }
        }

        return result;
    }

    public static List<VLayoutNamedElement> findNamedElements(Project project) {
        List<VLayoutNamedElement> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(VLayoutFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            VLayoutFile file = (VLayoutFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (file != null) {
                Collection<VLayoutNamedElement> children = PsiTreeUtil.findChildrenOfType(file, VLayoutNamedElement.class);
                result.addAll(children);
            }
        }

        return result;
    }
}