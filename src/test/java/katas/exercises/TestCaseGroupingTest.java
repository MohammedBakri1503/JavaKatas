
package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

public class TestCaseGroupingTest {

    @Test
    public void testGroupTestCases() {
        // Test case 1: Example input
        List<Integer> testCaseGroupSizes1 = List.of(1, 2, 3, 3, 3, 2);
        List<List<Integer>> expectedGroups1 = List.of(
                List.of(0),
                List.of(2, 3, 4),
                List.of(1, 5)

                );
        assertEquals(expectedGroups1, TestCaseGrouping.groupTestCases(testCaseGroupSizes1),
                "Expected groups for input [1, 2, 3, 3, 3, 2]");

        // Test case 2: Single test case in each group
        List<Integer> testCaseGroupSizes2 = List.of(1, 1, 1);
        List<List<Integer>> expectedGroups2 = List.of(
                List.of(0),
                List.of(1),
                List.of(2)
        );
        assertEquals(expectedGroups2, TestCaseGrouping.groupTestCases(testCaseGroupSizes2),
                "Expected groups for input [1, 1, 1]");

        // Test case 3: Multiple groups of the same size
        List<Integer> testCaseGroupSizes3 = List.of(2, 2, 2, 2);
        List<List<Integer>> expectedGroups3 = List.of(
                List.of(0, 1),
                List.of(2, 3)
        );
        assertEquals(expectedGroups3, TestCaseGrouping.groupTestCases(testCaseGroupSizes3),
                "Expected groups for input [2, 2, 2, 2]");

        // Test case 4: Empty input
        List<Integer> testCaseGroupSizes4 = List.of();
        List<List<Integer>> expectedGroups4 = List.of();
        assertEquals(expectedGroups4, TestCaseGrouping.groupTestCases(testCaseGroupSizes4),
                "Expected empty groups for empty input");

        // Test case 5: No grouping possible due to mismatched sizes
        List<Integer> testCaseGroupSizes5 = List.of(1, 3, 2);
        List<List<Integer>> expectedGroups5 = List.of(
                List.of(0)
        );
        assertEquals(expectedGroups5, TestCaseGrouping.groupTestCases(testCaseGroupSizes5),
                "Expected partial grouping for input [1, 3, 2]");
    }
}
