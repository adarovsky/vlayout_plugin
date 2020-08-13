package org.intellij.sdk.language;

import com.intellij.ide.structureView.*;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.psi.PsiFile;
import org.intellij.sdk.language.psi.VLayoutFile;
import org.jetbrains.annotations.NotNull;

public class VLayoutStructureViewModel extends StructureViewModelBase implements
        StructureViewModel.ElementInfoProvider {
    public VLayoutStructureViewModel(PsiFile psiFile) {
        super(psiFile, new VLayoutStructureViewElement(psiFile));
    }

    @NotNull
    public Sorter[] getSorters() {
        return new Sorter[]{Sorter.ALPHA_SORTER};
    }


    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        return false;//element instanceof VLayoutFile;
    }
}