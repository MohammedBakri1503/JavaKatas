package katas.exercises;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;

import java.util.Set;


public class ValidGitTree {

    /**
     * Determines if a given tree structure represents a valid Git tree.
     *
     * A valid Git tree should:
     * 1. Have exactly one root (no parent).
     * 2. Contain no cycles.
     *
     * @param treeMap a map representing the Git tree (commit ID to list of child commit IDs)
     * @return true if the tree is a valid Git tree, false otherwise
     */
    public static boolean isValidGitTree(Map<String, List<String>> treeMap) {
        if (treeMap == null || treeMap.isEmpty()) {
            return false; // Empty tree is invalid
        }

        Set<String> allNodes = new HashSet<>();
        Set<String> allChildren = new HashSet<>();
        for (Map.Entry<String, List<String>> entry : treeMap.entrySet()) {
            String parent = entry.getKey();
            List<String> children = entry.getValue();
            allNodes.add(parent);
            allChildren.addAll(children);
        }

        Set<String> roots = new HashSet<>(allNodes);
        roots.removeAll(allChildren);
        if (roots.size() != 1) {
            return false;
        }

        String root = roots.iterator().next();

        // Check for cycles using DFS
        Set<String> visited = new HashSet<>();
        if (hasCycle(root, treeMap, visited, new HashSet<>())) {
            return false;
        }

        return visited.size() == allNodes.size();
    }

    private static boolean hasCycle(String node, Map<String, List<String>> treeMap, Set<String> visited, Set<String> currentStack) {
        if (currentStack.contains(node)) {
            return true; // Cycle detected
        }

        if (visited.contains(node)) {
            return false; //  already processed
        }

        visited.add(node);
        currentStack.add(node);

        for (String child : treeMap.getOrDefault(node, List.of())) {
            if (hasCycle(child, treeMap, visited, currentStack)) {
                return true;
            }
        }

        currentStack.remove(node);
        return false;
    }

    public static void main(String[] args) {
        Map<String, List<String>> validTree = new HashMap<>();
        validTree.put("A", List.of("B", "C"));
        validTree.put("B", List.of("D"));
        validTree.put("C", List.of());
        validTree.put("D", List.of());

        Map<String, List<String>> invalidTree = new HashMap<>();
        invalidTree.put("A", List.of("B"));
        invalidTree.put("B", List.of("C"));
        invalidTree.put("C", List.of("A")); // cycle

        System.out.println("Is valid tree: " + isValidGitTree(validTree));
        System.out.println("Is valid tree: " + isValidGitTree(invalidTree));
    }
}

