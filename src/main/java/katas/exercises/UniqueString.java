package katas.exercises;

import java.util.HashSet;

public class UniqueString {

    /**
     * Checks if a string has all unique characters (case-insensitive).
     *
     * @param str the input string
     * @return true if all characters are unique, false otherwise
     */
    public static boolean isUnique(String str) {
        if (str == null || str.isEmpty()) {
            return true; // Treat empty or null strings as unique
        }

        HashSet<Character> seen = new HashSet<>();

        // Convert the string to lowercase to make it case-insensitive
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (seen.contains(c)) {
                return false; // If character is already in the set, it's not unique
            }
            seen.add(c); // Add character to the set
        }

        return true; // All characters are unique
    }

    public static void main(String[] args) {
        String test1 = "Hello";
        String test2 = "World";
        String test3 = "Java";
        String test4 = "Unique";

        System.out.println("\"" + test1 + "\" has all unique characters: " + isUnique(test1));
        System.out.println("\"" + test2 + "\" has all unique characters: " + isUnique(test2));
        System.out.println("\"" + test3 + "\" has all unique characters: " + isUnique(test3));
        System.out.println("\"" + test4 + "\" has all unique characters: " + isUnique(test4));
    }
}
