package stepic.pattern;

class Application {
    private final Executor executor;
    private final Editor editor;

    public Application(Executor executor, Editor editor) {
        this.executor = executor;
        this.editor = editor;
    }

    void run() {
        executor.executeCommand(editor::selectAll);
        executor.executeCommand(() -> editor.saveToClipboard(editor.getSelection()));
        executor.executeCommand(() -> editor.replaceSelection(editor.getSelection()));
    }
}

