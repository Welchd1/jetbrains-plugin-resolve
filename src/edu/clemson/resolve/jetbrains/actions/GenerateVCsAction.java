package edu.clemson.resolve.jetbrains.actions;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.editor.markup.GutterIconRenderer;
import com.intellij.openapi.editor.markup.HighlighterLayer;
import com.intellij.openapi.editor.markup.MarkupModel;
import com.intellij.openapi.editor.markup.RangeHighlighter;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import edu.clemson.resolve.RESOLVECompiler;
import edu.clemson.resolve.jetbrains.RESOLVEIcons;
import edu.clemson.resolve.jetbrains.RESOLVEPluginController;
import edu.clemson.resolve.jetbrains.verifier.ConditionCollapsiblePanel;
import edu.clemson.resolve.jetbrains.verifier.VerificationConditionSelectorPanel;
import edu.clemson.resolve.jetbrains.verifier.VerifierPanel;
import edu.clemson.resolve.vcgen.VC;
import edu.clemson.resolve.vcgen.VCOutputFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.*;

public class GenerateVCsAction extends RESOLVEAction implements AnAction.TransparentUpdate {

    private static final Logger LOGGER = Logger.getInstance("RESOLVEGenerateVCsAction");
    private final List<RangeHighlighter> highlighters = new ArrayList<>();

    @Override
    public void update(AnActionEvent e) {
        e.getPresentation().setIcon(RESOLVEIcons.VC);
    }

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        VirtualFile resolveFile = getRESOLVEFileFromEvent(event);
        if (project == null || resolveFile == null) return;

        commitDoc(project, resolveFile);
        Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
        if (editor == null) return;

        Map<String, String> argMap = new LinkedHashMap<>();
        argMap.put("", resolveFile.getName());
        argMap.put("-lib", getContentRoot(project, resolveFile).getPath());
        argMap.put("-vcs", "");

        CompilerIssueListener issueListener = new CompilerIssueListener();

        RESOLVECompiler compiler = AnalyzeAction.setupAndRunCompiler(project, editor, resolveFile, argMap, issueListener);
        if (compiler.commandLineTarget.hasParseErrors) return;
        AnalyzeAction.annotateIssues(editor, resolveFile, compiler, issueListener);

        VCOutputFile vco = compiler.commandLineTarget.getVCOutput();
        if (vco == null) return;

        RESOLVEPluginController controller = RESOLVEPluginController.getInstance(project);
        VerifierPanel verifierPanel = controller.getVerifierPanel();

        Collection<VC> vcs = vco.getFinalVCs();
        verifierPanel.createVerifierView(vcs);
        addVCGutterIcons(vco, editor, project);
        RESOLVEPluginController.showVerifierWindow(project);
    }

    private VCOutputFile generateVCs(VirtualFile resolveFile, Editor editor, Project project) {
        boolean forceGeneration = true; // from action, they really mean it
        RunRESOLVEOnLanguageFile gen =
                new RunRESOLVEOnLanguageFile(resolveFile,
                        project,
                        "gen vcs");
        //SMTestRunnerConnectionUtil
        Map<String, String> argMap = new LinkedHashMap<>();
        argMap.put("-lib", RunRESOLVEOnLanguageFile.getContentRoot(project, resolveFile).getPath());
        argMap.put("-vcs", "");
        gen.addArgs(argMap);
        boolean successful = false;
        try {
            successful = ProgressManager.getInstance().run(gen); //, "Generating", canBeCancelled, e.getData(PlatformDataKeys.PROJECT));
        } catch (Exception e1) {
        }
        if (successful && !editor.isDisposed()) {
            return gen.getVCOutput();
        }
        return null;
    }

    private static class VCNavigationAction extends AnAction {

        private final String vcNum;
        public boolean isProved = false;

        VCNavigationAction(String vcNum, String explanation) {
            super("VC #" + vcNum + " : " + explanation);
            Presentation template = this.getTemplatePresentation();
            template.setText("VC #" + vcNum + " : " + explanation, false);   //mneumonic set to false so my tooltips can have underscores.
            this.vcNum = vcNum;
        }

        @Override
        public void update(AnActionEvent e) {
        }

        @Override
        public void actionPerformed(AnActionEvent e) {
            if (e.getProject() == null) return;
            RESOLVEPluginController controller = RESOLVEPluginController.getInstance(e.getProject());
            controller.getVerifierWindow().show(null);  //open the verifier window
            VerificationConditionSelectorPanel vcselector = controller.getVerifierPanel().getVcSelectorPanel();
            if (vcselector == null) return;
            vcselector.vcTabs.get(Integer.parseInt(vcNum));
            VerifierPanel verifierPanel = controller.getVerifierPanel();
            if (verifierPanel.getVcSelectorPanel() == null) return;
            VerificationConditionSelectorPanel selector = verifierPanel.getVcSelectorPanel();
            ConditionCollapsiblePanel details = selector.vcTabs.get(Integer.parseInt(vcNum));
            details.setExpanded(true);

            //TODO: Make it scroll to the vc selected! This is a top priority usability improvement.
            //vcselector.scrollRectToVisible(details.get);
        }
    }

    private void addVCGutterIcons(VCOutputFile vco, Editor editor, Project project) {
        if (!editor.isDisposed()) {
            highlighters.clear();
            MarkupModel markup = editor.getMarkupModel();
            RESOLVEPluginController controller = RESOLVEPluginController.getInstance(project);
            markup.removeAllHighlighters();

            //A mapping from [line number] -> [vc_1, .., vc_j]
            Map<Integer, List<VC>> byLine = vco.getVCsGroupedByLineNumber();
            List<RangeHighlighter> vcRelatedHighlighters = new ArrayList<>();

            for (Map.Entry<Integer, List<VC>> vcsByLine : byLine.entrySet()) {
                List<AnAction> actionsPerVC = new ArrayList<>();
                //create clickable actions for each vc
                for (VC vc : vcsByLine.getValue()) {
                    actionsPerVC.add(new VCNavigationAction(vc.getNumber() + "", vc.getExplanation()));
                }

                RangeHighlighter highlighter =
                        markup.addLineHighlighter(vcsByLine.getKey() - 1, HighlighterLayer.ELEMENT_UNDER_CARET, null);
                highlighter.setGutterIconRenderer(new GutterIconRenderer() {
                    @NotNull
                    @Override
                    public Icon getIcon() {
                        return RESOLVEIcons.VC;
                    }

                    @Override
                    public boolean equals(Object obj) {
                        return false;
                    }

                    @Override
                    public int hashCode() {
                        return 0;
                    }

                    @Override
                    public boolean isNavigateAction() {
                        return true;
                    }

                    @Nullable
                    public ActionGroup getPopupMenuActions() {
                        DefaultActionGroup g = new DefaultActionGroup();
                        g.addAll(actionsPerVC);
                        return g;
                    }

                    @Nullable
                    public AnAction getClickAction() {
                        return null;
                    }

                });
                vcRelatedHighlighters.add(highlighter);
                highlighters.add(highlighter);
            }

            editor.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void beforeDocumentChange(DocumentEvent event) {
                }
                @Override
                public void documentChanged(DocumentEvent event) {
                    //remove vc-related highlighters
                    for (RangeHighlighter h : vcRelatedHighlighters) {
                        markup.removeHighlighter(h);
                    }
                    VerifierPanel verifierPanel = controller.getVerifierPanel();
                    //controller.getVerifierWindow().hide(null);
                    verifierPanel.revertToBaseGUI();
                }
            });
        }
    }

}
