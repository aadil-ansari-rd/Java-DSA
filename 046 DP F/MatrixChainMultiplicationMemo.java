import java.util.Arrays;

public class MatrixChainMultiplicationMemo {

    // Recursive function with memoization
    public static int solve(int[] arr, int i, int j, int[][] dp) {
        if (i == j) return 0; // only one matrix

        if (dp[i][j] != -1) return dp[i][j]; // already solved

        int minCost = Integer.MAX_VALUE;

        // Try every partition
        for (int k = i; k < j; k++) {
            int cost = solve(arr, i, k, dp) +
                       solve(arr, k + 1, j, dp) +
                       (arr[i - 1] * arr[k] * arr[j]);

            minCost = Math.min(minCost, cost);
        }

        return dp[i][j] = minCost; // store result
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int n = arr.length;

        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = solve(arr, 1, n - 1, dp);
        System.out.println("Minimum number of multiplications: " + result);
    }
}
