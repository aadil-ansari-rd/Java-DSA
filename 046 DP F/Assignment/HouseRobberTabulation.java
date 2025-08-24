public class HouseRobberTabulation {
    public int rob(int[] nums) {
        int n = nums.length;
        
        // Base cases
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        // dp[i] stores max money robbed up to i-th house
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        // Fill dp table
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        
        // The last entry has the result
        return dp[n-1];
    }

    // Main method to test
    public static void main(String[] args) {
        HouseRobberTabulation robber = new HouseRobberTabulation();
        int[] houses1 = {1,2,3,1};
        int[] houses2 = {2,7,9,3,1};
        
        System.out.println("Max money (example 1): " + robber.rob(houses1)); // 4
        System.out.println("Max money (example 2): " + robber.rob(houses2)); // 12
    }
}
