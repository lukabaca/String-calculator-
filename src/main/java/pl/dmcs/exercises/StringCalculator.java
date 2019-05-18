package pl.dmcs.exercises;

import pl.dmcs.exercises.exception.InvalidStringException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private final int DELIMITER_POSITION = 2;
    private final int NUMBERS_SEQUENCE_START_POSITION = 4;

    int add(String str) {
        int sum = 0;
        if (str == null || str.equals("")) {
            return sum;
        }
        String separator = getDelimiterConfigurationFromString(str);
        String [] elements = transformStringIntoElements(str, separator);
        for(String element: elements) {
            sum += getNumberFromString(element);
        }
        return sum;
    }

    private int getNumberFromString(String str) {
        try {
            return Integer.parseInt(str.trim());
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    private String [] transformStringIntoElements(String str, String separator) {
        if (str == null || separator == null) {
            return new String[0];
        }
        if (isStringBegginingMatching(str)) {
            str = str.substring(NUMBERS_SEQUENCE_START_POSITION);
        }
        return str.split(separator);
    }

//    private int getSumFromStringElement(String str) {
//        int sum = 0;
//        for (int i = 0; i < str.length(); i++) {
//            Character character = str.charAt(i);
//            if (i % 2 == 1 && character.toString().equals("\n")) {
//
//            } else {
//
//            }
//        }
//    }

    private String getDelimiterConfigurationFromString(String str) {
        if (isStringBegginingMatching(str)) {
            return str.substring(DELIMITER_POSITION, DELIMITER_POSITION + 1);
        }
        return ",";
    }

    private boolean isStringBegginingMatching(String str) {
        Pattern p = Pattern.compile("^(//[^0-9]\n)");
        Matcher matcher = p.matcher(str);
        return matcher.find();
    }
}
