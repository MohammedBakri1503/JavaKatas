package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoNTimesTest {

    @Test
    public void testDoNTimes_WithPositiveN() {
        AtomicInteger counter = new AtomicInteger(0); // Thread-safe counter
        Runnable incrementCounter = () -> counter.incrementAndGet();

        DoNTimes.doNTimes(incrementCounter, 5);
        assertEquals(5, counter.get(), "The function should execute 5 times.");
    }

    @Test
    public void testDoNTimes_WithZeroN() {
        AtomicInteger counter = new AtomicInteger(0);
        Runnable incrementCounter = () -> counter.incrementAndGet();

        DoNTimes.doNTimes(incrementCounter, 0);
        assertEquals(0, counter.get(), "The function should not execute when n is 0.");
    }

    @Test
    public void testDoNTimes_WithNegativeN() {
        AtomicInteger counter = new AtomicInteger(0);
        Runnable incrementCounter = () -> counter.incrementAndGet();

        DoNTimes.doNTimes(incrementCounter, -3);
        assertEquals(0, counter.get(), "The function should not execute when n is negative.");
    }

    @Test
    public void testDoNTimes_WithNullFunction() {
        // Null function should not cause any issues
        DoNTimes.doNTimes(null, 5);
        // If no exception is thrown, the test passes
    }

    @Test
    public void testDoNTimes_WithPrintFunction() {
        // This is more for demonstration - a print statement test
        Runnable printMessage = () -> System.out.println("Test message!");
        DoNTimes.doNTimes(printMessage, 3);
        // Visual validation: check output for "Test message!" printed 3 times
    }
}
