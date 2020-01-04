package edu.clemson.resolve.project;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.*;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.ModificationTracker;
import com.intellij.openapi.util.SimpleModificationTracker;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.util.Function;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.messages.Topic;
import com.intellij.util.xmlb.XmlSerializerUtil;
import edu.clemson.resolve.ResolveConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class ResolveLibrariesService<T extends ResolveLibrariesState>
        extends
        SimpleModificationTracker implements PersistentStateComponent<T> {

    static final Topic<LibrariesListener> LIBRARIES_TOPIC =
            new Topic<>("libraries changes", LibrariesListener.class);
    protected final T state = createState();

    @NotNull
    @Override
    public T getState() {
        return state;
    }

    @Override
    public void loadState(T state) {
        XmlSerializerUtil.copyBean(state, this.state);
    }

    @NotNull
    protected T createState() {
        //noinspection unchecked
        return (T) new ResolveLibrariesState();
    }

    @NotNull
    public static Collection<? extends VirtualFile> getUserDefinedLibraries(
            @NotNull Module module) {
        Set<VirtualFile> result = new LinkedHashSet<>();
        result.addAll(resolveLangRootsFromUrls(ResolveModuleLibrariesService
                .getInstance(module).getLibraryRootUrls()));
        result.addAll(getUserDefinedLibraries(module.getProject()));
        return result;
    }

    @NotNull
    public static Collection<? extends VirtualFile> getUserDefinedLibraries(
            @NotNull Project project) {
        Set<VirtualFile> result = new LinkedHashSet<>();
        result.addAll(resolveLangRootsFromUrls(ResolveProjectLibraryService
                .getInstance(project).getLibraryRootUrls()));
        result.addAll(getUserDefinedLibraries());
        return result;
    }

    @NotNull
    public static Collection<? extends VirtualFile> getUserDefinedLibraries() {
        return resolveLangRootsFromUrls(RESOLVEApplicationLibrariesService
                .getInstance().getLibraryRootUrls());
    }

    @NotNull
    public static ModificationTracker[] getModificationTrackers(
            @NotNull Project project, @Nullable Module module) {
        return module != null
                ? new ModificationTracker[]{RESOLVEModuleLibrariesService
                .getInstance(module), RESOLVEProjectLibrariesService
                .getInstance(module.getProject()),
                RESOLVEApplicationLibrariesService.getInstance()}

                : new ModificationTracker[]{RESOLVEProjectLibrariesService
                .getInstance(project),
                RESOLVEApplicationLibrariesService.getInstance()};
    }


    public void setLibraryRootUrls(@NotNull String... libraryRootUrls) {
        setLibraryRootUrls(Arrays.asList(libraryRootUrls));
    }

    public void setLibraryRootUrls(@NotNull Collection<String> libraryRootUrls) {
        if (!state.getUrls().equals(libraryRootUrls)) {
            state.setUrls(libraryRootUrls);
            incModificationCount();
            ApplicationManager.getApplication()
                    .getMessageBus()
                    .syncPublisher(LIBRARIES_TOPIC)
                    .librariesChanged(libraryRootUrls);
        }
    }

    @NotNull
    public Collection<String> getLibraryRootUrls() {
        return state.getUrls();
    }

    @NotNull
    private static Collection<? extends VirtualFile> resolveLangRootsFromUrls(
            @NotNull Collection<String> urls) {
        return ContainerUtil.mapNotNull(urls, url ->
                VirtualFileManager.getInstance().findFileByUrl(url));
    }

    public interface LibrariesListener {
        void librariesChanged(@NotNull Collection<String> newRootUrls);
    }

    //ORIGINAL: (scheme = StorageScheme.DIRECTORY_BASED) is apparently the default now.
    /*@State(
            name = RESOLVEConstants.RESOLVE_LIBRARIES_SERVICE_NAME,
            storages = {
                    @Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
                    @Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR + "/" +
                            RESOLVEConstants.RESOLVE_LIBRARIES_CONFIG_FILE,
                            scheme = StorageScheme.DIRECTORY_BASED)
            }
    )*/
    @State(
            name = ResolveConstants.RESOLVE_LIBRARIES_SERVICE_NAME,
            storages = {
                    @Storage(value = StoragePathMacros.PRODUCT_WORKSPACE_FILE),
                    @Storage(value = StoragePathMacros.CACHE_FILE + "/" +
                            ResolveConstants.RESOLVE_LIBRARIES_CONFIG_FILE),
            }
    )
    public static class ResolveProjectLibraryService
            extends
            ResolveLibrariesService<ResolveLibrariesState> {
        public static ResolveProjectLibraryService getInstance(
                @NotNull Project project) {
            return ServiceManager.getService(project,
                    ResolveProjectLibraryService.class);
        }
    }

    @State(
            name = ResolveConstants.RESOLVE_LIBRARIES_SERVICE_NAME,
            storages = @Storage(value = StoragePathMacros.MODULE_FILE)
    )
    public static class ResolveModuleLibrariesService
            extends
            ResolveLibrariesService<ResolveLibrariesState> {
        public static ResolveModuleLibrariesService getInstance(
                @NotNull Module module) {
            return ModuleServiceManager.getService(module,
                    ResolveModuleLibrariesService.class);
        }
    }
