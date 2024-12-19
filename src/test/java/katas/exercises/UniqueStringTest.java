package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class UniqueStringTest {

    @Test
    public void testIsUnique_WithUniqueCharacters() {
        String input = "World";
        boolean result = UniqueString.isUnique(input);
        assertTrue(result, "'World' contains all unique characters.");
    }

    @Test
    public void testIsUnique_WithDuplicateCharacters() {
        String input = "Hello";
        boolean result = UniqueString.isUnique(input);
        assertFalse(result, "'Hello' does not contain all unique characters.");
    }

    @Test
    public void testIsUnique_WithCaseInsensitiveDuplicates() {
        String input = "Java";
        boolean result = UniqueString.isUnique(input);
        assertFalse(result, "'Java' contains duplicate characters ('J' and 'j') in a case-insensitive manner.");
    }

    @Test
    public void testIsUnique_WithEmptyString() {
        String input = "";
        boolean result = UniqueString.isUnique(input);
        assertTrue(result, "An empty string is considered to have all unique characters.");
    }

    @Test
    public void testIsUnique_WithNullString() {
        String input = null;
        boolean result = UniqueString.isUnique(input);
        assertTrue(result, "A null string is considered to have all unique characters.");
    }

    @Test
    public void testIsUnique_WithSingleCharacter() {
        String input = "A";
        boolean result = UniqueString.isUnique(input);
        assertTrue(result, "'A' has all unique characters since it contains only one character.");
    }

    @Test
    public void testIsUnique_WithSpecialCharacters() {
        String input = "@#$%^&*";
        boolean result = UniqueString.isUnique(input);
        assertTrue(result, "'@#$%^&*' contains all unique special characters.");
    }

    @Test
    public void testIsUnique_WithSpacesAndDuplicates() {
        String input = "a b c d a";
        boolean result = UniqueString.isUnique(input);
        assertFalse(result, "'a b c d a' contains duplicate 'a' and spaces.");
    }
}
