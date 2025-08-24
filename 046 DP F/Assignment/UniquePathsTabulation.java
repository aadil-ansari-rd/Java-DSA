public class UniquePathsTabulation {
    
    public int uniquePaths(int m, int n) {
        // DP table to store number of ways to reach each cell
        int[][] dp = new int[m][n];
        
        // Fill first row and first column with 1
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        
        // Fill remaining cells using transition relation
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        // Answer is in bottom-right corner
        return dp[m - 1][n - 1];
    }

    // Example run
    public static void main(String[] args) {
        UniquePathsTabulation solver = new UniquePathsTabulation();
        System.out.println(solver.uniquePaths(3, 7)); // Output: 28
        System.out.println(solver.uniquePaths(3, 2)); // Output: 3
    }
}
