public class KnapsackRecursive {

    // Recursive function to solve 0-1 Knapsack
    public static int knapSack(int capacity, int[] weights, int[] values, int n) {
        // Base case: no items left or capacity is 0
        if (n == 0 || capacity == 0) {
            return 0;
        }

        // If weight of the current item is more than capacity, skip it
        if (weights[n - 1] > capacity) {
            return knapSack(capacity, weights, values, n - 1);
        }

        // Case 1: Include the item
        int include = values[n - 1] + knapSack(capacity - weights[n - 1], weights, values, n - 1);

        // Case 2: Exclude the item
        int exclude = knapSack(capacity, weights, values, n - 1);

        // Return the max of including or excluding
        return Math.max(include, exclude);
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] values = {3, 4, 5, 6};
        int[] weights = {2, 3, 4, 5};
        int capacity = 5;
        int n = values.length;

        int maxValue = knapSack(capacity, weights, values, n);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
