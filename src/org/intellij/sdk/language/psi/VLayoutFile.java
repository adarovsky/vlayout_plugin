package org.intellij.sdk.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.intellij.sdk.language.*;
import org.jetbrains.annotations.NotNull;

public class VLayoutFile extends PsiFileBase {
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
}