public class TribonacciMemoization {

    public int tribonacci(int n) {
        int[] dp = new int[n + 1]; // store subproblem results
        for (int i = 0; i <= n; i++) {
            dp[i] = -1; // initialize with -1 (not calculated)
        }
        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // If already calculated, return
        if (dp[n] != -1) {
            return dp[n];
        }

        // Recursively calculate and store
        dp[n] = solve(n - 1, dp) + solve(n - 2, dp) + solve(n - 3, dp);
        return dp[n];
    }

    // Example run
    public static void main(String[] args) {
        TribonacciMemoization obj = new TribonacciMemoization();
        System.out.println("Tribonacci(4): " + obj.tribonacci(4));  // Output: 4
        System.out.println("Tribonacci(25): " + obj.tribonacci(25)); // Output: 1389537
    }
}
