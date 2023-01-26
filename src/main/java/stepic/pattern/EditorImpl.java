package stepic.pattern;

public class EditorImpl implements Editor {
    @Override
    public void selectAll() {
        System.out.println("Select all");
    }

    @Override
    public String getSelection() {
        return "getSelection";
    }

    @Override
    public void replaceSelection(String value) {
        System.out.println("Replace selection " + value);
    }

    @Override
    public String getClipboard() {
        return "getClipboard";
    }

    @Override
    public void saveToClipboard(String value) {
        System.out.println("Saving " + value);
    }
}
