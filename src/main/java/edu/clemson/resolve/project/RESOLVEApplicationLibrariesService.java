package edu.clemson.resolve.project;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import edu.clemson.resolve.ResolveConstants;
import edu.clemson.resolve.sdk.ResolveSdkUtil;
import org.jetbrains.annotations.NotNull;


/* ORIGINAL:
@State(
        name = RESOLVEConstants.RESOLVE_LIBRARIES_SERVICE_NAME,
        storages = @Storage(file = StoragePathMacros.APP_CONFIG + "/" +
                RESOLVEConstants.RESOLVE_LIBRARIES_CONFIG_FILE)
)*/

@State(
        name = ResolveConstants.RESOLVE_LIBRARIES_SERVICE_NAME,
        storages = @Storage(ResolveConstants.RESOLVE_LIBRARIES_CONFIG_FILE)
)
public class RESOLVEApplicationLibrariesService extends
        ResolveLibrariesService<RESOLVEApplicationLibrariesService
                .RESOLVEApplicationLibrariesState> {

    @NotNull
    @Override
    protected RESOLVEApplicationLibrariesState createState() {
        return new RESOLVEApplicationLibrariesState();
    }

    public static RESOLVEApplicationLibrariesService getInstance() {
        return ServiceManager.getService(RESOLVEApplicationLibrariesService.class);
    }

    public boolean isUsingRESOLVEPathFromSystemEnvironment() {
        return state.isUsingRESOLVEPathFromSystemEnvironment();
    }

    public void setUsingRESOLVEPathFromSystemEnvironment(boolean useRESPATHfromEnv) {
        if (state.isUsingRESOLVEPathFromSystemEnvironment() != useRESPATHfromEnv) {
            state.setUsingRESOLVEPathFromSystemEnvironment(useRESPATHfromEnv);
            if (!ResolveSdkUtil.getRESOLVEPathsRootsFromEnvironment().isEmpty()) {
                incModificationCount();
                ApplicationManager.getApplication()
                        .getMessageBus()
                        .syncPublisher(LIBRARIES_TOPIC)
                        .librariesChanged(getLibraryRootUrls());
            }
        }
    }

    static class RESOLVEApplicationLibrariesState
            extends ResolveLibrariesState {
        private boolean useRESOLVEPathFromSystemEnvironment = true;

        boolean isUsingRESOLVEPathFromSystemEnvironment() {
            return useRESOLVEPathFromSystemEnvironment;
        }

        void setUsingRESOLVEPathFromSystemEnvironment(
                boolean useResPathFromSysEnv) {
            useRESOLVEPathFromSystemEnvironment = useResPathFromSysEnv;
        }
    }
}
