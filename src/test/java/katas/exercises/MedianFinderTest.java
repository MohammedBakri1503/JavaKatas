package katas.exercises;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MedianFinderTest {

    @Test
    void testMedianWithOddNumbers() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(3);
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(2.0, medianFinder.findMedian(), 0.001);
    }

    @Test
    void testMedianWithEvenNumbers() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(3);
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(4);
        assertEquals(2.5, medianFinder.findMedian(), 0.001);
    }

    @Test
    void testSingleElement() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(42);
        assertEquals(42.0, medianFinder.findMedian(), 0.001);
    }

    @Test
    void testSequentialAddition() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(10);
        assertEquals(10.0, medianFinder.findMedian(), 0.001);

        medianFinder.addNum(20);
        assertEquals(15.0, medianFinder.findMedian(), 0.001);

        medianFinder.addNum(30);
        assertEquals(20.0, medianFinder.findMedian(), 0.001);

        medianFinder.addNum(40);
        assertEquals(25.0, medianFinder.findMedian(), 0.001);
    }

    @Test
    void testNegativeNumbers() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-5);
        medianFinder.addNum(-1);
        medianFinder.addNum(-10);
        assertEquals(-5.0, medianFinder.findMedian(), 0.001);
    }
}

