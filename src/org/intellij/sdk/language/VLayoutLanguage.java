package org.intellij.sdk.language;

import com.intellij.lang.Language;

public class VLayoutLanguage extends Language {
    public static final VLayoutLanguage INSTANCE = new VLayoutLanguage();

    private VLayoutLanguage() {
        super("VLayout");
    }
}
