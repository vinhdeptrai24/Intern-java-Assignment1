package A3.exception;

public class DuplicateProductException extends RuntimeException {
    public DuplicateProductException(String message){
        super(message);
    }
}
