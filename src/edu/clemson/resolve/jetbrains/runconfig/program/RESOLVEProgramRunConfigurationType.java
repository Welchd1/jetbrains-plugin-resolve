package edu.clemson.resolve.jetbrains.runconfig.program;

import com.intellij.compiler.options.CompileStepBeforeRun;
import com.intellij.execution.BeforeRunTask;
import com.intellij.execution.configurations.*;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import edu.clemson.resolve.jetbrains.RESOLVEConstants;
import edu.clemson.resolve.jetbrains.RESOLVEIcons;
import org.jetbrains.annotations.NotNull;

public class RESOLVEProgramRunConfigurationType extends ConfigurationTypeBase {

    public RESOLVEProgramRunConfigurationType() {
        super("RESOLVERunConfiguration", "RESOLVE Program", "RESOLVE program run configuration",
                RESOLVEIcons.PROGRAM_RUN);
        addFactory(new ConfigurationFactory(this) {
            @Override
            @NotNull
            public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
                return new RESOLVEProgramRunConfiguration(RESOLVEConstants.RESOLVE, project, getInstance());
            }
        });
    }

    @NotNull
    public static RESOLVEProgramRunConfigurationType getInstance() {
        return Extensions.findExtension(CONFIGURATION_TYPE_EP, RESOLVEProgramRunConfigurationType.class);
    }
}
