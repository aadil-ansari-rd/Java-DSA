import java.util.*;

public class WildcardMatchingTabulation {

    // Returns true if entire pattern p matches entire string s
    public static boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();

        // dp[i][j] = does p[0..i-1] match s[0..j-1] ?
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base: empty pattern matches empty string
        dp[0][0] = true;

        // First column: pattern vs empty string
        // Only possible if pattern prefix is all '*'
        for (int i = 1; i <= m; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0]; // keep using '*' as empty
            } else {
                dp[i][0] = false;        // any non-* breaks the chain
            }
        }

        // Fill the table row by row (pattern index i, string index j)
        for (int i = 1; i <= m; i++) {
            char pc = p.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(j - 1);

                if (pc == '*') {
                    // '*' matches empty  -> dp[i-1][j]
                    // or matches one+    -> dp[i][j-1]
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (pc == '?' || pc == sc) {
                    // Exact or single-char match
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }

    // Optional: helper to visualize DP table for learning/debugging
    private static void printDp(String s, String p, boolean[][] dp) {
        int n = s.length(), m = p.length();
        System.out.println("DP Table (rows=pattern \"" + p + "\", cols=string \"" + s + "\")");
        System.out.print("      ");
        System.out.print("\"\"  ");
        for (int j = 0; j < n; j++) System.out.print(s.charAt(j) + "   ");
        System.out.println();
        for (int i = 0; i <= m; i++) {
            char ch = (i == 0 ? 'ε' : p.charAt(i - 1));
            System.out.printf("%-4s ", ch);
            for (int j = 0; j <= n; j++) {
                System.out.print((dp[i][j] ? "T" : "F") + "   ");
            }
            System.out.println();
        }
    }

    // Wrapper to also return the dp table if you want to inspect it
    public static boolean isMatchWithDpPrint(String s, String p, boolean showTable) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) dp[i][0] = (p.charAt(i - 1) == '*') && dp[i - 1][0];
        for (int i = 1; i <= m; i++) {
            char pc = p.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(j - 1);
                if (pc == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else if (pc == '?' || pc == sc) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = false;
            }
        }
        if (showTable) printDp(s, p, dp);
        return dp[m][n];
    }

    public static void main(String[] args) {
        // A few representative test cases
        String[][] tests = new String[][]{
            {"aa", "a"},          // false
            {"aa", "*"},          // true
            {"cb", "?a"},         // false
            {"adceb", "*a*b"},    // true
            {"acdcb", "a*c?b"},   // false
            {"", "*"},            // true
            {"", "?"},            // false
            {"abcde", "abc*e"},   // true
            {"abc", "***"},       // true
            {"abc", "a?c"},       // true
        };

        for (String[] t : tests) {
            String s = t[0], p = t[1];
            boolean ans = isMatch(s, p);
            System.out.printf("s=\"%s\", p=\"%s\" -> %s%n", s, p, ans);
        }

        // Uncomment to see the DP table for a specific case:
        // isMatchWithDpPrint("adceb", "*a*b", true);
    }
}
