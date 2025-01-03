package katas.exercises;

import java.util.*;

public class RequirementsCoverage {

    /**
     * In software testing, it's often required to select a minimal set of test cases that cover all the requirements.
     * You are given a set of test cases and their associated covered requirements.
     * Your task is to select the minimal subset of test cases such that all requirements are covered.
     *
     * For example, you have the following test cases and requirements they cover:
     *
     * testCases = [
     *   [1, 2, 3],   // Test case 0 covers requirements 1, 2, 3
     *   [1, 4],      // Test case 1 covers requirements 1, 4
     *   [2, 3, 4],   // Test case 2 covers requirements 2, 3, 4
     *   [1, 5],      // Test case 3 covers requirements 1, 5
     *   [3, 5]       // Test case 4 covers requirements 3, 5
     * ]
     *
     * @param testCases a list of test cases, where each test case is a list of requirements it covers
     * @return a list of indices of the minimal subset of test cases that covers all requirements
     */
    public static List<Integer> selectMinimalTestCases(List<List<Integer>> testCases) {
        // Set to store all unique requirements to be covered
        Set<Integer> allRequirements = new HashSet<>();
        for (List<Integer> testCase : testCases) {
            allRequirements.addAll(testCase);
        }

        // Generate all subsets of test case indices
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < testCases.size(); i++) {
            indices.add(i);
        }

        // Check subsets from smallest to largest
        for (int r = 1; r <= testCases.size(); r++) {
            List<List<Integer>> subsets = generateSubsets(indices, r);
            for (List<Integer> subset : subsets) {
                Set<Integer> covered = new HashSet<>();
                for (int index : subset) {
                    covered.addAll(testCases.get(index));
                }
                if (covered.equals(allRequirements)) {
                    return subset;
                }
            }
        }

        return new ArrayList<>();
    }

    private static List<List<Integer>> generateSubsets(List<Integer> list, int r) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsetsHelper(list, new ArrayList<>(), 0, r, subsets);
        return subsets;
    }

    private static void generateSubsetsHelper(List<Integer> list, List<Integer> current, int start, int r, List<List<Integer>> subsets) {
        if (current.size()  == r) {
            subsets.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            current.add(list.get(i));
            generateSubsetsHelper(list, current, i + 1, r, subsets);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2, 3),
                List.of(1, 4),
                List.of(2, 3, 4),
                List.of(1, 5),
                List.of(3, 5)
        );

        List<Integer> result = selectMinimalTestCases(testCases);
        System.out.println(result); // Expected output: [2, 3]
    }
}
