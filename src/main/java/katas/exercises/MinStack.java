package katas.exercises;

import java.util.Stack;

/**
 * Design a stack that supports standard stack operations (push, pop, top)
 * and also retrieves the minimum element in constant time.
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** Initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // If minStack is empty or the new value is smaller/equal to current min, push it to minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int popped = stack.pop();
            if (!minStack.isEmpty() && popped == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin()); // Output: -3
        stack.pop();
        System.out.println(stack.top()); // Output: 0
        System.out.println(stack.getMin()); // Output: -2
    }
}
