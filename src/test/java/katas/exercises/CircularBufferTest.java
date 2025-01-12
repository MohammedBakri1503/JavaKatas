package katas.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CircularBufferTest {

    @Test
    public void testAddAndGet_WithValidBuffer() {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);

        assertEquals(1, buffer.get(), "The oldest element (1) should be retrieved first");
        assertEquals(2, buffer.get(), "The next oldest element (2) should be retrieved next");
        assertEquals(3, buffer.get(), "The last element (3) should be retrieved");
    }

    @Test
    public void testAdd_WhenBufferIsFull() {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.add(4); // Overwrites the oldest element (1)

        assertEquals(2, buffer.get(), "After overwriting, the oldest element should be 2");
        assertEquals(3, buffer.get(), "The next oldest element should be 3");
        assertEquals(4, buffer.get(), "The last added element (4) should be retrieved");
    }

    @Test
    public void testGet_WhenBufferIsEmpty() {
        CircularBuffer buffer = new CircularBuffer(3);

        assertEquals(-1, buffer.get(), "Retrieving from an empty buffer should return -1");
    }

    @Test
    public void testIsFull_WhenBufferIsFull() {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);

        assertTrue(buffer.isFull(), "The buffer should be full after adding 3 elements");
    }

    @Test
    public void testIsFull_WhenBufferIsNotFull() {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);

        assertFalse(buffer.isFull(), "The buffer should not be full after adding only 1 element");
    }

    @Test
    public void testIsEmpty_WhenBufferIsEmpty() {
        CircularBuffer buffer = new CircularBuffer(3);

        assertTrue(buffer.isEmpty(), "The buffer should be empty initially");

        buffer.add(1);
        buffer.get();

        assertTrue(buffer.isEmpty(), "The buffer should be empty after retrieving all elements");
    }

    @Test
    public void testIsEmpty_WhenBufferIsNotEmpty() {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);

        assertFalse(buffer.isEmpty(), "The buffer should not be empty after adding an element");
    }

    @Test
    public void testOverwriteBehavior() {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.add(4); // Overwrites 1
        buffer.add(5); // Overwrites 2

        assertEquals(3, buffer.get(), "After overwriting, the oldest element should be 3");
        assertEquals(4, buffer.get(), "Next oldest element should be 4");
        assertEquals(5, buffer.get(), "Last added element should be 5");
    }
}

