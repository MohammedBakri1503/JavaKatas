package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.util.*;

public class ValidGitTreeTest {

    @Test
    public void testValidGitTree() {
        // Valid tree example
        Map<String, List<String>> validTree = new HashMap<>();
        validTree.put("A", List.of("B", "C"));
        validTree.put("B", List.of("D"));
        validTree.put("C", List.of());
        validTree.put("D", List.of());

        assertTrue(ValidGitTree.isValidGitTree(validTree), "Expected valid Git tree for validTree");

        // Invalid tree with a cycle
        Map<String, List<String>> invalidTreeWithCycle = new HashMap<>();
        invalidTreeWithCycle.put("A", List.of("B"));
        invalidTreeWithCycle.put("B", List.of("C"));
        invalidTreeWithCycle.put("C", List.of("A"));

        assertFalse(ValidGitTree.isValidGitTree(invalidTreeWithCycle), "Expected invalid Git tree due to a cycle");

        // Invalid tree with multiple roots
        Map<String, List<String>> invalidTreeMultipleRoots = new HashMap<>();
        invalidTreeMultipleRoots.put("A", List.of("B"));
        invalidTreeMultipleRoots.put("C", List.of("D"));

        assertFalse(ValidGitTree.isValidGitTree(invalidTreeMultipleRoots), "Expected invalid Git tree due to multiple roots");

        // Invalid tree with a disconnected node
        Map<String, List<String>> invalidTreeDisconnected = new HashMap<>();
        invalidTreeDisconnected.put("A", List.of("B"));
        invalidTreeDisconnected.put("B", List.of());
        invalidTreeDisconnected.put("C", List.of()); // Disconnected node

        assertFalse(ValidGitTree.isValidGitTree(invalidTreeDisconnected), "Expected invalid Git tree due to a disconnected node");
    }
}
