package edu.clemson.resolve.plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.Iconable;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.impl.ElementBase;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.ui.RowIcon;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.PlatformIcons;
import edu.clemson.resolve.plugin.RESOLVEIcons;
import edu.clemson.resolve.plugin.psi.ResCompositeElement;
import edu.clemson.resolve.plugin.psi.ResConceptModule;
import edu.clemson.resolve.plugin.psi.ResFacilityModule;
import edu.clemson.resolve.plugin.psi.ResNamedElement;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public abstract class ResNamedElementImpl
        extends
            ResCompositeElementImpl implements ResCompositeElement, ResNamedElement {

    public ResNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Nullable @Override public PsiElement getNameIdentifier() {
        return getIdentifier();
    }

    public boolean isPublic() {
        return true;
    }

    @Nullable @Override public String getName() {
        PsiElement identifier = getIdentifier();
        return identifier != null ? identifier.getText() : null;
    }

    @NotNull @Override public PsiElement setName(
            @NonNls @NotNull String newName) throws IncorrectOperationException {
        PsiElement identifier = getIdentifier();
        if (identifier != null) {
            identifier.replace(ResElementFactory
                    .createIdentifierFromText(getProject(), newName));
        }
        return this;
    }

    @Override public int getTextOffset() {
        PsiElement identifier = getIdentifier();
        return identifier != null ? identifier.getTextOffset()
                : super.getTextOffset();
    }

    @Override public boolean processDeclarations(
            @NotNull PsiScopeProcessor processor,
            @NotNull ResolveState state,
            PsiElement lastParent,
            @NotNull PsiElement place) {
        return ResCompositeElementImpl.processDeclarationsDefault(
                this, processor, state, lastParent, place);
    }

    @Nullable @Override public Icon getIcon(int flags) {
        Icon icon = null;
        if (this instanceof ResFacilityModule) icon = RESOLVEIcons.FACILITY;
        else if (this instanceof ResConceptModule) icon = RESOLVEIcons.CONCEPT;
        if (icon != null) {
            if ((flags & Iconable.ICON_FLAG_VISIBILITY) != 0) {
                RowIcon rowIcon =
                        ElementBase.createLayeredIcon(this, icon, flags);
                rowIcon.setIcon(isPublic() ? PlatformIcons.PUBLIC_ICON :
                        PlatformIcons.PRIVATE_ICON, 1);
                return rowIcon;
            }
            return icon;
        }
        return super.getIcon(flags);
    }
}
