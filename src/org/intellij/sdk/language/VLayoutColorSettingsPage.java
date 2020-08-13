package org.intellij.sdk.language;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.*;
import org.jetbrains.annotations.*;

import javax.swing.*;
import java.util.Map;

public class VLayoutColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Symbol", VLayoutSyntaxHighlighter.OPERATION),
            new AttributesDescriptor("Keyword", VLayoutSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("String", VLayoutSyntaxHighlighter.STRING),
            new AttributesDescriptor("Number", VLayoutSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("Binding", VLayoutSyntaxHighlighter.BINDING),
            new AttributesDescriptor("Input", VLayoutSyntaxHighlighter.INPUT),
            new AttributesDescriptor("Property", VLayoutSyntaxHighlighter.PROPERTY),
            new AttributesDescriptor("Enum Element", VLayoutSyntaxHighlighter.ENUM_ELEMENT),
            new AttributesDescriptor("Type Name", VLayoutSyntaxHighlighter.TYPE_NAME),
            new AttributesDescriptor("Prototype Name", VLayoutSyntaxHighlighter.PROTOTYPE_NAME),
            new AttributesDescriptor("Type Reference", VLayoutSyntaxHighlighter.TYPE_REFERENCE),
            new AttributesDescriptor("Comment", VLayoutSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Bad Value", VLayoutSyntaxHighlighter.BAD_CHARACTER)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return VLayoutIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new VLayoutSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "bindings {\n" +
                "   someView: view\n" +
                "   someButton: button\n" +
                "   someListView: listView\n" +
                "   someListButton: listButton\n" +
                "}\n" +
                "\n" +
                "types {\n" +
                "   SomeEnum: enum(val1, val2, val3)\n" +
                "   SomeList: list(\n" +
                "       prototype1 {\n" +
                "           field1: Number\n" +
                "           field2: Boolean\n" +
                "           field3: SomeEnum\n" +
                "           complexField {\n" +
                "               inner: String\n" +
                "           }\n" +
                "       }\n" +
                "       prototype2 {\n" +
                "           field4: String\n" +
                "       }\n" +
                "   )\n" +
                "}\n" +
                "inputs {\n" +
                "   input1: String\n" +
                "   complexInput {\n" +
                "       inner: Number\n" +
                "       inner2: SomeEnum\n" +
                "   }\n" +
                "}\n" +
                "\n" +
                "properties {\n" +
                "   prop1: input1 + \"some string\"\n" +
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "VLayout";
    }
}