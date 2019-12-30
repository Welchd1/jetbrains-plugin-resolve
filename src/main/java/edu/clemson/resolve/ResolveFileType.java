package edu.clemson.resolve;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * The {@link LanguageFileType} for RESOLVE files.
 */
public class ResolveFileType extends LanguageFileType {

    public static final ResolveFileType INSTANCE = new ResolveFileType();

    private ResolveFileType() {
        super(ResolveLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "RESOLVE";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "a RESOLVE file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "resolve";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return ResolveIcons.FILE;
    }
}
