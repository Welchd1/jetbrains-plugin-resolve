package edu.clemson.resolve;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.LayeredIcon;
import com.intellij.util.PlatformIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public interface ResolveIcons {

    Icon DIRECTORY = PlatformIcons.FOLDER_ICON;

    Icon MODULE = IconLoader.getIcon("/edu/clemson/resolve/icons/module.png");
    Icon TOOL_ICON = IconLoader.getIcon("/edu/clemson/resolve/icons/tool_icon.png");

    Icon VC = IconLoader.getIcon("/edu/clemson/resolve/icons/vc.png");
    Icon VC_PANEL = IconLoader.getIcon("/edu/clemson/resolve/icons/vc@2x.png");

    Icon FILE = IconLoader.getIcon("/edu/clemson/resolve/icons/file.png");
    Icon PROGRAM_RUN = Helper.createIconWithShift(TOOL_ICON, AllIcons.Nodes.RunnableMark);

    Icon FACILITY = IconLoader.getIcon("/edu/clemson/resolve/icons/facility.png");

    Icon CONCEPT = IconLoader.getIcon("/edu/clemson/resolve/icons/concept.png");
    Icon IMPL = IconLoader.getIcon("/edu/clemson/resolve/icons/implementation.png");
    Icon CONCEPT_EXT = IconLoader.getIcon("/edu/clemson/resolve/icons/concept_extension.png");

    Icon PRECIS = IconLoader.getIcon("/edu/clemson/resolve/icons/precis.png");
    Icon PRECIS_EXT = IconLoader.getIcon("/edu/clemson/resolve/icons/precis_extension.png");

    Icon DEF = IconLoader.getIcon("/edu/clemson/resolve/icons/def.png");
    Icon TYPE_MODEL = IconLoader.getIcon("/edu/clemson/resolve/icons/type_model.png");
    Icon TYPE_REPR = IconLoader.getIcon("/edu/clemson/resolve/icons/type_repr.png");
    Icon GENERIC_TYPE = IconLoader.getIcon("/edu/clemson/resolve/icons/generic_type.png");
    Icon PARAMETER = IconLoader.getIcon("/edu/clemson/resolve/icons/parameter_alt.png");
    Icon VARIABLE = IconLoader.getIcon("/edu/clemson/resolve/icons/variable.png");

    Icon RECORD_FIELD = IconLoader.getIcon("/edu/clemson/resolve/icons/record_field.png");
    Icon EXEMPLAR = IconLoader.getIcon("/edu/clemson/resolve/icons/exemplar.png");

    Icon FUNCTION_DECL = IconLoader.getIcon("/edu/clemson/resolve/icons/function.png");
    Icon FUNCTION_IMPL = IconLoader.getIcon("/edu/clemson/resolve/icons/function_impl.png");

    Icon PROVED = IconLoader.getIcon("/edu/clemson/resolve/icons/proved.png");
    Icon NOT_PROVED = IconLoader.getIcon("/edu/clemson/resolve/icons/not_proved.png");
    Icon CHECKMARK = IconLoader.getIcon("/edu/clemson/resolve/icons/proved_alt.png");

    Icon TIMED_OUT = IconLoader.getIcon("/edu/clemson/resolve/icons/timeout.png");  //TODO: Make this exlamation point (with triangle, etc)

    Icon SYMBOL_ICON = IconLoader.getIcon("/edu/clemson/resolve/icons/symbols_icon.png");

    /**
     * Places a small icon (mark) in the lower right hand corner of the
     * {@code base} icon. Used from go lang plugin.
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
