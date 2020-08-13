package org.intellij.sdk.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.NavigatablePsiElement;
import org.intellij.sdk.language.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class VLayoutFile extends PsiFileBase implements NavigatablePsiElement {
    public VLayoutFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, VLayoutLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return VLayoutFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "VLayout File";
    }

    @Override
    public ItemPresentation getPresentation() {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return VLayoutIcons.FILE;
            }
        };
    }

}