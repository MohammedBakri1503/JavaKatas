package katas.exercises;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MinStackTest {

    @Test
    void testMinStackOperations() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        assertEquals(-3, stack.getMin()); // getMin() should return -3
        stack.pop();
        assertEquals(0, stack.top()); // top() should return 0
        assertEquals(-2, stack.getMin()); // getMin() should return -2
    }

    @Test
    void testMinStackSingleElement() {
        MinStack stack = new MinStack();
        stack.push(10);
        assertEquals(10, stack.getMin());
        assertEquals(10, stack.top());
        stack.pop();
        assertEquals(-1, stack.getMin()); // Stack is empty, should return -1
    }

    @Test
    void testMinStackIncreasingOrder() {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(1, stack.getMin());
        stack.pop();
        stack.pop();
        assertEquals(1, stack.getMin());
    }

    @Test
    void testMinStackDecreasingOrder() {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        assertEquals(1, stack.getMin());
        stack.pop();
        assertEquals(2, stack.getMin());
    }
}
