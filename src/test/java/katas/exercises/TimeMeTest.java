package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeMeTest {

    @Test
    public void testMeasureExecutionTime_WithLongRunningFunction() {
        Runnable longRunningTask = () -> {
            try {
                Thread.sleep(500); // Simulates a task that takes ~500 ms
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        long timeTaken = TimeMe.measureExecutionTime(longRunningTask);
        assertTrue(timeTaken >= 500, "Execution time should be at least 500 ms for the long-running function.");
    }

    @Test
    public void testMeasureExecutionTime_WithQuickFunction() {
        Runnable quickTask = () -> System.out.println("Quick task executed!");

        long timeTaken = TimeMe.measureExecutionTime(quickTask);
        assertTrue(timeTaken >= 0 && timeTaken < 50, "Execution time for a quick task should be very small (less than 50 ms).");
    }

    @Test
    public void testMeasureExecutionTime_WithNullFunction() {
        try {
            TimeMe.measureExecutionTime(null);
        } catch (NullPointerException e) {
            // The test passes if a NullPointerException occurs
            return;
        }
        throw new AssertionError("The method should throw NullPointerException when Runnable is null.");
    }

    @Test
    public void testMeasureExecutionTime_WithEmptyTask() {
        Runnable emptyTask = () -> {}; // Does nothing

        long timeTaken = TimeMe.measureExecutionTime(emptyTask);
        assertTrue(timeTaken >= 0, "Execution time for an empty task should be very small but not negative.");
    }
}
