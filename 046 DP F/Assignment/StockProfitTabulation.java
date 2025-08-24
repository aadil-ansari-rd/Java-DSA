public class StockProfitTabulation {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        // Base case
        dp[0][0] = 0;            // not holding stock
        dp[0][1] = -prices[0];   // bought stock on day 0

        // Fill DP table
        for (int i = 1; i < n; i++) {
            // Not holding stock today
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);

            // Holding stock today
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[n-1][0];  // max profit without holding stock at the end
    }

    // Main method to test
    public static void main(String[] args) {
        StockProfitTabulation solver = new StockProfitTabulation();

        int[] prices1 = {7,1,5,3,6,4};
        System.out.println("Max Profit (Example 1): " + solver.maxProfit(prices1)); // 7

        int[] prices2 = {1,2,3,4,5};
        System.out.println("Max Profit (Example 2): " + solver.maxProfit(prices2)); // 4

        int[] prices3 = {7,6,4,3,1};
        System.out.println("Max Profit (Example 3): " + solver.maxProfit(prices3)); // 0
    }
}
