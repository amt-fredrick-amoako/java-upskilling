package intermediate.labTwo.designPatterns.creational.abstractFactory;

public class Program {
    private Button button;
    private Checkbox checkbox;

    public Program(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }

    public static void main(String[] args) {
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("windows")) {
            factory = new WindowsFactory();
        } else if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            throw new RuntimeException("Unsupported operating system: " + osName);
        }

        Program app = new Program(factory);
        app.paint();
    }
}
