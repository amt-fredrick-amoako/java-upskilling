package intermediate.labOne.generics.animals;

import java.util.List;

public class Program {
    public static void main(String... args) {
        var dogs = List.of(new Dog("Black", 4));

        Cat[] cats = new Cat[]{new Cat("Flower", 4)};

        speakWithAnimals(dogs);

        speakWithAnimals(cats);
    }


/*
    cannot pass objects of subclasses
    static void speakWithAnimals(List<Animal> animals) {
        for(var animal : animals) {
            animal.speak();
        }
    }
*/
     static void speakWithAnimals(List<? extends Animal> animals) {
        for(var animal : animals) {
            animal.speak();
        }
    }

    static <T extends Animal> void speakWithAnimals(Animal[] animals) {// can cause a runtime error
        for(var animal : animals) {
            animal.speak();
        }
    }
}
