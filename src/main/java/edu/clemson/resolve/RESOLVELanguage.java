package edu.clemson.resolve;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RESOLVELanguage extends Language {
    public static final RESOLVELanguage INSTANCE = new RESOLVELanguage();

    private RESOLVELanguage() {
        super("RESOLVE");
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return RESOLVEConstants.RESOLVE;
    }

    @Nullable
    @Override
    public LanguageFileType getAssociatedFileType() {
        return RESOLVEFileType.INSTANCE;
    }

    @Override
    public boolean isCaseSensitive() {
        return true;
    }
}
