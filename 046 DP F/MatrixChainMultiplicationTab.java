public class MatrixChainMultiplicationTab {

    // Bottom-up tabulation approach
    public static int matrixChainOrder(int[] arr, int n) {
        int[][] dp = new int[n][n];

        // dp[i][i] = 0 (single matrix cost is zero)
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // L is the chain length
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try all partitions
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int n = arr.length;

        int result = matrixChainOrder(arr, n);
        System.out.println("Minimum number of multiplications: " + result);
    }
}

