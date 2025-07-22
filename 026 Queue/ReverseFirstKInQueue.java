import java.util.Stack;
import java.util.Queue;
import java.util.*;

public class ReverseFirstKInQueue {

    // Function to reverse first k elements of a queue
    public static void reverseFirstK(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push first k elements into stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Step 2: Enqueue back elements from stack (reversed)
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Step 3: Move the remaining elements to the back
        int size = queue.size();
        for (int i = 0; i < size - k; i++) {
            queue.add(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));
        int k = 5;
        reverseFirstK(queue, k);
        System.out.println(queue); // Output: [50, 40, 30, 20, 10, 60, 70, 80, 90, 100]
    }
}
