package edu.clemson.resolve;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.LayeredIcon;
import com.intellij.util.PlatformIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public interface ResolveIcons {

    public static final Icon DIRECTORY = PlatformIcons.FOLDER_ICON;

    public static final Icon MODULE = IconLoader.getIcon("/edu/clemson/resolve/icons/module.png");
    public static final Icon TOOL_ICON = IconLoader.getIcon("/edu/clemson/resolve/icons/tool_icon.png");

    public static final Icon VC = IconLoader.getIcon("/edu/clemson/resolve/icons/vc.png");
    public static final Icon VC_PANEL = IconLoader.getIcon("/edu/clemson/resolve/icons/vc@2x.png");

    public static final Icon FILE = IconLoader.getIcon("/edu/clemson/resolve/icons/file.png");
    public static final Icon PROGRAM_RUN = Helper.createIconWithShift(TOOL_ICON, AllIcons.Nodes.RunnableMark);

    public static final Icon FACILITY = IconLoader.getIcon("/edu/clemson/resolve/icons/facility.png");

    public static final Icon CONCEPT = IconLoader.getIcon("/edu/clemson/resolve/icons/concept.png");
    public static final Icon IMPL = IconLoader.getIcon("/edu/clemson/resolve/icons/implementation.png");
    public static final Icon CONCEPT_EXT = IconLoader.getIcon("/edu/clemson/resolve/icons/concept_extension.png");

    public static final Icon PRECIS = IconLoader.getIcon("/edu/clemson/resolve/icons/precis.png");
    public static final Icon PRECIS_EXT = IconLoader.getIcon("/edu/clemson/resolve/icons/precis_extension.png");

    public static final Icon DEF = IconLoader.getIcon("/edu/clemson/resolve/icons/def.png");
    public static final Icon TYPE_MODEL = IconLoader.getIcon("/edu/clemson/resolve/icons/type_model.png");
    public static final Icon TYPE_REPR = IconLoader.getIcon("/edu/clemson/resolve/icons/type_repr.png");
    public static final Icon GENERIC_TYPE = IconLoader.getIcon("/edu/clemson/resolve/icons/generic_type.png");
    public static final Icon PARAMETER = IconLoader.getIcon("/edu/clemson/resolve/icons/parameter_alt.png");
    public static final Icon VARIABLE = IconLoader.getIcon("/edu/clemson/resolve/icons/variable.png");

    public static final Icon RECORD_FIELD = IconLoader.getIcon("/edu/clemson/resolve/icons/record_field.png");
    public static final Icon EXEMPLAR = IconLoader.getIcon("/edu/clemson/resolve/icons/exemplar.png");

    public static final Icon FUNCTION_DECL = IconLoader.getIcon("/edu/clemson/resolve/icons/function.png");
    public static final Icon FUNCTION_IMPL = IconLoader.getIcon("/edu/clemson/resolve/icons/function_impl.png");

    public static final Icon PROVED = IconLoader.getIcon("/edu/clemson/resolve/icons/proved.png");
    public static final Icon NOT_PROVED = IconLoader.getIcon("/edu/clemson/resolve/icons/not_proved.png");
    public static final Icon CHECKMARK = IconLoader.getIcon("/edu/clemson/resolve/icons/proved_alt.png");

    public static final Icon TIMED_OUT = IconLoader.getIcon("/edu/clemson/resolve/icons/timeout.png");  //TODO: Make this exlamation point (with triangle, etc)

    public static final Icon SYMBOL_ICON = IconLoader.getIcon("/edu/clemson/resolve/icons/symbols_icon.png");

    /**
     * Places a small icon (mark) in the lower right hand corner of the {@code base} icon.
     * Used from go lang plugin.
     */
    class Helper {
        private Helper() {}

        @NotNull
        public static LayeredIcon createIconWithShift(@NotNull final Icon base, Icon mark) {
            LayeredIcon icon = new LayeredIcon(2) {
                @Override
                public int getIconHeight() {
                    return base.getIconHeight();
                }
            };
            icon.setIcon(base, 0);
            icon.setIcon(mark, 1, 0, base.getIconWidth() / 2);
            return icon;
        }
    }
}
