package intermediate.labTwo.designPatterns.creational.abstractFactory;

public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in Windows style.");
    }
}
