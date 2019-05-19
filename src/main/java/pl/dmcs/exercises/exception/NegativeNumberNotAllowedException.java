package pl.dmcs.exercises.exception;

import java.util.ArrayList;
import java.util.List;

public class NegativeNumberNotAllowedException extends RuntimeException {
    private List<Integer> negatvieNumbers = new ArrayList<Integer>();

    public List<Integer> getNegatvieNumbers() {
        return negatvieNumbers;
    }

    public void setNegatvieNumbers(List<Integer> negatvieNumbers) {
        this.negatvieNumbers = negatvieNumbers;
    }

    public NegativeNumberNotAllowedException() {
    }

    public NegativeNumberNotAllowedException(String message, List<Integer> negativeNumbers) {
        super(message + negativeNumbers.toString());
    }

    @Override
    public String toString() {
        return "NegativeNumberNotAllowedException{" +
                "negatvieNumbers=" + negatvieNumbers +
                '}';
    }
}
