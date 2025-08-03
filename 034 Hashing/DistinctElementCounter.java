import java.util.HashSet;

public class DistinctElementCounter {
    public static int countDistinct(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        // Add all elements to the HashSet (duplicates will be ignored)
        for (int num : arr) {
            set.add(num);
        }

        // Return the size of the HashSet (i.e., count of unique elements)
        return set.size();
    }

    // Test the function
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 1};
        int distinctCount = countDistinct(arr);
        System.out.println("Total distinct elements: " + distinctCount); // Output: 4
    }
}
