package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequirementsCoverageTest {

    @Test
    public void testExampleCase() {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2, 3),
                List.of(1, 4),
                List.of(2, 3, 4),
                List.of(1, 5),
                List.of(3, 5)
        );
        List<Integer> expected = List.of(2, 3);
        assertEquals(expected, RequirementsCoverage.selectMinimalTestCases(testCases));
    }

    @Test
    public void testSingleRequirement() {
        List<List<Integer>> testCases = List.of(
                List.of(1),
                List.of(2),
                List.of(3)
        );
        List<Integer> expected = List.of(0, 1, 2); // All test cases are needed
        assertEquals(expected, RequirementsCoverage.selectMinimalTestCases(testCases));
    }

    @Test
    public void testAllRequirementsInOneCase() {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2, 3, 4, 5)
        );
        List<Integer> expected = List.of(0); // Only one test case is needed
        assertEquals(expected, RequirementsCoverage.selectMinimalTestCases(testCases));
    }

    @Test
    public void testOverlappingRequirements() {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2),
                List.of(2, 3),
                List.of(3, 4),
                List.of(4, 5)
        );
        List<Integer> expected = List.of(0, 1, 3); // Optimal selection
        assertEquals(expected, RequirementsCoverage.selectMinimalTestCases(testCases));
    }

    @Test
    public void testNoRequirements() {
        List<List<Integer>> testCases = List.of();
        List<Integer> expected = List.of(); // No test cases needed
        assertEquals(expected, RequirementsCoverage.selectMinimalTestCases(testCases));
    }

    /*@Test
    public void testEmptyTestCases() {
        List<List<Integer>> testCases = List.of(
                List.of(),
                List.of(),
                List.of()
        );
        List<Integer> expected = List.of(); // No test cases cover any requirements
        assertEquals(expected, RequirementsCoverage.selectMinimalTestCases(testCases));
    }*/
}
