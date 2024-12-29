package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidParenthesesTest {

    @Test
    public void testValidParentheses() {
        // Valid cases
        assertTrue(ValidParentheses.isValidParentheses("()"), "Expected valid parentheses for '()'");
        assertTrue(ValidParentheses.isValidParentheses("()[]{}"), "Expected valid parentheses for '()[]{}'");
        assertTrue(ValidParentheses.isValidParentheses("{[()]}"), "Expected valid parentheses for '{[()]}'");
        assertTrue(ValidParentheses.isValidParentheses(""), "Expected valid parentheses for an empty string");

        // Invalid cases
        assertFalse(ValidParentheses.isValidParentheses("(]"), "Expected invalid parentheses for '(]'");
        assertFalse(ValidParentheses.isValidParentheses("([)]"), "Expected invalid parentheses for '([)]'");
        assertFalse(ValidParentheses.isValidParentheses("((("), "Expected invalid parentheses for '((('");
        assertFalse(ValidParentheses.isValidParentheses(")"), "Expected invalid parentheses for ')'");
    }
}
