package pl.dmcs.exercises.exception;
import java.util.List;

public class NegativeNumberNotAllowedException extends RuntimeException {

    public NegativeNumberNotAllowedException() {
    }

    public NegativeNumberNotAllowedException(String message, List<Integer> negativeNumbers) {
        super(message + negativeNumbers.toString());
    }

}
