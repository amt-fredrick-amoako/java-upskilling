package intermediate.labTwo.designPatterns.creational.abstractFactory;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in Windows style.");
    }
}
