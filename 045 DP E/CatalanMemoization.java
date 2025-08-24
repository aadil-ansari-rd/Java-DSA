import java.util.Arrays;

public class CatalanMemoization {

    // Recursive + Memoization function
    public static int catalan(int n, int[] dp) {
        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }

        // Return already computed value
        if (dp[n] != -1) {
            return dp[n];
        }

        int result = 0;

        // Apply recursive formula with memoization
        for (int i = 0; i < n; i++) {
            result += catalan(i, dp) * catalan(n - i - 1, dp);
        }

        // Store the result
        dp[n] = result;
        return result;
    }

    // Driver method
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println("Catalan number for n = " + n + " is " + catalan(n, dp));
    }
}
