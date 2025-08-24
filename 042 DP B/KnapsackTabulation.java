public class KnapsackTabulation {

    // Bottom-up tabulation method
    public static int knapSack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1]; // dp[i][w] = max value using first i items

        // Build dp table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                // Exclude current item
                int exclude = dp[i - 1][w];

                // Include current item (if it fits)
                int include = 0;
                if (weights[i - 1] <= w) {
                    include = values[i - 1] + dp[i - 1][w - weights[i - 1]];
                }

                // Store best of include or exclude
                dp[i][w] = Math.max(include, exclude);
            }
        }

        return dp[n][capacity]; // Final answer
    }

    // Driver code
    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        int capacity = 7;

        int maxValue = knapSack(weights, values, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
