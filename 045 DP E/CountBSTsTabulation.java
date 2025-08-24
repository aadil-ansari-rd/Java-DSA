public class CountBSTsTabulation {

    // Function to count number of unique BSTs using Tabulation
    public static int countBST(int n) {
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1;  // empty tree
        dp[1] = 1;  // single node tree

        // Bottom-up computation
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    // Driver method
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Number of unique BSTs with " + n + " nodes is " + countBST(n));
    }
}
