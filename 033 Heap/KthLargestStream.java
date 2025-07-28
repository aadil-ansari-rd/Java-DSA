import java.util.PriorityQueue;

public class KthLargestStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        
        // Add initial stream elements
        for (int num : nums) {
            add(num);
        }
    }

    // Adds a new number and returns the kth largest
    public int add(int val) {
        minHeap.add(val); // Add new value

        // If size > k, remove the smallest
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Return kth largest, i.e., root of heap
        return minHeap.peek();
    }

    // Test it
    public static void main(String[] args) {
        int k = 3;
        int[] initial = {4, 5, 8, 2};
        KthLargestStream stream = new KthLargestStream(k, initial);

        System.out.println(stream.add(3));  // Output: 4
        System.out.println(stream.add(5));  // Output: 5
        System.out.println(stream.add(10)); // Output: 5
        System.out.println(stream.add(9));  // Output: 8
        System.out.println(stream.add(4));  // Output: 8
    }
}
