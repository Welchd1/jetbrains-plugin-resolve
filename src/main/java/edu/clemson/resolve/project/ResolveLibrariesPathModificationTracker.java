package edu.clemson.resolve.project;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.PathMacros;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.*;
import com.intellij.util.EnvironmentUtil;
import com.intellij.util.SystemProperties;
import com.intellij.util.containers.ContainerUtil;
import edu.clemson.resolve.ResolveConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.*;

public class ResolveLibrariesPathModificationTracker {

    private final Set<String> pathsToTrack =
            new HashSet<>();

    private final Collection<VirtualFile> resolvePathRoots =
            new LinkedHashSet<>();

    @Nullable
    public static String retrieveResolvePathFromEnvironment() {
        if (ApplicationManager.getApplication().isUnitTestMode()) return null;

        String path = EnvironmentUtil.getValue(ResolveConstants.RESOLVE_PATH);
        return path != null ? path : PathMacros
                .getInstance()
                .getValue(ResolveConstants.RESOLVE_PATH);
    }

    public ResolveLibrariesPathModificationTracker() {
        String resPath = retrieveResolvePathFromEnvironment();
        if (resPath != null) {
            String home = SystemProperties.getUserHome();
            for (String s : StringUtil.split(resPath, File.pathSeparator)) {
                if (s.contains("$HOME")) {
                    s = s.replaceAll("\\$HOME", home);
                }
                pathsToTrack.add(s);
            }
        }

        /*Project[] projects = ProjectManager.getInstance().getOpenProjects();
        if (projects.length == 0) {
            throw new RuntimeException("No RESOLVE projects found -- " +
                    "stopping; RESOLVE path modification tracker init error");
        }

        Project project = projects[0];
        recalculateFiles();
        project.getMessageBus().connect().subscribe(
                VirtualFileManager.VFS_CHANGES, new BulkFileListener() {
            @Override
            public void before(@NotNull List<? extends VFileEvent> events) {
                //TODO: Figure out how to make this do what the
                // VirtualFileListener implementation does below.
            }
        });*/

        VirtualFileManager.getInstance().addVirtualFileListener(
                new VirtualFileAdapter() {
                    @Override
                    public void fileCreated(@NotNull VirtualFileEvent event) {
                        handleEvent(event);
                    }

                    @Override
                    public void fileDeleted(@NotNull VirtualFileEvent event) {
                        handleEvent(event);
                    }

                    @Override
                    public void fileMoved(@NotNull VirtualFileMoveEvent event) {
                        handleEvent(event);
                    }

                    @Override
                    public void fileCopied(@NotNull VirtualFileCopyEvent event) {
                        handleEvent(event);
                    }

                    private void handleEvent(VirtualFileEvent event) {
                        if (pathsToTrack.contains(event.getFile().getPath())) {
                            recalculateFiles();
                        }
                    }
                });
    }

    private void recalculateFiles() {
        Collection<VirtualFile> result = new LinkedHashSet<>();
        for (String path : pathsToTrack) {
            ContainerUtil.addIfNotNull(result, LocalFileSystem.getInstance()
                    .findFileByPath(path));
        }
        updateResolvePathRoots(result);
    }

    private synchronized void updateResolvePathRoots(
            Collection<VirtualFile> newRoots) {
        resolvePathRoots.clear();
        resolvePathRoots.addAll(newRoots);
    }

    private synchronized Collection<VirtualFile> getResolvePathRoots() {
        return resolvePathRoots;
    }

    public static Collection<VirtualFile> getRESOLVEEnvironmentRESOLVE_PATHRoots() {
        return ServiceManager.getService(ResolveLibrariesPathModificationTracker.class)
                .getResolvePathRoots();
    }
}
