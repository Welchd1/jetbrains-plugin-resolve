package edu.clemson.resolve.sdk;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.KillableColoredProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.io.FileUtil;
import edu.clemson.resolve.jetbrains.RESOLVEPluginController;
import edu.clemson.resolve.jetbrains.actions.RunRESOLVEOnLanguageFile;
import edu.clemson.resolve.jetbrains.sdk.RESOLVESdkService;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RESOLVEProgramRunningState extends CommandLineState {

    @NotNull
    protected final RESOLVEProgramRunConfiguration configuration;
    @NotNull
    protected final Module module;

    public RESOLVEProgramRunningState(@NotNull ExecutionEnvironment env,
                                      @NotNull Module module,
                                      @NotNull RESOLVEProgramRunConfiguration configuration) {
        super(env);
        this.module = module;
        this.configuration = configuration;
        //TODO
        //addConsoleFilters(new RESOLVEConsoleFilter(
        //        configuration.getProject(), module, configuration.getWorkingDirectoryUrl()));
    }
    public static void  main(String[] args) {

    }
    @NotNull
    public RESOLVEProgramRunConfiguration getConfiguration() {
        return configuration;
    }

    @NotNull
    @Override
    protected ProcessHandler startProcess() throws ExecutionException {
        final Project project = configuration.getProject();
        String filePath = configuration.getFilePath();
        String outputPath = project.getBasePath() + File.separator + "out";
        String classPath = RESOLVESdkService.getInstance(project).getSdkCompilerJarPath(module) + ":" + outputPath;
        String className = getClassName(project, filePath);

        //cross compile from RESOLVE to java
        boolean successfullyGeneratedJava = generateAndWriteJava(project, filePath, outputPath);

        if (!successfullyGeneratedJava) {
            ProcessHandler p = new KillableColoredProcessHandler(new GeneralCommandLine());
            //hmm, not sure about the line below..
            RESOLVEPluginController.getInstance(project).console.attachToProcess(p);
            return p;
        }

        //Compile Java to bytecode and store in /out/ directory
        ProcessHandler javac = compileGeneratedJava(project, classPath, outputPath, filePath);
        if (javac != null) {
            return javac;
        }

        //Execute bytecode
        final KillableColoredProcessHandler processHandler = new KillableColoredProcessHandler(new GeneralCommandLine(
                "java",
                "-cp", classPath,
                className
        ));
        processHandler.setShouldDestroyProcessRecursively(true);
        return processHandler;
    }

    @NotNull
    public File getOuputDirForFile(@NotNull Project project,
                                   @NotNull String baseOutputPath,
                                   @NotNull String filePath) {
        String path = FileUtil.getRelativePath(project.getBasePath(), filePath, File.separatorChar);
        path = baseOutputPath + File.separator + project.getName() + File.separator + path;
        return new File(path.substring(0, path.lastIndexOf("."))).getParentFile();
    }

    @NotNull
    public String getClassName(@NotNull Project project, @NotNull String filePath) {
        String result = FileUtil.getRelativePath(project.getBasePath(), filePath, File.separatorChar);
        result = result.substring(0, result.lastIndexOf('.'));
        result = project.getName() + File.separator + result;
        return result.replaceAll(File.separator, ".");
    }

    public boolean generateAndWriteJava(Project project, String filePath, String outputPath) {
        RunRESOLVEOnLanguageFile g = new RunRESOLVEOnLanguageFile(configuration.getFilePath(), project, "gencode");
        g.outputDir = outputPath;
        Map<String, String> argMap = new LinkedHashMap<>();
        argMap.put("-lib", project.getBasePath());
        argMap.put("-o", outputPath);
        argMap.put("-genCode", "Java");
        g.addArgs(argMap);
        boolean success = false;
        try {
            success = ProgressManager.getInstance().run(g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public ProcessHandler compileGeneratedJava(Project project, String effectiveClassPath, String outputPath, String filePath)
            throws ExecutionException {
        List<String> fileNames = new ArrayList<>();
        File baseOutFile = new File(outputPath);
        File newOutputDir = getOuputDirForFile(project, outputPath, filePath);
        final File[] fileList = newOutputDir.listFiles();
        if (fileList == null || fileList.length == 0) {
            return new KillableColoredProcessHandler(new GeneralCommandLine(
                    "echo",
                    "filelist could not be compiled, make sure .java files are being written to out/ directory"
            ));
        }

        for (File file : fileList) {
            if (file.getAbsolutePath().endsWith(".java")) {
                fileNames.add(file.getAbsolutePath());
            }
        }
        for (String file : fileNames) {
            KillableColoredProcessHandler kcp = new KillableColoredProcessHandler(
                    new GeneralCommandLine("javac", "-cp", effectiveClassPath, "-d", baseOutFile.getPath(), file));
            try {
                if (kcp.getProcess().waitFor() > 0) {
                    return kcp;
                }
            } catch (InterruptedException e) {
                return null;
            }
        }
        return null;
    }
}
