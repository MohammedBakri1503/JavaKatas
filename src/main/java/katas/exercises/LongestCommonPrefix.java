package katas.exercises;

public class LongestCommonPrefix {

    /**
     * Finds the longest common prefix in an array of strings.
     *
     * @param strs the array of strings
     * @return the longest common prefix, or an empty string if none exists
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return ""; // Edge case: empty array or null input
        }

        // Assume the first string is the prefix
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            // Check the prefix against each string
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix if it doesn't match
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return ""; // Return early if no common prefix exists
                }
            }
        }

        return prefix;
    }
    public static void main(String[] args) {
        String[] test1 = {"flower", "flow", "flight"};
        String[] test2 = {"dog", "racecar", "car"};
        String[] test3 = {"interspecies", "interstellar", "interstate"};
        String[] test4 = {"apple", "apricot", "ape"};

        System.out.println("Longest Common Prefix: " + longestCommonPrefix(test1)); // Output: "fl"
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(test2)); // Output: ""
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(test3)); // Output: "inter"
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(test4)); // Output: "ap"
    }
}
