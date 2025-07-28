import java.util.*;

public class SlidingWindowMaxHeap {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Max Heap storing (value, index)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            // Add current element and its index
            maxHeap.add(new int[]{nums[i], i});

            // Remove elements outside the current window
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }

            // If window is ready, add the current max to result
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }

        return result;
    }

    // Extended main method to test multiple inputs
    public static void main(String[] args) {
        SlidingWindowMaxHeap obj = new SlidingWindowMaxHeap();

        int[][] testArrays = {
            {1, 3, -1, -3, 5, 3, 6, 7},  // Expected: [3, 3, 5, 5, 6, 7]
            {9, 11},                    // Expected: [11]
            {4, -2},                    // Expected: [4]
            {1},                        // Expected: [1]
            {7, 2, 4}                   // Expected: [7, 4]
        };
        int[] ks = {3, 2, 2, 1, 2};

        for (int i = 0; i < testArrays.length; i++) {
            int[] result = obj.maxSlidingWindow(testArrays[i], ks[i]);
            System.out.println("Input: " + Arrays.toString(testArrays[i]) + ", k = " + ks[i]);
            System.out.println("Max Sliding Window: " + Arrays.toString(result) + "\n");
        }
    }
}
