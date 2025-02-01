package katas.exercises;

import java.util.PriorityQueue;

/**
 * Find the median of a stream of integers using two heaps.
 * - Min-heap for the larger half of numbers.
 * - Max-heap for the smaller half of numbers.
 *
 * Adding a number: O(log n).
 * Finding the median: O(1).
 */
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // Stores the smaller half (as a max-heap)
    private PriorityQueue<Integer> minHeap; // Stores the larger half (as a min-heap)

    /** Initializes the MedianFinder object. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max-heap (reversed order)
        minHeap = new PriorityQueue<>(); // Min-heap (natural order)
    }

    /**
     * Adds a number to the data stream.
     *
     * @param num the number to be added
     */
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balance the heaps so that maxHeap can have at most one extra element
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    /**
     * Finds and returns the median of the data stream.
     *
     * @return the median as a double
     */
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian()); // Output: 1.5

        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian()); // Output: 2.0

        medianFinder.addNum(5);
        System.out.println("Median: " + medianFinder.findMedian()); // Output: 2.5
    }
}
