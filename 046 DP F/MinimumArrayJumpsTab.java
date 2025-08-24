import java.util.Arrays;

public class MinimumArrayJumpsTab {

    public static int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // starting point, no jumps needed

        // Build dp table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 1, 4};
        int[] arr2 = {1, 1, 1, 1, 1};

        System.out.println("Minimum jumps for arr1: " + minJumps(arr1)); // Output: 2
        System.out.println("Minimum jumps for arr2: " + minJumps(arr2)); // Output: 4
    }
}
