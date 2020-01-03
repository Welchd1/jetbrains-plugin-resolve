package edu.clemson.resolve.sdk;

import com.intellij.openapi.roots.libraries.DummyLibraryProperties;
import com.intellij.openapi.roots.libraries.LibraryKind;
import com.intellij.openapi.roots.libraries.LibraryPresentationProvider;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ResolveSdkPresentationProvider
        extends
        LibraryPresentationProvider<DummyLibraryProperties> {

    private static final LibraryKind KIND = LibraryKind.create("resolve");

    public ResolveSdkPresentationProvider() {
        super(KIND);
    }

    @Override
    @Nullable
    public DummyLibraryProperties detect(
            @NotNull List<VirtualFile> classesRoots) {
        for (VirtualFile root : classesRoots) {
            if (ResolveSdkType.ResolveSdkService.isResolveSdkLibRoot(root)) {
                return DummyLibraryProperties.INSTANCE;
            }
        }
        return null;
    }
}
