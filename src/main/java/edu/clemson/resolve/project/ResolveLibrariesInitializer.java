package edu.clemson.resolve.project;

import com.intellij.ProjectTopics;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationListener;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleComponent;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.*;
import com.intellij.openapi.roots.impl.OrderEntryUtil;
import com.intellij.openapi.roots.impl.libraries.LibraryEx;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar;
import com.intellij.openapi.startup.StartupManager;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.vfs.*;
import com.intellij.util.Alarm;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.messages.MessageBusConnection;
import edu.clemson.resolve.ResolveConstants;
import edu.clemson.resolve.sdk.ResolveSdkType;
import edu.clemson.resolve.sdk.ResolveSdkUtil;
import org.jetbrains.annotations.NotNull;

import javax.swing.event.HyperlinkEvent;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResolveLibrariesInitializer implements ModuleComponent {
    private static final String RESOLVE_LIB_NAME = "RESOLVEPATH";
    private static final String RESOLVE_LIBRARIES_NOTIFICATION_HAD_BEEN_SHOWN =
            "resolve.libraries.notification.had.been.shown";
    private static final int UPDATE_DELAY = 300;

    private final Alarm myAlarm;
    private final MessageBusConnection myConnection;
    private boolean myModuleInitialized;

    @NotNull
    private final Set<VirtualFile> myLastHandledRESOLVEPathSourcesRoots =
            new HashSet<>();
    @NotNull
    private final Set<VirtualFile> myLastHandledExclusions =
            new HashSet<>();
    @NotNull
    private final Set<LocalFileSystem.WatchRequest> myWatchedRequests =
            new HashSet<>();

    @NotNull
    private final Module myModule;

    @NotNull
    private final VirtualFileAdapter myFilesListener = new VirtualFileAdapter() {
    };

    public ResolveLibrariesInitializer(@NotNull Module module) {
        myModule = module;
        myAlarm = ApplicationManager.getApplication().isUnitTestMode()
                ? new Alarm()
                : new Alarm(Alarm.ThreadToUse.POOLED_THREAD, myModule);
        myConnection = myModule.getMessageBus().connect();
    }

    @Override
    public void moduleAdded() {
        if (!myModuleInitialized) {
            myConnection.subscribe(ProjectTopics.PROJECT_ROOTS,
                    new ModuleRootListener() {
                        @Override
                        public void rootsChanged(ModuleRootEvent event) {
                            scheduleUpdate();
                        }
                    });
            myConnection.subscribe(ResolveLibrariesService.LIBRARIES_TOPIC,
                    newRootUrls -> scheduleUpdate());

            final Project project = myModule.getProject();
            StartupManager.getInstance(project).runWhenProjectIsInitialized(new Runnable() {
                @Override
                public void run() {
                    if (!project.isDisposed() && !myModule.isDisposed()) {
                    }
                }
            });

            VirtualFileManager.getInstance()
                    .addVirtualFileListener(myFilesListener);
        }
        scheduleUpdate(0);
        myModuleInitialized = true;
    }

    private void scheduleUpdate() {
        scheduleUpdate(UPDATE_DELAY);
    }

    private void scheduleUpdate(int delay) {
        myAlarm.cancelAllRequests();
        UpdateRequest updateRequest = new UpdateRequest();
        myAlarm.addRequest(updateRequest, delay);
    }

    private void attachLibraries(@NotNull final Collection<VirtualFile> libraryRoots, final Set<VirtualFile> exclusions) {
        ApplicationManager.getApplication().assertIsDispatchThread();

        if (!libraryRoots.isEmpty()) {
            ApplicationManager.getApplication().runWriteAction(() -> {
                ModuleRootManager model =
                        ModuleRootManager.getInstance(myModule);
                LibraryOrderEntry goLibraryEntry =
                        OrderEntryUtil.findLibraryOrderEntry(model,
                                getLibraryName());

                if (goLibraryEntry != null && goLibraryEntry.isValid()) {
                    Library library = goLibraryEntry.getLibrary();
                    if (library != null && !((LibraryEx) library).isDisposed()) {
                        fillLibrary(library, libraryRoots, exclusions);
                    }
                } else {
                    LibraryTable libraryTable = LibraryTablesRegistrar
                            .getInstance()
                            .getLibraryTable(myModule.getProject());
                    Library library = libraryTable
                            .createLibrary(getLibraryName());
                    fillLibrary(library, libraryRoots, exclusions);
                    ModuleRootModificationUtil.addDependency(myModule, library);
                }
            });
            showNotification(myModule.getProject());
        } else {
            removeLibraryIfNeeded();
        }
    }

    public String getLibraryName() {
        return RESOLVE_LIB_NAME + " <" + myModule.getName() + ">";
    }

    private static void fillLibrary(@NotNull Library library,
                                    @NotNull Collection<VirtualFile> libraryRoots,
                                    Set<VirtualFile> exclusions) {
        ApplicationManager.getApplication().assertWriteAccessAllowed();

        Library.ModifiableModel libraryModel = library.getModifiableModel();
        for (String root : libraryModel.getUrls(OrderRootType.CLASSES)) {
            libraryModel.removeRoot(root, OrderRootType.CLASSES);
        }
        for (VirtualFile libraryRoot : libraryRoots) {
            libraryModel.addRoot(libraryRoot, OrderRootType.CLASSES);
        }
        for (VirtualFile root : exclusions) {
            ((LibraryEx.ModifiableModelEx) libraryModel)
                    .addExcludedRoot(root.getUrl());
        }
        libraryModel.commit();
    }

    private void removeLibraryIfNeeded() {
        ApplicationManager.getApplication().assertIsDispatchThread();

        final ModifiableModelsProvider modelsProvider =
                ModifiableModelsProvider.SERVICE.getInstance();
        final ModifiableRootModel model =
                modelsProvider.getModuleModifiableModel(myModule);
        final LibraryOrderEntry goLibraryEntry =
                OrderEntryUtil.findLibraryOrderEntry(model, getLibraryName());
        if (goLibraryEntry != null) {
            ApplicationManager.getApplication().runWriteAction(new Runnable() {
                @Override
                public void run() {
                    Library library = goLibraryEntry.getLibrary();
                    if (library != null) {
                        LibraryTable table = library.getTable();
                        if (table != null) {
                            table.removeLibrary(library);
                            model.removeOrderEntry(goLibraryEntry);
                            modelsProvider.commitModuleModifiableModel(model);
                        }
                    } else {
                        modelsProvider.disposeModuleModifiableModel(model);
                    }
                }
            });
        } else {
            ApplicationManager.getApplication().runWriteAction(new Runnable() {
                @Override
                public void run() {
                    modelsProvider.disposeModuleModifiableModel(model);
                }
            });
        }
    }

    private static void showNotification(@NotNull final Project project) {
        PropertiesComponent propertiesComponent =
                PropertiesComponent.getInstance(project);
        boolean shownAlready;
        //noinspection SynchronizationOnLocalVariableOrMethodParameter
        synchronized (propertiesComponent) {
            shownAlready = propertiesComponent
                    .getBoolean(RESOLVE_LIBRARIES_NOTIFICATION_HAD_BEEN_SHOWN,
                            false);
            if (!shownAlready) {
                propertiesComponent.setValue(
                        RESOLVE_LIBRARIES_NOTIFICATION_HAD_BEEN_SHOWN,
                        String.valueOf(true));
            }
        }

        if (!shownAlready) {
            NotificationListener.Adapter notificationListener =
                    new NotificationListener.Adapter() {
                @Override
                protected void hyperlinkActivated(
                        @NotNull Notification notification,
                        @NotNull HyperlinkEvent event) {
                    //if ( event.getEventType()==HyperlinkEvent.EventType.ACTIVATED && "configure".equals(event.getDescription()) ) {
                    //   GoLibrariesConfigurableProvider.showModulesConfigurable(project);
                    //}
                }
            };
            Notification notification =
                    ResolveConstants.RESOLVE_NOTIFICATION_GROUP
                            .createNotification("RESOLVEPATH was detected",
                    "We've detected some libraries from your RESOLVEPATH.\n" +
                            "You may want to add extra libraries in <a href='configure'>RESOLVE Libraries configuration</a>.",
                    NotificationType.INFORMATION, notificationListener);
            Notifications.Bus.notify(notification, project);
        }
    }

    @Override
    public void initComponent() {
    }

    @Override
    public void disposeComponent() {
        Disposer.dispose(myConnection);
        Disposer.dispose(myAlarm);
        VirtualFileManager.getInstance().removeVirtualFileListener(myFilesListener);
        myLastHandledRESOLVEPathSourcesRoots.clear();
        myLastHandledExclusions.clear();
        LocalFileSystem.getInstance().removeWatchedRoots(myWatchedRequests);
        myWatchedRequests.clear();
    }

    @Override
    public void projectOpened() {

    }

    @Override
    public void projectClosed() {
        disposeComponent();
    }

    @NotNull
    @Override
    public String getComponentName() {
        return getClass().getName();
    }

    private class UpdateRequest implements Runnable {
        @Override
        public void run() {
            final Project project = myModule.getProject();
            if (ResolveSdkType.ResolveSdkService.getInstance(project)
                    .isResolveModule(myModule)) {
                synchronized (myLastHandledRESOLVEPathSourcesRoots) {
                    final Collection<VirtualFile> goPathSourcesRoots =
                            ResolveSdkUtil.getRESOLVEPathSources(project, myModule);
                    final Set<VirtualFile> excludeRoots =
                            ContainerUtil.newHashSet(ProjectRootManager
                                    .getInstance(project).getContentRoots());
                    ProgressIndicatorProvider.checkCanceled();
                    if (!myLastHandledRESOLVEPathSourcesRoots
                            .equals(goPathSourcesRoots) ||
                            !myLastHandledExclusions.equals(excludeRoots)) {
                        final Collection<VirtualFile> includeRoots =
                                gatherIncludeRoots(goPathSourcesRoots, excludeRoots);
                        ApplicationManager.getApplication().invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                if (!myModule.isDisposed() &&
                                        ResolveSdkType.ResolveSdkService
                                                .getInstance(project)
                                                .isResolveModule(myModule)) {
                                    attachLibraries(includeRoots, excludeRoots);
                                }
                            }
                        });

                        myLastHandledRESOLVEPathSourcesRoots.clear();
                        myLastHandledRESOLVEPathSourcesRoots.addAll(goPathSourcesRoots);

                        myLastHandledExclusions.clear();
                        myLastHandledExclusions.addAll(excludeRoots);

                        List<String> paths =
                                ContainerUtil.map(goPathSourcesRoots, VirtualFile::getPath);
                        myWatchedRequests.clear();
                        myWatchedRequests.addAll(LocalFileSystem
                                .getInstance().addRootsToWatch(paths, true));
                    }
                }
            } else {
                synchronized (myLastHandledRESOLVEPathSourcesRoots) {
                    LocalFileSystem.getInstance().removeWatchedRoots(myWatchedRequests);
                    myLastHandledRESOLVEPathSourcesRoots.clear();
                    myLastHandledExclusions.clear();
                    ApplicationManager.getApplication().invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            if (!myModule.isDisposed() && ResolveSdkType.ResolveSdkService
                                    .getInstance(project).isResolveModule(myModule)) {
                                removeLibraryIfNeeded();
                            }
                        }
                    });
                }
            }
        }
    }

    @NotNull
    private static Collection<VirtualFile> gatherIncludeRoots(Collection<VirtualFile> goPathSourcesRoots,
                                                              Set<VirtualFile> excludeRoots) {
        final Collection<VirtualFile> includeRoots = ContainerUtil.newHashSet();
        for (VirtualFile goPathSourcesDirectory : goPathSourcesRoots) {
            ProgressIndicatorProvider.checkCanceled();
            boolean excludedRootIsAncestor = false;
            for (VirtualFile excludeRoot : excludeRoots) {
                ProgressIndicatorProvider.checkCanceled();
                if (VfsUtilCore.isAncestor(excludeRoot,
                        goPathSourcesDirectory, false)) {
                    excludedRootIsAncestor = true;
                    break;
                }
            }
            if (excludedRootIsAncestor) {
                continue;
            }
            for (VirtualFile file : goPathSourcesDirectory.getChildren()) {
                ProgressIndicatorProvider.checkCanceled();
                if (file.isDirectory() && !excludeRoots.contains(file)) {
                    includeRoots.add(file);
                }
            }
        }
        return includeRoots;
    }

}
