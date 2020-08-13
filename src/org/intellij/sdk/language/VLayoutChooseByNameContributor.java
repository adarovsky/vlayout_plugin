package org.intellij.sdk.language;

import com.intellij.navigation.*;
import com.intellij.openapi.project.Project;
import org.intellij.sdk.language.psi.VLayoutNamedElement;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class VLayoutChooseByNameContributor implements ChooseByNameContributor {
    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        List<VLayoutNamedElement> properties = VLayoutUtil.findNamedElements(project);
        List<String> names = new ArrayList<>(properties.size());
        for (VLayoutNamedElement property : properties) {
            if (property.getName() != null && property.getName().length() > 0) {
                names.add(property.getName());
            }
        }
        return names.toArray(new String[names.size()]);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        // TODO: include non project items
        List<VLayoutNamedElement> properties = VLayoutUtil.findNamedElements(project, name);
        return properties.toArray(new NavigationItem[properties.size()]);
    }
}