public class TribonacciTabulation {

    // Method to calculate nth Tribonacci number using tabulation
    public int tribonacci(int n) {
        // Handle base cases directly
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // DP array to store results
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        // Fill the dp array iteratively
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n]; // Final answer
    }

    // Main method for testing
    public static void main(String[] args) {
        TribonacciTabulation obj = new TribonacciTabulation();
        System.out.println("T(4) = " + obj.tribonacci(4));   // Expected 4
        System.out.println("T(25) = " + obj.tribonacci(25)); // Expected 1389537
    }
}
