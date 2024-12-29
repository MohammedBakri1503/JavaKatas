package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StockTrader2Test {

    @Test
    public void testMaxProfit() {
        // Test case 1: Regular input
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        assertEquals(7, StockTrader2.maxProfit(prices1), "Expected maximum profit of 7 for input {7, 1, 5, 3, 6, 4}");

        // Test case 2: Increasing prices
        int[] prices2 = {1, 2, 3, 4, 5};
        assertEquals(4, StockTrader2.maxProfit(prices2), "Expected maximum profit of 4 for input {1, 2, 3, 4, 5}");

        // Test case 3: Decreasing prices
        int[] prices3 = {7, 6, 4, 3, 1};
        assertEquals(0, StockTrader2.maxProfit(prices3), "Expected maximum profit of 0 for input {7, 6, 4, 3, 1}");

        // Test case 4: Empty prices
        int[] prices4 = {};
        assertEquals(0, StockTrader2.maxProfit(prices4), "Expected maximum profit of 0 for empty input");

        // Test case 5: Single day
        int[] prices5 = {5};
        assertEquals(0, StockTrader2.maxProfit(prices5), "Expected maximum profit of 0 for single-day input {5}");

        // Test case 6: Fluctuating prices
        int[] prices6 = {3, 3, 5, 0, 0, 3, 1, 4};
        assertEquals(8, StockTrader2.maxProfit(prices6), "Expected maximum profit of 8 for input {3, 3, 5, 0, 0, 3, 1, 4}");
    }
}
