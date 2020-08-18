package org.intellij.sdk.language.psi.impl;

import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.VLayoutFileType;
import org.intellij.sdk.language.VLayoutStructureViewElement;
import org.intellij.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


public class VLayoutPsiImplUtil {

    public static PsiElement setName(PsiElement element, String newElementName) {
        PsiElement b = VLayoutElementFactory.createName(element.getProject(), newElementName);
        element.getNode().replaceChild(element.getFirstChild().getNode(), b.getNode());
        return b;
    }

    public static PsiElement setLastName(PsiElement element, String newElementName) {
        PsiElement b = VLayoutElementFactory.createName(element.getProject(), newElementName);
        element.getNode().replaceChild(element.getLastChild().getNode(), b.getNode());
        return b;
    }

    public static ItemPresentation getPresentation(final NavigatablePsiElement element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return element.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return null;
            }
        };
    }

    @NotNull
    public static TreeElement[] getTreeChildren(@NotNull PsiElement parent) {
        PsiElement[] children = parent.getChildren();
        ArrayList<TreeElement> t = new ArrayList<TreeElement>();
        for (PsiElement e : children) {
            if (e instanceof NavigatablePsiElement && ((NavigatablePsiElement) e).getPresentation() != null) {
                t.add(new VLayoutStructureViewElement((NavigatablePsiElement) e));
            }
        }

        return t.toArray(new TreeElement[0]);
    }

    public static VLayoutFile[] getReferencingFiles(@NotNull PsiElement element) {
        Project project = element.getProject();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(VLayoutFileType.INSTANCE, GlobalSearchScope.allScope(project));
        VLayoutFile current = (VLayoutFile)element.getContainingFile();

        return virtualFiles
                .stream()
                .map(virtualFile -> (VLayoutFile) PsiManager.getInstance(project).findFile(virtualFile))
                .filter(Objects::nonNull)
                .filter(vLayoutFile -> isReferencing(current, vLayoutFile))
                .toArray(VLayoutFile[]::new);
    }

    public static boolean isReferencing(@NotNull VLayoutFile current, @NotNull VLayoutFile target) {
        return current == target;
    }

    public static VLayoutBindingDeclaration[] getBindings(@NotNull PsiElement element) {
        Collection<VLayoutBindingDeclaration> bindings = new ArrayList<>();
        for (VLayoutFile file : getReferencingFiles(element)) {
            Collection<VLayoutBindingDeclaration> d = PsiTreeUtil.findChildrenOfType(file, VLayoutBindingDeclaration.class);
            bindings.addAll(d);
        }
        return bindings.toArray(new VLayoutBindingDeclaration[0]);
    }

    public static VLayoutBindingDeclaration[] getBindings(@NotNull PsiElement element, String name) {
        Collection<VLayoutBindingDeclaration> bindings = new ArrayList<>();
        for (VLayoutFile file : getReferencingFiles(element)) {
            Collection<VLayoutBindingDeclaration> d = PsiTreeUtil.findChildrenOfType(file, VLayoutBindingDeclaration.class);
            for (VLayoutBindingDeclaration i : d) {
                if (Objects.equals(i.getName(), name)) {
                    bindings.add(i);
                }
            }
        }
        return bindings.toArray(new VLayoutBindingDeclaration[0]);
    }

    public static VLayoutTypeDeclaration[] getTypes(@NotNull PsiElement element, String name) {
        Collection<VLayoutTypeDeclaration> types = new ArrayList<>();
        for (VLayoutFile file : getReferencingFiles(element)) {
            Collection<VLayoutTypeDeclaration> d = PsiTreeUtil.findChildrenOfType(file, VLayoutTypeDeclaration.class);
            for (VLayoutTypeDeclaration i : d) {
                if (Objects.equals(i.getName(), name)) {
                    types.add(i);
                }
            }
        }
        return types.toArray(new VLayoutTypeDeclaration[0]);
    }
}