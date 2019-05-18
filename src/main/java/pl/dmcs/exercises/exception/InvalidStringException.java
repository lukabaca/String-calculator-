package pl.dmcs.exercises.exception;

public class InvalidStringException extends RuntimeException {
    public InvalidStringException() {
    }

    public InvalidStringException(String message) {
        super(message);
    }
}
