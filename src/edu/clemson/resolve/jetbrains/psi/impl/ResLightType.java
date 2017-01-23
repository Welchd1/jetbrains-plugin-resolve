package edu.clemson.resolve.jetbrains.psi.impl;

import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.impl.light.LightElement;
import com.intellij.psi.stubs.IStubElementType;
import edu.clemson.resolve.jetbrains.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Adapted from go plugin, this is primarily used on functions so we can obtain type and parameter mode info about the
 * params we're currently filling in (for a call, facility, etc).
 * @param <E>
 */
public abstract class ResLightType<E extends ResCompositeElement> extends LightElement implements ResType {

    @NotNull
    protected final E myElement;

    protected ResLightType(@NotNull E e) {
        super(e.getManager(), e.getLanguage());
        myElement = e;
        setNavigationElement(e);
    }

    @Nullable
    @Override
    public ResTypeReferenceExp getTypeReferenceExp() {
        return null;
    }

    @NotNull
    @Override
    public ResType getUnderlyingType() {
        return ResPsiImplUtil.getUnderlyingType(this);
    }

    @Override
    public boolean shouldGoDeeper() {
        return false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + myElement + "}";
    }

    public static class LightFunctionType extends ResLightType<ResOperationLikeNode> {
        public LightFunctionType(@NotNull ResOperationLikeNode o) {
            super(o);
        }

        @Nullable
        public ResOperationLikeNode getOperationLikeNode() {
            return myElement;
        }

        @Override
        public String getText() {
            return myElement.getText();
        }

        @Nullable
        @Override
        public ResMathExp getResMathMetaTypeExp(ResolveState context) {
            return null;
        }
    }
}
