public class TargetSumSubsetTabulation {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: sum = 0 is always true
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // Exclude current element
                dp[i][j] = dp[i - 1][j];

                // Include current element if possible
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][target];
    }

    // Main method to test
    public static void main(String[] args) {
        TargetSumSubsetTabulation solver = new TargetSumSubsetTabulation();

        int[] arr1 = {2, 3, 7, 8, 10};
        System.out.println("Target 11 possible? " + solver.isSubsetSum(arr1, 11)); // true

        int[] arr2 = {1, 2, 3};
        System.out.println("Target 7 possible? " + solver.isSubsetSum(arr2, 7)); // false

        int[] arr3 = {1, 5, 11, 5};
        System.out.println("Target 11 possible? " + solver.isSubsetSum(arr3, 11)); // true
    }
}
