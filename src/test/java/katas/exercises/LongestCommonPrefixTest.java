package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LongestCommonPrefixTest {

    @Test
    public void testLongestCommonPrefix_WithValidPrefix() {
        String[] strs = {"flower", "flow", "flight"};
        String result = LongestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("fl", result, "The longest common prefix should be 'fl'.");
    }

    @Test
    public void testLongestCommonPrefix_WithNoCommonPrefix() {
        String[] strs = {"dog", "racecar", "car"};
        String result = LongestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("", result, "There is no common prefix; result should be an empty string.");
    }

    @Test
    public void testLongestCommonPrefix_WithFullMatch() {
        String[] strs = {"same", "same", "same"};
        String result = LongestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("same", result, "All strings are the same; the prefix should match the full string.");
    }

    @Test
    public void testLongestCommonPrefix_WithPartialMatch() {
        String[] strs = {"interspecies", "interstellar", "interstate"};
        String result = LongestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("inters", result, "The longest common prefix should be 'inter'.");
    }

    @Test
    public void testLongestCommonPrefix_WithSingleString() {
        String[] strs = {"alone"};
        String result = LongestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("alone", result, "With only one string, the prefix should match the string itself.");
    }

    @Test
    public void testLongestCommonPrefix_WithEmptyArray() {
        String[] strs = {};
        String result = LongestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("", result, "An empty array should return an empty string as the prefix.");
    }

    @Test
    public void testLongestCommonPrefix_WithNullInput() {
        String[] strs = null;
        String result = LongestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("", result, "A null input should return an empty string as the prefix.");
    }

    @Test
    public void testLongestCommonPrefix_WithEmptyStrings() {
        String[] strs = {"", "abc", "abcd"};
        String result = LongestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("", result, "If one string is empty, the result should be an empty string.");
    }
}
