package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

public class SlidingWindowMaximumTest {

    @Test
    public void testMaxSlidingWindow() {
        // Test case 1: Example input
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        List<Integer> expected1 = List.of(3, 3, 5, 5, 6, 7);
        assertEquals(expected1, SlidingWindowMaximum.maxSlidingWindow(nums1, k1),
                "Expected sliding window maximums for input {1, 3, -1, -3, 5, 3, 6, 7} with k=3");

        // Test case 2: Single element window
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 1;
        List<Integer> expected2 = List.of(1, 2, 3, 4, 5);
        assertEquals(expected2, SlidingWindowMaximum.maxSlidingWindow(nums2, k2),
                "Expected sliding window maximums for input {1, 2, 3, 4, 5} with k=1");

        // Test case 3: Full array as window
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 5;
        List<Integer> expected3 = List.of(5);
        assertEquals(expected3, SlidingWindowMaximum.maxSlidingWindow(nums3, k3),
                "Expected sliding window maximums for input {1, 2, 3, 4, 5} with k=5");

        // Test case 4: Decreasing array
        int[] nums4 = {5, 4, 3, 2, 1};
        int k4 = 3;
        List<Integer> expected4 = List.of(5, 4, 3);
        assertEquals(expected4, SlidingWindowMaximum.maxSlidingWindow(nums4, k4),
                "Expected sliding window maximums for input {5, 4, 3, 2, 1} with k=3");

        // Test case 5: Edge case with empty input
        int[] nums5 = {};
        int k5 = 3;
        List<Integer> expected5 = List.of();
        assertEquals(expected5, SlidingWindowMaximum.maxSlidingWindow(nums5, k5),
                "Expected empty list for empty input");

        // Test case 6: Edge case with k larger than array length
        int[] nums6 = {1, 2, 3};
        int k6 = 5;
        List<Integer> expected6 = List.of();
        assertEquals(expected6, SlidingWindowMaximum.maxSlidingWindow(nums6, k6),
                "Expected empty list for input {1, 2, 3} with k=5");
    }
}
