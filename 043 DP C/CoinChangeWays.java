import java.util.*;

public class CoinChangeWays {
    public static int countWays(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Base case: one way to make amount 0 (by choosing nothing)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Build table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // Exclude the current coin
                dp[i][j] = dp[i - 1][j];
                
                // Include the current coin if possible
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }

    // Main method to test
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println("Total Ways: " + countWays(coins, amount));
    }
}
