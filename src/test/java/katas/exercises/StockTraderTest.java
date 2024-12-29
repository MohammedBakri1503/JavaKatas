package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StockTraderTest {

    @Test
    public void testMaxProfit() {
        // Test case 1: Regular input
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        assertEquals(5, StockTrader.maxProfit(prices1), "Expected maximum profit of 5 for input {7, 1, 5, 3, 6, 4}");

        // Test case 2: Increasing prices
        int[] prices2 = {1, 2, 3, 4, 5};
        assertEquals(4, StockTrader.maxProfit(prices2), "Expected maximum profit of 4 for input {1, 2, 3, 4, 5}");

        // Test case 3: Decreasing prices
        int[] prices3 = {7, 6, 4, 3, 1};
        assertEquals(0, StockTrader.maxProfit(prices3), "Expected maximum profit of 0 for input {7, 6, 4, 3, 1}");

        // Test case 4: Empty prices
        int[] prices4 = {};
        assertEquals(0, StockTrader.maxProfit(prices4), "Expected maximum profit of 0 for empty input");

        // Test case 5: Single day
        int[] prices5 = {5};
        assertEquals(0, StockTrader.maxProfit(prices5), "Expected maximum profit of 0 for single-day input {5}");

        // Test case 6: Fluctuating prices
        int[] prices6 = {2, 4, 1, 5, 6, 2};
        assertEquals(5, StockTrader.maxProfit(prices6), "Expected maximum profit of 5 for input {2, 4, 1, 5, 6, 2}");
    }
}
