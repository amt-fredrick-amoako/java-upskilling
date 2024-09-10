package intermediate.labTwo.designPatterns.creational.abstractFactory;

public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in MacOS style.");
    }
}
