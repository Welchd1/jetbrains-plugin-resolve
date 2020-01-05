package edu.clemson.resolve.sdk;

import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.util.SystemProperties;
import com.intellij.util.containers.ContainerUtil;
import edu.clemson.resolve.ResolveConstants;
import edu.clemson.resolve.project.ResolveLibrariesPathModificationTracker;
import edu.clemson.resolve.sdk.ResolveSdkType.ResolveSdkService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ResolveSdkUtil {

    // \w   A word character, short for [a-zA-Z_0-9]
    // \s   A whitespace character
    // \d   Any digit [0-9]
    //So this pattern allows matching things like 1.1rc2
    private static final Pattern RESOLVE_VERSION_PATTERN =
            Pattern.compile("[\\d.]+(\\w+)?(\\d+)");

    private static final Key<String> RESOLVE_VER_DATA_KEY =
            Key.create("RESOLVE_VERSION_KEY");

    private ResolveSdkUtil() {
    }

    @NotNull
    static Collection<VirtualFile> getSdkDirectoriesToAttach(
            @NotNull String sdkPath, @NotNull String versionString) {
        // src is enough at the moment, possible process binaries from pkg
        return ContainerUtil.createMaybeSingletonList(getSdkSrcDir(
                sdkPath, versionString));
    }

    @Nullable
    private static VirtualFile getSdkSrcDir(@NotNull String sdkPath,
                                            @NotNull String sdkVersion) {
        String srcPath = "src";
        VirtualFile file = VirtualFileManager.getInstance()
                .findFileByUrl(VfsUtilCore.pathToUrl(
                        FileUtil.join(sdkPath, srcPath)));
        return file != null && file.isDirectory() ? file : null;
    }

    @Nullable
    public static String retrieveResolveVersion(@NotNull String sdkPath) {
        try {
            VirtualFile sdkRoot = VirtualFileManager
                    .getInstance()
                    .findFileByUrl(VfsUtilCore.pathToUrl(sdkPath));

            if (sdkRoot != null) {
                String cachedVersion = sdkRoot.getUserData(RESOLVE_VER_DATA_KEY);
                if (cachedVersion != null) {
                    return !cachedVersion.isEmpty() ? cachedVersion : null;
                }
                String path =
                        "/compiler/resources/edu/clemson/resolve/util/version"
                        .replaceAll("/", File.separator);
                VirtualFile versionFile =
                        sdkRoot.findFileByRelativePath(path);

                if (versionFile != null) {
                    String text = VfsUtilCore.loadText(versionFile);
                    String version = parseResolveVersion(text);
                    if (version == null) {
                        ResolveSdkService.LOG.debug(
                                "Cannot parse Resolve version in VERSION.txt");
                    }
                    return version;
                }
                else {
                    ResolveSdkService.LOG.debug(
                            "Cannot find Resolve version file in sdk path: "
                                    + sdkPath);
                }
            }
        }
        catch (IOException e) {
            ResolveSdkService.LOG.debug(
                    "Cannot find Resolve " +
                    "version file in sdk path: " + sdkPath, e);
        }
        return null;
    }

    @Nullable
    static String parseResolveVersion(@NotNull String text) {
        Matcher matcher = RESOLVE_VERSION_PATTERN.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    @Nullable
    public static VirtualFile suggestSdkDirectory() {
        if (SystemInfo.isWindows) {
            return LocalFileSystem
                    .getInstance()
                    .findFileByPath("C:\\" + ResolveConstants.COMPILER_DIR_NAME);
        }
        if (SystemInfo.isMac || SystemInfo.isLinux) {
            final String userHome = SystemProperties.getUserHome();
            String path = userHome +
                    File.separator +
                    "Documents" + File.separator +
                    ResolveConstants.COMPILER_DIR_NAME;
            return LocalFileSystem.getInstance().findFileByPath(path);
        }
        return null;
    }

    @NotNull
    public static Collection<VirtualFile> getRESOLVEPathsRootsFromEnvironment() {
        return ResolveLibrariesPathModificationTracker
                .getResolvePathRootsFromEnv();
    }
}
