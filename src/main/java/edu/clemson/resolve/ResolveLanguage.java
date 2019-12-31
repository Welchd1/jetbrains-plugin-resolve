package edu.clemson.resolve;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

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

    /**
     * The {@link LanguageFileType} for RESOLVE files.
     */
    public static class ResolveFileType extends LanguageFileType {

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
}
