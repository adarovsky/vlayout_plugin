package org.intellij.sdk.language;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.IncorrectOperationException;
import org.intellij.sdk.language.psi.VLayoutBindingDeclaration;
import org.intellij.sdk.language.psi.VLayoutElementFactory;
import org.intellij.sdk.language.psi.VLayoutFile;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

class VLayoutCreatePropertyQuickFix extends BaseIntentionAction {
    private final String key;

    VLayoutCreatePropertyQuickFix(String key) {
        this.key = key;
    }

    @NotNull
    @Override
    public String getText() {
        return "Create property";
    }

    @NotNull
    @Override
    public String getFamilyName() {
        return "VLayout properties";
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
        return true;
    }

    @Override
    public void invoke(@NotNull final Project project, final Editor editor, PsiFile file) throws
            IncorrectOperationException {
        ApplicationManager.getApplication().invokeLater(() -> {
            Collection<VirtualFile> virtualFiles =
                    FileTypeIndex.getFiles(VLayoutFileType.INSTANCE, GlobalSearchScope.allScope(project) );
            if (virtualFiles.size() == 1) {
                createProperty(project, virtualFiles.iterator().next());
            } else {
                final FileChooserDescriptor descriptor =
                        FileChooserDescriptorFactory.createSingleFileDescriptor(VLayoutFileType.INSTANCE);
                descriptor.setRoots(ProjectUtil.guessProjectDir(project));
                final VirtualFile file1 = FileChooser.chooseFile(descriptor, project, null);
                if (file1 != null) {
                    createProperty(project, file1);
                }
            }
        });
    }

    private void createProperty(final Project project, final VirtualFile file) {
        WriteCommandAction.writeCommandAction(project).run(() -> {
            VLayoutFile simpleFile = (VLayoutFile) PsiManager.getInstance(project).findFile(file);
            ASTNode lastChildNode = simpleFile.getNode().getLastChildNode();
            // TODO: Add another check for CRLF
            VLayoutBindingDeclaration property = VLayoutElementFactory.createBinding(project, key, "button");
            simpleFile.getNode().addChild(property.getNode());
            ((Navigatable) property.getLastChild().getNavigationElement()).navigate(true);
            FileEditorManager.getInstance(project).getSelectedTextEditor().getCaretModel().moveCaretRelatively(2, 0, false, false, false);
        });
    }
}