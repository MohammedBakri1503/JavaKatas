package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StringDigitSumTest {

    @Test
    public void testSumOfDigits_WithDigitsOnly() {
        String input = "12345";
        int result = StringDigitSum.sumOfDigits(input);
        assertEquals(15, result, "The sum of digits in '12345' should be 15.");
    }

    @Test
    public void testSumOfDigits_WithMixedCharacters() {
        String input = "abc123";
        int result = StringDigitSum.sumOfDigits(input);
        assertEquals(6, result, "The sum of digits in 'abc123' should be 6.");
    }

    @Test
    public void testSumOfDigits_WithSpacesAndText() {
        String input = "5 cats and 2 dogs";
        int result = StringDigitSum.sumOfDigits(input);
        assertEquals(7, result, "The sum of digits in '5 cats and 2 dogs' should be 7.");
    }

    @Test
    public void testSumOfDigits_WithNoDigits() {
        String input = "No digits here!";
        int result = StringDigitSum.sumOfDigits(input);
        assertEquals(0, result, "The sum of digits in 'No digits here!' should be 0.");
    }

    @Test
    public void testSumOfDigits_WithEmptyString() {
        String input = "";
        int result = StringDigitSum.sumOfDigits(input);
        assertEquals(0, result, "The sum of digits in an empty string should be 0.");
    }

    @Test
    public void testSumOfDigits_WithSpecialCharacters() {
        String input = "!@#1$%^2&*()3";
        int result = StringDigitSum.sumOfDigits(input);
        assertEquals(6, result, "The sum of digits in '!@#1$%^2&*()3' should be 6.");
    }

    @Test
    public void testSumOfDigits_WithLargeString() {
        String input = "There are 123 apples and 456 oranges, 789 total.";
        int result = StringDigitSum.sumOfDigits(input);
        assertEquals(45, result, "The sum of digits in 'There are 123 apples and 456 oranges, 789 total.' should be 45.");
    }
}
