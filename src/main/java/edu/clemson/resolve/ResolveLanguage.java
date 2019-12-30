package edu.clemson.resolve;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ResolveLanguage extends Language {
    public static final ResolveLanguage INSTANCE = new ResolveLanguage();

    private ResolveLanguage() {
        super("RESOLVE");
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return ResolveConstants.RESOLVE;
    }

    @Nullable
    @Override
    public LanguageFileType getAssociatedFileType() {
        return ResolveFileType.INSTANCE;
    }

    @Override
    public boolean isCaseSensitive() {
        return true;
    }
}
