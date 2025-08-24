public class UnboundedKnapsackTabulation {

    // Function to solve Unbounded Knapsack using tabulation
    public static int unboundedKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                // Exclude current item
                dp[i][w] = dp[i - 1][w];

                // Include current item (if it fits)
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i][w], values[i - 1] + dp[i][w - weights[i - 1]]);
                }
            }
        }

        return dp[n][capacity]; // Final answer
    }

    // Driver code
    public static void main(String[] args) {
        int[] weights = {2, 4, 6};
        int[] values = {5, 11, 13};
        int capacity = 10;

        int maxValue = unboundedKnapsack(weights, values, capacity);
        System.out.println("Maximum value in Unbounded Knapsack = " + maxValue);
    }
}
