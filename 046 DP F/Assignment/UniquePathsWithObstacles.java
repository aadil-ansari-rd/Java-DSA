public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If starting point is blocked, no paths possible
        if (obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1; // start position

        // Fill first row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0 && dp[0][j - 1] == 1) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0; // blocked path
            }
        }

        // Fill first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0; // blocked path
            }
        }

        // Fill the rest of dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // obstacle cell
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1]; // destination
    }

    // Quick test
    public static void main(String[] args) {
        UniquePathsWithObstacles solver = new UniquePathsWithObstacles();
        int[][] grid1 = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] grid2 = {{0,1},{0,0}};
        System.out.println(solver.uniquePathsWithObstacles(grid1)); // 2
        System.out.println(solver.uniquePathsWithObstacles(grid2)); // 1
    }
}
