package edu.clemson.resolve;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * The {@link LanguageFileType} for RESOLVE files.
 */
public class RESOLVEFileType extends LanguageFileType {

    public static final RESOLVEFileType INSTANCE = new RESOLVEFileType();

    private RESOLVEFileType() {
        super(RESOLVELanguage.INSTANCE);
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
        return RESOLVEIcons.FILE;
    }
}
