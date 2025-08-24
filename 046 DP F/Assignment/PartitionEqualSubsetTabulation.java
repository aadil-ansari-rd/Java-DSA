public class PartitionEqualSubsetTabulation {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If sum is odd, partition not possible
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Base case: sum 0 always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j]; // exclude current

                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]]; // include current
                }
            }
        }

        return dp[n][target];
    }

    // Main method to test
    public static void main(String[] args) {
        PartitionEqualSubsetTabulation solver = new PartitionEqualSubsetTabulation();

        int[] nums1 = {1, 5, 11, 5};
        System.out.println("Can partition [1,5,11,5]? " + solver.canPartition(nums1)); // true

        int[] nums2 = {1, 2, 3, 5};
        System.out.println("Can partition [1,2,3,5]? " + solver.canPartition(nums2)); // false

        int[] nums3 = {2, 2, 3, 5};
        System.out.println("Can partition [2,2,3,5]? " + solver.canPartition(nums3)); // false
    }
}
