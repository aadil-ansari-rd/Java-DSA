public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;

        // Step 1: Every element itself is an LIS of length 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Step 2: Build LIS using tabulation
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]); // track global max
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + lengthOfLIS(nums));
        // Output: 4
    }
}
