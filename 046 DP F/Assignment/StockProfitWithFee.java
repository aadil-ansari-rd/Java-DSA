public class StockProfitWithFee {

    // Function to calculate maximum profit with transaction fee
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        // dp[i][0] -> max profit on day i with no stock in hand
        // dp[i][1] -> max profit on day i with stock in hand
        int[][] dp = new int[n][2];

        // Base case initialization
        dp[0][0] = 0;               // not holding any stock at start
        dp[0][1] = -prices[0];      // if we buy stock on first day

        // Fill dp table
        for (int i = 1; i < n; i++) {
            // If not holding stock on day i:
            // either we did nothing (carry forward) OR we sold today
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);

            // If holding stock on day i:
            // either we did nothing (carry forward) OR we bought today
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        // Answer will be max profit on last day with no stock
        return dp[n-1][0];
    }

    // Main function to test
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        int result = maxProfit(prices, fee);
        System.out.println("Maximum Profit with fee: " + result);
    }
}
