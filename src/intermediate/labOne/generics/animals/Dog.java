package intermediate.labOne.generics.animals;

public class Dog extends Animal {

    public Dog(String name, int numberOfLegs) {
        super(name, numberOfLegs);
    }

    @Override
    public void speak() {
        System.out.println("Animal is a" + getClass().getName());
        System.out.println(getName() + " speaks meow");
        System.out.println(getName() + "has " + getNumberOfLegs() + " legs");
    }
}
