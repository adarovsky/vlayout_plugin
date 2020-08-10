package org.intellij.sdk.language;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.language.psi.VLayoutTypes;
import org.jetbrains.annotations.NotNull;

public class VLayoutCompletionContributor extends CompletionContributor {

    public VLayoutCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(),
                new CompletionProvider<CompletionParameters>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        PsiElement element = parameters.getPosition();
                        while (element != null) {
                            System.out.println(element.toString());
                            element = element.getParent();
                        }
                        resultSet.addElement(LookupElementBuilder.create("button"));
                        resultSet.addElement(LookupElementBuilder.create("view"));
                        resultSet.addElement(LookupElementBuilder.create("listView"));
                        resultSet.addElement(LookupElementBuilder.create("listButton"));
                    }
                }
        );
    }
}