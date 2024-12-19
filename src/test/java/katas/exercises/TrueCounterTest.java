package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TrueCounterTest {

    @Test
    public void testCountTrueValues_WithMixedValues() {
        boolean[] array = {true, false, true, true, false};
        int result = TrueCounter.countTrueValues(array);
        assertEquals(3, result, "The count of true values should be 3.");
    }

    @Test
    public void testCountTrueValues_WithAllTrue() {
        boolean[] array = {true, true, true, true, true};
        int result = TrueCounter.countTrueValues(array);
        assertEquals(5, result, "The count of true values should be 5 when all values are true.");
    }

    @Test
    public void testCountTrueValues_WithAllFalse() {
        boolean[] array = {false, false, false, false, false};
        int result = TrueCounter.countTrueValues(array);
        assertEquals(0, result, "The count of true values should be 0 when all values are false.");
    }

    @Test
    public void testCountTrueValues_WithEmptyArray() {
        boolean[] array = {};
        int result = TrueCounter.countTrueValues(array);
        assertEquals(0, result, "The count of true values should be 0 for an empty array.");
    }

    @Test
    public void testCountTrueValues_WithSingleTrueValue() {
        boolean[] array = {true};
        int result = TrueCounter.countTrueValues(array);
        assertEquals(1, result, "The count of true values should be 1 for a single true value.");
    }

    @Test
    public void testCountTrueValues_WithSingleFalseValue() {
        boolean[] array = {false};
        int result = TrueCounter.countTrueValues(array);
        assertEquals(0, result, "The count of true values should be 0 for a single false value.");
    }
}
