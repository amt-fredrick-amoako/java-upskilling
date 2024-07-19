package intermediate.exceptions;

public class MenuException extends Exception{
    public MenuException(String message){
        super(message);
    }

    public MenuException(String message, Throwable cause){
        super(message, cause);
    }

    public MenuException(Throwable cause){
        super(cause);
    }
}
