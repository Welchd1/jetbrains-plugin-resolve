package edu.clemson.resolve;

import com.intellij.notification.NotificationGroup;
import org.jetbrains.annotations.NonNls;

public class ResolveConstants {

    public static final String RESOLVE_PATH = "RESOLVEPATH";
    public static final String RESOLVE_ROOT = "RESOLVEROOT";

    public static final String COMPILER_DIR_NAME = "resolve-lite-private";

    public static final String MODULE_TYPE_ID = "RESOLVE_MODULE";
    public static final String SDK_TYPE_ID = "RESOLVE SDK";

    public static final NotificationGroup RESOLVE_NOTIFICATION_GROUP = NotificationGroup.balloonGroup("RESOLVE plugin notifications");
    public static final String RESOLVE_LIBRARIES_SERVICE_NAME = "RESOLVELibraries";
    public static final String RESOLVE_LIBRARIES_CONFIG_FILE = "resolveLibraries.xml";
    @NonNls
    public static final String RESOLVE = "RESOLVE";

    private ResolveConstants() {
    }
}
