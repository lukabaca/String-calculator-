package pl.dmcs.exercises;

import org.junit.jupiter.api.Test;
import pl.dmcs.exercises.exception.InvalidStringException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppTest {

    @Test
    public void testSum() {
        testSumResult("", 0);
        testSumResult("1", 1);
        testSumResult("1, 2", 3);
        testSumResult(" 1, 2 ", 3);
        testSumResult("1,2,3,4,5", 15);
        testSumResult("//;\n2; 3", 5);
        testSumResult("//;\n 2; 3", 5);
        testSumResult( "1\n2,3", 6);
        testSumResult( "1\n2, 3\n5", 11);
        testSumResult("//@\n 2@ 3", 5);
    }

    @Test
    public void testInvalidStringException() {
        testSumResultThrowInvalidStringException("s1", 1);
        testSumResultThrowInvalidStringException("15, 2#", 3);
        testSumResultThrowInvalidStringException( "1,\n2", 3);
        testSumResultThrowInvalidStringException( "1,\n2", 3);
    }

    private void testSumResult(String str, int expectedSum) {
        StringCalculator stringCalculator = new StringCalculator();
        int sum = stringCalculator.add(str);
        assertEquals(expectedSum, sum);
    }

    private void testSumResultThrowInvalidStringException(String str, int expectedSum) {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(InvalidStringException.class, () -> stringCalculator.add(str));
    }

}
