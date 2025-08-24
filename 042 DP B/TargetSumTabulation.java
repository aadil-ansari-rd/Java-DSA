public class TargetSumTabulation {

    // Function to find number of ways to assign signs to reach target
    public static int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // If (target + totalSum) is odd or target > totalSum, no solution
        if ((target + totalSum) % 2 != 0 || Math.abs(target) > totalSum) return 0;

        int subsetSum = (target + totalSum) / 2;
        return countSubsets(nums, subsetSum);
    }

    // Count subsets with given sum using tabulation
    private static int countSubsets(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];

        // Base case: Only 1 way to make sum 0 (choose nothing)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int s = 0; s <= sum; s++) {
                // Exclude current number
                dp[i][s] = dp[i - 1][s];

                // Include current number (if possible)
                if (nums[i - 1] <= s) {
                    dp[i][s] += dp[i - 1][s - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    // Driver code
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        int target = 1;

        int ways = findTargetSumWays(nums, target);
        System.out.println("Number of ways = " + ways);
    }
}
