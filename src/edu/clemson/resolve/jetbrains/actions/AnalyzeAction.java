package edu.clemson.resolve.jetbrains.actions;

import com.intellij.codeInsight.hint.HintManager;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.event.*;
import com.intellij.openapi.editor.markup.*;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.JBColor;
import edu.clemson.resolve.RESOLVECompiler;
import edu.clemson.resolve.compiler.*;
import edu.clemson.resolve.jetbrains.RESOLVEIcons;
import edu.clemson.resolve.jetbrains.RESOLVEPluginController;
import edu.clemson.resolve.misc.Utils;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.tool.ErrorSeverity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.stringtemplate.v4.ST;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.List;

public class AnalyzeAction extends RESOLVEAction {

    public static final Logger LOG = Logger.getInstance("RESOLVEAnalyzeAction");
    public static final Key<Issue> ISSUE_ANNOTATION = Key.create("ISSUE_ANNOTATION");

    @Override
    public void update(AnActionEvent e) {
        e.getPresentation().setIcon(RESOLVEIcons.CHECKMARK);
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
        argMap.put("", resolveFile.getCanonicalPath());
        argMap.put("-lib", getContentRoot(project, resolveFile).getPath());
        CompilerIssueListener issueListener = new CompilerIssueListener();

        RESOLVECompiler compiler = setupAndRunCompiler(project, editor, resolveFile, argMap, issueListener);
        if (compiler.commandLineTarget.hasParseErrors) return;

        annotateIssues(editor, resolveFile, compiler, issueListener);
    }

    @Nullable
    public static RESOLVECompiler setupAndRunCompiler(@NotNull Project project,
                                                      @NotNull Editor editor,
                                                      @NotNull VirtualFile targetFile,
                                                      @NotNull Map<String, String> args) {
        return setupAndRunCompiler(project, editor, targetFile, args, null);
    }

    @NotNull
    public static RESOLVECompiler setupAndRunCompiler(@NotNull Project project,
                                                      @NotNull Editor editor,
                                                      @NotNull VirtualFile targetFile,
                                                      @NotNull Map<String, String> args,
                                                      @Nullable RESOLVECompilerListener customListener) {
        RESOLVECompiler compiler = getDefaultCompiler(args);
        ConsoleView console = RESOLVEPluginController.getInstance(project).getConsole();
        console.clear();
        String timeStamp = getTimeStamp();
        console.print(timeStamp + ": resolve " + Utils.join(getArgMapAsList(args), " ") + "\n",
                ConsoleViewContentType.SYSTEM_OUTPUT);

        RunRESOLVEListener defaultListener = new RunRESOLVEListener(compiler, console);
        compiler.removeListeners();
        compiler.addListeners(defaultListener);
        if (customListener != null) compiler.addListener(customListener);
        try {
            ProgressManager.getInstance().run(new Task.WithResult<Boolean, Exception>(
                    project, "Analyzing Current Source", false) {
                @Override
                protected Boolean compute(@NotNull ProgressIndicator indicator) throws Exception {
                    compiler.processCommandLineTarget();
                    return compiler.errMgr.getErrorCount() == 0;
                }
            });
        }
        catch (Throwable e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String msg = sw.toString();
            Notification notification =
                    new Notification("AnalyzeAction", "failed to execute " + targetFile.getPath(),
                            e.toString(),
                            NotificationType.INFORMATION);
            Notifications.Bus.notify(notification, project);
            console.print(timeStamp + ": resolve " + msg + "\n", ConsoleViewContentType.SYSTEM_OUTPUT);
            defaultListener.hasOutput = true; // show console below
        }
        if (defaultListener.hasOutput) {
            RESOLVEPluginController.showConsoleWindow(project);
        }
        return compiler;
    }

    public static void annotateIssues(Editor editor,
                                      VirtualFile targetFile,
                                      RESOLVECompiler compiler,
                                      CompilerIssueListener issueListener) {
        editor.getMarkupModel().removeAllHighlighters();    //first

        EditorMouseMotionListener mouseListener = new EditorMouseMotionListener() {
            @Override
            public void mouseMoved(EditorMouseEvent e) {
                int offset = MyActionUtils.getMouseOffset(e.getMouseEvent(), editor);
                if (offset >= editor.getDocument().getTextLength()) return;
                List<RangeHighlighter> issueHighlightersAtOffset =
                        MyActionUtils.getRangeHighlightersAtOffset(editor, HighlighterLayer.ERROR, offset);
                if (issueHighlightersAtOffset.size() == 0) return;
                List<String> msgs = new ArrayList<String>();

                for (RangeHighlighter highlighter : issueHighlightersAtOffset) {
                    Issue errorUnderCursor = highlighter.getUserData(ISSUE_ANNOTATION);
                    if (errorUnderCursor == null || errorUnderCursor.msg == null) continue;
                    String errorMsg = getIssueDisplayString(compiler, errorUnderCursor);
                    if (errorMsg != null) msgs.add(errorMsg);
                }
                String combinedErrorMsg = Utils.join(msgs, "\n");
                showErrorToolTip(editor, offset, HintManager.getInstance(), combinedErrorMsg, e);
            }
            @Override
            public void mouseDragged(EditorMouseEvent e) {
            }
        };
        List<RangeHighlighter> issueRelatedHighlighters = new ArrayList<>();
        for (Issue issue : issueListener.issues) {
            annotateIssueInEditor(targetFile, issueRelatedHighlighters, editor, issue);
        }

        editor.addEditorMouseMotionListener(mouseListener);
        editor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void beforeDocumentChange(DocumentEvent event) {
            }

            @Override
            public void documentChanged(DocumentEvent event) {
                //remove all current issue related highlighters
                MarkupModel markupModel = editor.getMarkupModel();
                for (RangeHighlighter h : issueRelatedHighlighters) {
                    int eventOffset = event.getOffset();
                    int highlightersOffset = h.getStartOffset();
                    if (eventOffset >= h.getStartOffset() && eventOffset < h.getEndOffset()) {
                        h.getTextAttributes().setEffectColor(JBColor.ORANGE);
                       // editor.getMarkupModel().removeHighlighter(h);
                    }
                }
            }
        });

    }

    public static String getIssueDisplayString(RESOLVECompiler compiler, Issue e) {
        ST st = compiler.errMgr.getMessageTemplate(e.msg);
        return st.render();
    }

    public static void showErrorToolTip(Editor editor,
                                        int offset, HintManager hintMgr,
                                        String msg,
                                        EditorMouseEvent event) {
        int flags = HintManager.HIDE_BY_ANY_KEY | HintManager.HIDE_BY_TEXT_CHANGE | HintManager.HIDE_BY_SCROLLING;
        int timeout = 0; // default?
        hintMgr.showErrorHint(editor, msg, offset, offset + 1, HintManager.ABOVE, flags, timeout);
    }

    public static void annotateIssueInEditor(@NotNull VirtualFile file,
                                             @NotNull List<RangeHighlighter> highlighters,
                                             @NotNull Editor editor,
                                             @NotNull Issue issue) {
        MarkupModel markupModel = editor.getMarkupModel();  //ref to the current editor's markup model...
        final TextAttributes attr = new TextAttributes();

        Token offendingToken = (Token) issue.msg.offendingToken;
        int a = offendingToken.getStartIndex();
        int b = offendingToken.getStopIndex() + 1;

        if (issue.msg instanceof LanguageSemanticsMessage) {
            if (issue.msg.getErrorType().severity == ErrorSeverity.ERROR) {
                attr.setForegroundColor(JBColor.RED);
                attr.setEffectColor(JBColor.RED);
                attr.setEffectType(EffectType.WAVE_UNDERSCORE);
            }
            else {  //warning (should be yellowish or something)
                attr.setBackgroundColor(new JBColor(new Color(246, 235, 188),
                        new Color(246, 235, 188)));
                attr.setEffectType(EffectType.BOXED);
            }
        }
        String sourceName = offendingToken.getTokenSource().getSourceName();
        String vFilePath = file.getPath();
        if (vFilePath.equals(sourceName)) { //only want highlights in the doc the user is looking at.
            RangeHighlighter highlighter = markupModel.addRangeHighlighter(a,
                    b,
                    HighlighterLayer.ERROR, // layer
                    attr,
                    HighlighterTargetArea.EXACT_RANGE);
            highlighters.add(highlighter);
            highlighter.putUserData(ISSUE_ANNOTATION, issue);
        }
    }

    public static class Issue {
        String annotation;
        RESOLVEMessage msg;
        public Issue(RESOLVEMessage msg) { this.msg = msg; }
    }

}
