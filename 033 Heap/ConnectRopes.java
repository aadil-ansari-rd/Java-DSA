import java.util.*;

public class ConnectRopes {

    public static int minCost(int[] ropes) {
        // Step 1: Add all ropes to Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropes) {
            minHeap.add(rope);
        }

        int totalCost = 0;

        // Step 2: Keep combining two smallest ropes
        while (minHeap.size() > 1) {
            int first = minHeap.poll();  // Smallest
            int second = minHeap.poll(); // Second smallest
            int cost = first + second;   // Combine

            totalCost += cost;           // Accumulate cost
            minHeap.add(cost);           // Add back to heap
        }

        return totalCost;
    }

    // Main method with multiple test cases
    public static void main(String[] args) {
        int[][] testCases = {
            {4, 3, 2, 6},      // Expected: 29
            {1, 2, 3, 4, 5},   // Expected: 33
            {5, 17, 100, 11},  // Expected: 182
            {8},               // Expected: 0 (only one rope)
            {}                 // Expected: 0 (empty input)
        };

        for (int i = 0; i < testCases.length; i++) {
            int cost = minCost(testCases[i]);
            System.out.println("Test " + (i + 1) + " - Ropes: " + Arrays.toString(testCases[i]));
            System.out.println("Minimum cost: " + cost + "\n");
        }
    }
}
