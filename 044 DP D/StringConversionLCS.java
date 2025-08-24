public class StringConversionLCS {
    
    // Function to find LCS length using tabulation
    public static int LCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // skip one char
                }
            }
        }
        return dp[n][m]; // final LCS length
    }

    // Function to calculate minimum operations
    public static int stringConversion(String s1, String s2) {
        int lcs = LCS(s1, s2); // get LCS length
        int deletions = s1.length() - lcs;
        int insertions = s2.length() - lcs;
        return deletions + insertions;
    }

    // Main function to test
    public static void main(String[] args) {
        String s1 = "heap";
        String s2 = "pea";
        System.out.println("Minimum operations: " + stringConversion(s1, s2));
    }
}
