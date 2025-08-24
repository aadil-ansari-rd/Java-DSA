public class CatalanTabulation {

    // Function to compute nth Catalan number using Tabulation
    public static int catalan(int n) {
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        // Bottom-up filling of dp array
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    // Driver method
    public static void main(String[] args) {
        int n = 6;
        System.out.println("Catalan number for n = " + n + " is " + catalan(n));
    }
}
