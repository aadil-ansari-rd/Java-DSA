public class LCSTabulation {

    // Function to compute LCS length using Tabulation
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // DP table (n+1) x (m+1)
        int[][] dp = new int[n + 1][m + 1];

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If characters match
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Take maximum by skipping one character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Final answer is in dp[n][m]
        return dp[n][m];
    }

    // Main function to test
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        int lcsLength = longestCommonSubsequence(text1, text2);
        System.out.println("Length of LCS: " + lcsLength); // Output: 3
    }
}
