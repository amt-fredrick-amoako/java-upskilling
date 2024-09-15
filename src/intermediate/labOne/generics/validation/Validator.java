package intermediate.labOne.generics.validation;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Validator {
    /*
    validate data based on predicate and communicate errors via consumer interface
    * */
    public static <T> boolean validate(T data, Predicate<T> predicate, Consumer<String> onError) {
        if(!predicate.test(data)) {
            onError.accept("Validation failed due to wrong or malformed data");
        }
        return true;
    }
}
