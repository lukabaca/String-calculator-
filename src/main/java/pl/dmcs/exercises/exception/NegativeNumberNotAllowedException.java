package pl.dmcs.exercises.exception;

public class NegativeNumberNotAllowedException extends Exception {
    public NegativeNumberNotAllowedException() {
    }

    public NegativeNumberNotAllowedException(String message) {
        super(message);
    }
}
