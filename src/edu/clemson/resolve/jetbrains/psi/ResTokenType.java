package edu.clemson.resolve.jetbrains.psi;

import com.intellij.psi.tree.IElementType;
import edu.clemson.resolve.jetbrains.RESOLVELanguage;
import org.jetbrains.annotations.NotNull;

public class ResTokenType extends IElementType {

    public ResTokenType(@NotNull String debugName) {
        super(debugName, RESOLVELanguage.INSTANCE);
    }
}
