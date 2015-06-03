package edu.clemson.resolve.plugin.adaptors;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import edu.clemson.resolve.plugin.Icons;
import edu.clemson.resolve.plugin.RESOLVEFileType;
import edu.clemson.resolve.plugin.RESOLVELanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class RESOLVEFileRoot extends PsiFileBase {

    public RESOLVEFileRoot(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, RESOLVELanguage.INSTANCE);
    }

    @NotNull @Override public FileType getFileType() {
        return RESOLVEFileType.INSTANCE;
    }

    @Override public String toString() {
        return "RESOLVE file";
    }

    @Override public Icon getIcon(int flags) {
        return Icons.FILE;
    }

    @NotNull @Override public PsiElement[] getChildren() {
        return super.getChildren();
    }
}
