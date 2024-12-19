package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ArrayDifferenceTest {

    @Test
    public void testFindDifference_WithValidArray() {
        int[] numbers = {10, 3, 5, 6, 20, -2};
        int result = ArrayDifference.findDifference(numbers);
        assertEquals(22, result, "The difference between the largest and smallest numbers should be 22");
    }

    @Test
    public void testFindDifference_WithSingleElementArray() {
        int[] numbers = {5};
        int result = ArrayDifference.findDifference(numbers);
        assertEquals(0, result, "The difference in a single-element array should be 0");
    }

    @Test
    public void testFindDifference_WithAllNegativeNumbers() {
        int[] numbers = {-10, -3, -5, -6, -20, -2};
        int result = ArrayDifference.findDifference(numbers);
        assertEquals(18, result, "The difference between the largest and smallest numbers should be 18");
    }

    @Test
    public void testFindDifference_WithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayDifference.findDifference(null);
        }, "The method should throw IllegalArgumentException for null input");
    }

    @Test
    public void testFindDifference_WithEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayDifference.findDifference(new int[]{});
        }, "The method should throw IllegalArgumentException for an empty array");
    }
}
