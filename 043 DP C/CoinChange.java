import java.util.*;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // DP array to store minimum coins for each amount
        int[] dp = new int[amount + 1];
        
        // Fill with a large value (infinity representation)
        Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins needed to make amount 0
        dp[0] = 0;
        
        // Build solution bottom-up
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If value is still large, means not possible
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // Main method to test
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Minimum coins needed: " + coinChange(coins, amount));
    }
}
