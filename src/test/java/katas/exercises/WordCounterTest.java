package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WordCounterTest {

    @Test
    public void testCountWords_WithRegularSentence() {
        String sentence = "This is a sample sentence for counting words.";
        int result = WordCounter.countWords(sentence);
        assertEquals(8, result, "The word count for 'This is a sample sentence for counting words.' should be 8.");
    }

    @Test
    public void testCountWords_WithMultipleSpaces() {
        String sentence = "This   sentence   has   extra   spaces.";
        int result = WordCounter.countWords(sentence);
        assertEquals(5, result, "The word count for 'This   sentence   has   extra   spaces.' should be 5.");
    }

    @Test
    public void testCountWords_WithLeadingAndTrailingSpaces() {
        String sentence = "   Leading and trailing spaces are here   ";
        int result = WordCounter.countWords(sentence);
        assertEquals(6, result, "The word count for '   Leading and trailing spaces are here   ' should be 6.");
    }

    @Test
    public void testCountWords_WithEmptyString() {
        String sentence = "";
        int result = WordCounter.countWords(sentence);
        assertEquals(0, result, "The word count for an empty string should be 0.");
    }

    @Test
    public void testCountWords_WithNullInput() {
        String sentence = null;
        int result = WordCounter.countWords(sentence);
        assertEquals(0, result, "The word count for a null string should be 0.");
    }

    @Test
    public void testCountWords_WithSingleWord() {
        String sentence = "Hello";
        int result = WordCounter.countWords(sentence);
        assertEquals(1, result, "The word count for 'Hello' should be 1.");
    }

    @Test
    public void testCountWords_WithOnlySpaces() {
        String sentence = "      ";
        int result = WordCounter.countWords(sentence);
        assertEquals(0, result, "The word count for a string with only spaces should be 0.");
    }
}
