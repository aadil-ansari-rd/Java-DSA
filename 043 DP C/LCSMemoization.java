import java.util.Arrays;

public class LCSMemoization {

    // Function to find LCS length using memoization
    public static int lcs(String s1, String s2, int i, int j, int[][] dp) {
        // Base case: if one string is empty
        if (i == 0 || j == 0) {
            return 0;
        }

        // If already calculated, return stored value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If characters match
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = 1 + lcs(s1, s2, i - 1, j - 1, dp);
        } else {
            // If not match, take max of skipping one from either string
            dp[i][j] = Math.max(
                lcs(s1, s2, i - 1, j, dp),
                lcs(s1, s2, i, j - 1, dp)
            );
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        int n = s1.length();
        int m = s2.length();

        // Initialize dp with -1
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = lcs(s1, s2, n, m, dp);
        System.out.println("Length of LCS: " + result);
    }
}
