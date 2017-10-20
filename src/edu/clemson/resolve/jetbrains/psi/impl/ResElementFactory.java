package edu.clemson.resolve.jetbrains.psi.impl;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.containers.ContainerUtil;
import edu.clemson.resolve.jetbrains.RESOLVELanguage;
import edu.clemson.resolve.jetbrains.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("ConstantConditions")
public class ResElementFactory {

    private ResElementFactory() {
    }

    @NotNull
    private static ResFile createFileFromText(@NotNull Project project, @NotNull String text) {
        return (ResFile) PsiFileFactory.getInstance(project)
                .createFileFromText("a.resolve", RESOLVELanguage.INSTANCE, text);
    }

    @NotNull
    public static PsiElement createIdentifierFromText(@NotNull Project project, String text) {
        ResFile file = createFileFromText(project, "Precis " + text + ";end " + text + ";");
        return file.getEnclosedModule().getIdentifier();
    }

    //TODO: I don't want this to be navigatble.. Figure out how to accomplish this. (or at least make the module
    //navigatable, but obfuscate the body)
   /* @NotNull
    public static ResFile getHardCodedMathFile(@NotNull Project project) {
        final String hardcoded =
                "Precis Builtin_Class_Theory;\n " +
                    "Definition Cls : 𝒫(ℳℰ)\n" +
                "end Builtin_Class_Theory;";
        return createFileFromText(project, hardcoded);
    }*/
}
