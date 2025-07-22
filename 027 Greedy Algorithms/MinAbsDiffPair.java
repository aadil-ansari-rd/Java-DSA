import java.util.Arrays;

public class MinAbsDiffPair {
    // Method to find minimum absolute difference
    public static int minAbsDiff(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE; // initialize to maximum

        // Step 2: Traverse and check consecutive differences
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1]; // absolute difference between adjacent elements
            minDiff = Math.min(minDiff, diff); // update minimum
        }

        return minDiff;
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 8};
        System.out.println("Minimum Absolute Difference: " + minAbsDiff(arr));
    }
}
