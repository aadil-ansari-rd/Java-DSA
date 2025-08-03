import java.util.HashMap;

public class LargestZeroSumSubarray {

    public static int maxLen(int[] arr) {
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Case 1: If sum becomes 0, subarray from 0 to i
            if (sum == 0) {
                maxLen = i + 1;
            }

            // Case 2: If sum seen before, subarray from previous index + 1 to i
            if (sumIndexMap.containsKey(sum)) {
                int prevIndex = sumIndexMap.get(sum);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                // Store first occurrence of this sum
                sumIndexMap.put(sum, i);
            }
        }

        return maxLen;
    }

    // Test the function
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of largest 0 sum subarray: " + maxLen(arr)); // Output: 5
    }
}
