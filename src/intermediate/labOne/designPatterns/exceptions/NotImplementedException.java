package intermediate.labOne.designPatterns.exceptions;

public class NotImplementedException extends Exception {
    public NotImplementedException() {
       super();
    }

    public NotImplementedException(String message) {
        super(message);
    }

    public NotImplementedException(String message, Throwable cause) {
        super(message, cause);
    }
}
