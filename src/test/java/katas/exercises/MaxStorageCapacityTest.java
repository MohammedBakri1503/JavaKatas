package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaxStorageCapacityTest {

    @Test
    public void testMaxStorageArea() {
        // Test case 1: Example input
        int[] containers1 = {2, 1, 5, 6, 2, 3};
        assertEquals(10, MaxStorageCapacity.maxStorageArea(containers1),
                "Expected max storage area of 10 for input {2, 1, 5, 6, 2, 3}");

        // Test case 2: Increasing heights
        int[] containers2 = {1, 2, 3, 4, 5};
        assertEquals(9, MaxStorageCapacity.maxStorageArea(containers2),
                "Expected max storage area of 9 for input {1, 2, 3, 4, 5}");

        // Test case 3: Decreasing heights
        int[] containers3 = {5, 4, 3, 2, 1};
        assertEquals(9, MaxStorageCapacity.maxStorageArea(containers3),
                "Expected max storage area of 9 for input {5, 4, 3, 2, 1}");

        // Test case 4: All heights equal
        int[] containers4 = {3, 3, 3, 3};
        assertEquals(12, MaxStorageCapacity.maxStorageArea(containers4),
                "Expected max storage area of 12 for input {3, 3, 3, 3}");

        // Test case 5: Single container
        int[] containers5 = {5};
        assertEquals(5, MaxStorageCapacity.maxStorageArea(containers5),
                "Expected max storage area of 5 for single container {5}");

        // Test case 6: No containers
        int[] containers6 = {};
        assertEquals(0, MaxStorageCapacity.maxStorageArea(containers6),
                "Expected max storage area of 0 for empty container list");

        // Test case 7: Random heights
        int[] containers7 = {6, 2, 5, 4, 5, 1, 6};
        assertEquals(12, MaxStorageCapacity.maxStorageArea(containers7),
                "Expected max storage area of 12 for input {6, 2, 5, 4, 5, 1, 6}");
    }
}
