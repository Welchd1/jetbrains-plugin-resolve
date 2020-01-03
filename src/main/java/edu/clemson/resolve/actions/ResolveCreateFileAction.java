package edu.clemson.resolve.actions;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import edu.clemson.resolve.ResolveIcons;
import org.jetbrains.annotations.NotNull;

public class ResolveCreateFileAction
        extends
        CreateFileFromTemplateAction implements DumbAware {

    public static final String FILE_TEMPLATE = "RESOLVE File";
    public static final String NEW_RESOLVE_FILE = "New RESOLVE File";

    public ResolveCreateFileAction() {
        super(NEW_RESOLVE_FILE, "", ResolveIcons.FILE);
    }

    @Override
    protected void buildDialog(Project project,
                               PsiDirectory directory,
                               @NotNull CreateFileFromTemplateDialog.Builder builder) {
        builder.setTitle(NEW_RESOLVE_FILE)
                .addKind("Empty file", ResolveIcons.FILE, FILE_TEMPLATE);
    }

    @NotNull
    @Override
    protected String getActionName(PsiDirectory directory,
                                   @NotNull String newName,
                                   String templateName) {
        return NEW_RESOLVE_FILE;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ResolveCreateFileAction;
    }
}
