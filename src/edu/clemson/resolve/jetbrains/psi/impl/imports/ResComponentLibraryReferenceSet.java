package edu.clemson.resolve.jetbrains.psi.impl.imports;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileSystemItem;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReference;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReferenceSet;
import com.intellij.util.Function;
import com.intellij.util.containers.ContainerUtil;
import edu.clemson.resolve.jetbrains.psi.ResModuleIdentifier;
import edu.clemson.resolve.jetbrains.sdk.RESOLVESdkUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

/** Represents a reference set to guide the completions
 *  This code is adapted to our purposes from the intellij go language
 *  plugin located here:
 *  <p>
 *  <a href="https://github.com/go-lang-plugin-org/go-lang-idea-plugin">https://github.com/go-lang-plugin-org/go-lang-idea-plugin/a>
 */
public class ResComponentLibraryReferenceSet extends FileReferenceSet {

    public ResComponentLibraryReferenceSet(@NotNull ResModuleIdentifier moduleIdentifier) {
        super(moduleIdentifier.getText(), moduleIdentifier,
                moduleIdentifier.getModuleIdentiferTextRange().getStartOffset(), null, true);
    }

    @NotNull
    @Override
    public Collection<PsiFileSystemItem> computeDefaultContexts() {
        PsiFile file = getContainingFile();
        if (file == null || !file.isValid() || isAbsolutePathReference()) {
            return Collections.emptyList();
        }

        final PsiManager psiManager = file.getManager();
        Module module = ModuleUtilCore.findModuleForPsiElement(file);
        Project project = file.getProject();
        LinkedHashSet<VirtualFile> sourceRoots = RESOLVESdkUtil.getSourcesPathsToLookup(project, module);
        return ContainerUtil.mapNotNull(sourceRoots,
                new Function<VirtualFile, PsiFileSystemItem>() {
                    @Nullable
                    @Override
                    public PsiFileSystemItem fun(VirtualFile file) {
                        return psiManager.findDirectory(file);
                    }
                });
    }

    @Nullable
    @Override
    public PsiFileSystemItem resolve() {
        return isAbsolutePathReference() ? null : super.resolve();
    }

    @NotNull
    @Override
    public FileReference createFileReference(TextRange range, int index, String text) {
        return new ResModuleIdentifierReference(this, range, index, text);
    }
}
