package pl.dmcs.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void test() {
        testSumResult("", 0);
    }

    private void testSumResult(String str, int expectedSum) {
        StringCalculator stringCalculator = new StringCalculator();
        int sum = stringCalculator.add(str);
        assertEquals(expectedSum, sum);
    }
}
