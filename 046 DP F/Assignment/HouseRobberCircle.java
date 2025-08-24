public class HouseRobberCircle {

    // Function to calculate House Robber I result for a linear array
    private int robLinear(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 1) return nums[start]; // only one house

        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[n - 1];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // only one house, must rob it

        // Case 1: exclude last house
        int case1 = robLinear(nums, 0, n - 2);

        // Case 2: exclude first house
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    // Main function to test the solution
    public static void main(String[] args) {
        HouseRobberCircle solver = new HouseRobberCircle();
        
        int[] nums1 = {2, 3, 2};
        System.out.println("Max rob for [2,3,2]: " + solver.rob(nums1)); // Output: 3

        int[] nums2 = {1, 2, 3, 1};
        System.out.println("Max rob for [1,2,3,1]: " + solver.rob(nums2)); // Output: 4

        int[] nums3 = {1, 2, 3};
        System.out.println("Max rob for [1,2,3]: " + solver.rob(nums3)); // Output: 3
    }
}
