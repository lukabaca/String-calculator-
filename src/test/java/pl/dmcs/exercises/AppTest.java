package pl.dmcs.exercises;

import org.junit.jupiter.api.Test;
import pl.dmcs.exercises.exception.InvalidStringException;
import pl.dmcs.exercises.exception.NegativeNumberNotAllowedException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AppTest {

    @Test
     void testSum() {
        testSumResult(null, 0);
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
    void testInvalidStringException() {
        testSumResultThrowInvalidStringException("s1");
        testSumResultThrowInvalidStringException("15, 2#");
        testSumResultThrowInvalidStringException( "1,\n2");
        testSumResultThrowInvalidStringException( "1,\n2");
    }

    @Test
    void testNegativeNumbers() {
        testNegativeNumbersInSequence("-1", "Negatives not allowed [-1]");
        testNegativeNumbersInSequence("-1, 5, 5, -2", "Negatives not allowed [-1, -2]");
    }

    private void testNegativeNumbersInSequence(String str, String expectedExceptionMessage) {
        StringCalculator stringCalculator = new StringCalculator();
        Exception exception = assertThrows(NegativeNumberNotAllowedException.class, () -> stringCalculator.add(str));
        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

    private void testSumResult(String str, int expectedSum) {
        StringCalculator stringCalculator = new StringCalculator();
        int sum = stringCalculator.add(str);
        assertEquals(expectedSum, sum);
    }

    private void testSumResultThrowInvalidStringException(String str) {
        StringCalculator stringCalculator = new StringCalculator();
        assertThrows(InvalidStringException.class, () -> stringCalculator.add(str));
    }

}
