package pl.dmcs.exercises;

public class StringCalculator {

    int add(String str) {
        int sum = 0;
        if (str == null || str.equals("")) {
            return sum;
        }
        String [] elements = transformStringIntoElements(str, ",");
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
        if (str == null) {
            return new String[0];
        }
        return str.split(separator);
    }
}
