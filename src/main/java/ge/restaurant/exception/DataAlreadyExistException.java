package ge.restaurant.exception;

public class DataAlreadyExistException extends Exception{
    public DataAlreadyExistException(String message) {
        super(message);
    }

    public DataAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}

