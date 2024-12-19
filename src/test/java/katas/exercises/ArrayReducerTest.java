package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class ArrayReducerTest {

    @Test
    public void testReduceArray_WithValidArray() {
        int[] numbers = {10, 15, 7, 20, 25};
        ArrayReducer.reduceArray(numbers);
        int[] expected = {10, 5, -8, 13, 5};
        assertArrayEquals(expected, numbers, "The array should be reduced correctly.");
    }

    @Test
    public void testReduceArray_WithSingleElementArray() {
        int[] numbers = {5};
        ArrayReducer.reduceArray(numbers);
        int[] expected = {5}; // No changes for single-element arrays
        assertArrayEquals(expected, numbers, "Single-element arrays should remain unchanged.");
    }

    @Test
    public void testReduceArray_WithNullArray() {
        int[] numbers = null;
        ArrayReducer.reduceArray(numbers);
        // No exception should be thrown, and method returns silently
    }

    @Test
    public void testReduceArray_WithEmptyArray() {
        int[] numbers = {};
        ArrayReducer.reduceArray(numbers);
        int[] expected = {}; // No changes for empty arrays
        assertArrayEquals(expected, numbers, "Empty arrays should remain unchanged.");
    }

    @Test
    public void testReduceArray_WithTwoElements() {
        int[] numbers = {10, 20};
        ArrayReducer.reduceArray(numbers);
        int[] expected = {10, 10}; // Second element = 20 - 10
        assertArrayEquals(expected, numbers, "The array should be reduced correctly for two elements.");
    }

    @Test
    public void testReduceArray_WithNegativeNumbers() {
        int[] numbers = {-10, -5, -8, -2};
        ArrayReducer.reduceArray(numbers);
        int[] expected = {-10, 5, -3, 6};
        assertArrayEquals(expected, numbers, "The array should handle negative numbers correctly.");
    }
}
