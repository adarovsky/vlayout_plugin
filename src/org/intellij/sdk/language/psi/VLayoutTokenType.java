// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.VLayoutLanguage;
import org.jetbrains.annotations.*;

public class VLayoutTokenType extends IElementType {
    public VLayoutTokenType(@NotNull @NonNls String debugName) {
        super(debugName, VLayoutLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "VLayoutTokenType." + super.toString();
    }
}
