package katas.exercises;

public class StockTrader {

    /**
     * Finds the maximum profit that can be achieved by buying and selling the stock ONCE.
     *
     * Aim for O(n)
     *
     * @param prices an array of prices on each day
     * @return the maximum profit, or 0 if no profit can be achieved
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0;
        int r = 0;
        while (r < prices.length - 1) {
            if(prices[r] < prices[l]) {
                l = r;
            }
            r++;
            maxProfit = Math.max(maxProfit, prices[r] - prices[l]);

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(stockPrices);
        System.out.println("Maximum Profit: " + profit);  // should be 5
    }
}
