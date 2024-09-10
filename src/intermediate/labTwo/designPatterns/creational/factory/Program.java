package intermediate.labTwo.designPatterns.creational.factory;

public class Program {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        // get an object of Square and call its draw method.
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
    }
}
