package intermediate.labOne.generics.validation;

public class Program {
    public static void main(String[] args) {
        var isEven = Validator.validate(150, num -> num % 2 == 0, System.out::println);
        var isNotEmpty = Validator.validate("", name -> !name.isEmpty(), System.out::println);
        System.out.println("isNotEmpty = " + isNotEmpty);
        System.out.println("isEven = " + isEven);
    }
}
