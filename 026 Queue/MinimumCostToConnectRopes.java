import java.util.PriorityQueue;

public class MinimumCostToConnectRopes {

    // Function to return minimum cost of connecting ropes
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all rope lengths into the min-heap
        for (int rope : arr) {
            minHeap.add(rope);
        }

        int totalCost = 0;

        // Continue until we have one rope left
        while (minHeap.size() > 1) {
            // Take two smallest ropes
            int first = minHeap.poll();
            int second = minHeap.poll();

            int cost = first + second;
            totalCost += cost;

            // Push the combined rope back
            minHeap.add(cost);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        System.out.println(minCost(arr));  // Output: 29
    }
}
