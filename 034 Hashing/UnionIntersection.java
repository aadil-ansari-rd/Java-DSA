import java.util.HashSet;

public class UnionIntersection {
    
    // Function to return count of union elements
    public static int getUnionCount(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        // Add all elements from arr1
        for (int num : arr1) {
            set.add(num);
        }

        // Add all elements from arr2
        for (int num : arr2) {
            set.add(num);
        }

        // Size of set gives number of unique elements (union)
        return set.size();
    }

    // Function to return count of intersection elements
    public static int getIntersectionCount(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        // Add elements of first array to set1
        for (int num : arr1) {
            set1.add(num);
        }

        // Check each element of second array
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);  // Store only once
            }
        }

        // Size of intersection set
        return intersection.size();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        System.out.println("Union Count: " + getUnionCount(arr1, arr2));           // Output: 7
        System.out.println("Intersection Count: " + getIntersectionCount(arr1, arr2)); // Output: 2
    }
}
