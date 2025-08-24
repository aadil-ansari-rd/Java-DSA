import java.util.*;

public class RodCutting {
    public static int rodCutting(int[] price, int n) {
        // dp[i] will store max profit for rod of length i
        int[] dp = new int[n + 1];

        // Bottom-up calculation
        for (int i = 1; i <= n; i++) {
            int maxProfit = Integer.MIN_VALUE;
            // Try every cut length j (1 to i)
            for (int j = 1; j <= i; j++) {
                maxProfit = Math.max(maxProfit, price[j - 1] + dp[i - j]);
            }
            dp[i] = maxProfit;
        }
        return dp[n];
    }

    // Main method to test
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println("Maximum Profit: " + rodCutting(price, n));
    }
}
