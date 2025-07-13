import java.util.*;

public class DequeJCF {
    public static void main(String[] args) {
        // Declare Deque using ArrayDeque
        Deque<Integer> dq = new ArrayDeque<>();

        // Add elements
        dq.addFirst(10); // add at front
        dq.addLast(20);  // add at rear
        dq.offerFirst(5); // add at front (alternative method)
        dq.offerLast(25); // add at rear

        // Display deque
        System.out.println("Deque: " + dq); // [5, 10, 20, 25]

        // Remove elements
        dq.removeFirst();  // removes 5
        dq.removeLast();   // removes 25

        // Peek elements
        System.out.println("Front: " + dq.peekFirst()); // 10
        System.out.println("Rear: " + dq.peekLast());   // 20

        // Final deque
        System.out.println("Final Deque: " + dq); // [10, 20]
    }
}
