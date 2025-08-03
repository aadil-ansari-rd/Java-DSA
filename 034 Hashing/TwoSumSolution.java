import java.util.*;

public class TwoSumSolution {
    public static int[] twoSum(int[] arr, int target) {
        // Map to store value → index
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Check if complement is already in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i }; // Found the pair
            }

            // Otherwise, store current value with index
            map.put(arr[i], i);
        }

        // If no pair is found (though problem guarantees one)
        return new int[] {};
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(arr, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }
}
