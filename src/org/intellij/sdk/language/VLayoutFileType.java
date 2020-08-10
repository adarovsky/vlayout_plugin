package org.intellij.sdk.language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
public class VLayoutFileType extends LanguageFileType {
    public static final VLayoutFileType INSTANCE = new VLayoutFileType();

    private VLayoutFileType() {
        super(VLayoutLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "VLayout File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "VLayout language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "VLayout";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return VLayoutIcons.FILE;
    }
}
