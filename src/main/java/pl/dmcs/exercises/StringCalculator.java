package pl.dmcs.exercises;

import pl.dmcs.exercises.exception.InvalidStringException;
import pl.dmcs.exercises.exception.NegativeNumberNotAllowedException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private final int DELIMITER_POSITION = 2;
    private final int NUMBERS_SEQUENCE_START_POSITION = 4;
    private final String DEFAULT_DELIMITER = ",";

    int add(String str) {
        int sum = 0;
        if (str == null || str.equals("")) {
            return sum;
        }
        String separator = getSeparator(str);
        String [] elements = transformStringIntoElements(str, separator);
        return getSum(elements);
    }

    private int getSum(String [] elements) {
        int sum = 0;
        boolean hasNegativeNumbers = false;
        List<Integer> negativeNumbers = new ArrayList<Integer>();
        for(String element: elements) {
            int number = getNumberFromString(element);
            if (number >= 0 && !hasNegativeNumbers) {
                sum += number;
            } else if (number < 0) {
                hasNegativeNumbers = true;
                negativeNumbers.add(number);
            }
        }
        if (hasNegativeNumbers) {
            throw new NegativeNumberNotAllowedException("Negatives not allowed ", negativeNumbers);
        }
        return sum;
    }

    private int getNumberFromString(String str) {
        try {
            return Integer.parseInt(str.trim());
        }
        catch (NumberFormatException e)
        {
            throw new InvalidStringException("Number was not provided");
        }
    }

    private String [] transformStringIntoElements(String str, String separator) {
        if (str == null || separator == null) {
            return new String[0];
        }
        if (isStringBeginningMatching(str)) {
            str = str.substring(NUMBERS_SEQUENCE_START_POSITION);
        }
        return str.split(separator + "|" + "\n");
    }

    private String getSeparator(String str) {
        if (isStringBeginningMatching(str)) {
            return str.substring(DELIMITER_POSITION, DELIMITER_POSITION + 1);
        }
        return DEFAULT_DELIMITER;
    }

    private boolean isStringBeginningMatching(String str) {
        Pattern p = Pattern.compile("^(//[^0-9]\n)");
        Matcher matcher = p.matcher(str);
        return matcher.find();
    }
}
