package edu.clemson.resolve;

import com.intellij.ide.util.projectWizard.*;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import edu.clemson.resolve.sdk.ResolveSdkType;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Allows registration of RESOLVE specific projects on the new project page. This
 * includes how the new project wizard interacts with the plugin and how the
 * user links to the RESOLVE compiler.
 */
public class ResolveModuleType
        extends
        ModuleType<ResolveModuleType.ResolveModuleBuilder> {

    public ResolveModuleType() {
        super(ResolveConstants.MODULE_TYPE_ID);
    }

    @NotNull
    public static ResolveModuleType getInstance() {
        return (ResolveModuleType) ModuleTypeManager
                .getInstance()
                .findByID(ResolveConstants.MODULE_TYPE_ID);
    }

    @NotNull
    @Override
    public ResolveModuleBuilder createModuleBuilder() {
        return new ResolveModuleBuilder();
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @NotNull
    @Override
    public String getName() {
        return "RESOLVE Module";
    }

    @Nls(capitalization = Nls.Capitalization.Sentence)
    @NotNull
    @Override
    public String getDescription() {
        return "RESOLVE modules are used for developing " +
                "<b>RESOLVE</b> component based software.";
    }

    @NotNull
    @Override
    public Icon getNodeIcon(boolean isOpened) {
        return ResolveIcons.MODULE;
    }

    @NotNull
    public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext,
                                                @NotNull final ResolveModuleBuilder moduleBuilder,
                                                @NotNull ModulesProvider modulesProvider) {
        return new ModuleWizardStep[]{
                new ProjectJdkForModuleStep(wizardContext, ResolveSdkType.getInstance()) {
                    @Override
                    public void updateDataModel() {
                        super.updateDataModel();
                        moduleBuilder.setModuleJdk(getJdk());
                    }
                }};
    }

    public static class ResolveModuleBuilder
            extends JavaModuleBuilder
            implements SourcePathsBuilder,
            ModuleBuilderListener {

        @Override
        public void moduleCreated(@NotNull Module module) {

        }
    }
}
