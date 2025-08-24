public class MountainArrayRemovalsTabulation {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];

        // Step 1: LIS (from left)
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Step 2: LDS (from right, computed as LIS in reverse)
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Step 3: Find longest mountain
        int maxMountain = 0;
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) { // valid peak
                maxMountain = Math.max(maxMountain, lis[i] + lds[i] - 1);
            }
        }

        return n - maxMountain; // minimum removals
    }

    // Main method to test
    public static void main(String[] args) {
        MountainArrayRemovalsTabulation solver = new MountainArrayRemovalsTabulation();

        int[] nums1 = {2, 1, 1, 5, 6, 2, 3, 1};
        System.out.println("Minimum removals (Example 1): " + solver.minimumMountainRemovals(nums1)); // 3

        int[] nums2 = {4, 3, 2, 1, 1, 2, 3, 1};
        System.out.println("Minimum removals (Example 2): " + solver.minimumMountainRemovals(nums2)); // 4

        int[] nums3 = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println("Minimum removals (Example 3): " + solver.minimumMountainRemovals(nums3)); // 1
    }
}
