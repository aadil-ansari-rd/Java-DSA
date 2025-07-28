import java.util.ArrayList;

// Min Heap implementation using ArrayList

class Heap1 {
    // Internal ArrayList to store heap elements
    ArrayList<Integer> arr = new ArrayList<>();

    // -------------------- Add Element to Min-Heap --------------------
    public void add(int data) {
        // Step 1: Add new data at the end
        arr.add(data);

        // Step 2: Get index of newly added element
        int x = arr.size() - 1;
        int pIdx = (x - 1) / 2; // Parent index

        // Step 3: Upheapify (bubble up) — while child is smaller than parent
        while (x > 0 && arr.get(x) < arr.get(pIdx)) {
            // Swap child with parent
            int temp = arr.get(x);
            arr.set(x, arr.get(pIdx));
            arr.set(pIdx, temp);

            // Move up in the tree
            x = pIdx;
            pIdx = (x - 1) / 2;
        }
    }

    // -------------------- Peek Minimum Element --------------------
    public int peek() {
        // Return the root element (minimum in Min-Heap)
        return arr.get(0);
    }

    // -------------------- Remove Minimum Element --------------------
    public int remove() {
        // Step 1: Store the root element (min)
        int data = arr.get(0);

        // Step 2: Replace root with last element
        int lastIdx = arr.size() - 1;
        arr.set(0, arr.get(lastIdx));
        arr.remove(lastIdx); // Remove the last element

        // Step 3: Restore heap property using downheapify
        heapify(0);

        // Return the removed min element
        return data;
    }

    // -------------------- Heapify (Downheapify) --------------------
    private void heapify(int i) {
        int left = 2 * i + 1;  // Left child index
        int right = 2 * i + 2; // Right child index
        int minIdx = i;        // Assume current node is smallest

        // Check if left child is smaller
        if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
            minIdx = left;
        }

        // Check if right child is smaller
        if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
            minIdx = right;
        }

        // If a smaller child exists, swap and continue downheapify
        if (minIdx != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(minIdx));
            arr.set(minIdx, temp);

            // Recursive call on the smaller child
            heapify(minIdx);
        }
    }

    // -------------------- Check if Heap is Empty --------------------
    public boolean isEmpty() {
        return arr.size() == 0;
    }
}

public class MinHeap {
    public static void main(String[] args) {
        Heap1 heap = new Heap1();

        // Test 1: isEmpty() before any insertion
        System.out.println("Is heap empty? " + heap.isEmpty());  // Expected: true

        // Test 2: Add elements to the heap
        int[] input = {40, 10, 30, 50, 20};
        for (int val : input) {
            heap.add(val);
        }

        // Test 3: Peek min element
        System.out.println("Minimum element (peek): " + heap.peek());  // Expected: 10

        // Test 4: Remove all elements one by one
        System.out.print("Heap elements in sorted (ascending) order: ");
        while (!heap.isEmpty()) {
            System.out.print(heap.remove() + " ");
        }
        // Expected Output: 10 20 30 40 50

        // Test 5: Check heap after all elements are removed
        System.out.println("\nIs heap empty after removals? " + heap.isEmpty());  // Expected: true

        // Test 6: Edge case - peek/remove on empty heap
        try {
            heap.peek();
        } catch (Exception e) {
            System.out.println("Peek on empty heap threw: " + e.getClass().getSimpleName());
        }

        try {
            heap.remove();
        } catch (Exception e) {
            System.out.println("Remove on empty heap threw: " + e.getClass().getSimpleName());
        }
    }
}
