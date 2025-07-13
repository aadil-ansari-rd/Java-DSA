import java.util.Stack;

// Name: Eager Enqueue, Lazy Dequeue ----------------------------------------------------------------------------
// Enqueue: O(n)
// Dequeue / Peek: O(1)

class Queue2 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    // Enqueue – O(n)
    public void enqueue(int val) {
        // Step 1: Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Step 2: Push new value into s1
        s1.push(val);

        // Step 3: Push everything back from s2 to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Dequeue – O(1)
    public int dequeue() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.pop();
    }

    // Peek – O(1)
    public int peek() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.peek();
    }

    // Display – O(n)
    public void display() {
        System.out.println(s1); // s1 already holds the queue in correct order
    }

}

// Name: Lazy Enqueue, Eager Dequeue ------------------------------------------------------------------------
// Enqueue: O(1)
// Dequeue / Peek: Amortized O(1), Worst O(n)
// How it works:
// Push all new elements into s1. On dequeue, only when s2 is empty, transfer
// all from
// s1 to s2 to reverse order, then pop from s2.

class Queue1 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    // Enqueue - O(1)
    public void enqueue(int val) {
        s1.push(val); // Simply push into s1
    }

    // Dequeue - Amortized O(1), Worst O(n)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        shiftStacks(); // Transfer only if s2 is empty
        return s2.pop();
    }

    // Peek - Amortized O(1), Worst O(n)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        shiftStacks(); // Transfer only if s2 is empty
        return s2.peek();
    }

    // Display - O(n)
    public void display() {
        // Need to show elements in queue order: s2 (top to bottom) + s1 (bottom to top)
        Stack<Integer> temp = new Stack<>();

        // Print s2 (already in correct order)
        for (int i = s2.size() - 1; i >= 0; i--) {
            temp.push(s2.get(i));
        }

        // Print s1 in reverse
        for (int i = 0; i < s1.size(); i++) {
            temp.push(s1.get(i));
        }

        System.out.println(temp);
    }

    private void shiftStacks() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

}

public class QueueWith2Stack {
    public static void main(String[] args) {

        System.out.println("----- Testing Queue1 (Lazy Enqueue, Eager Dequeue) -----");
        Queue1 q1 = new Queue1();
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.display();                      // Expected: [10, 20, 30]

        System.out.println("Peek: " + q1.peek()); // Expected: 10
        System.out.println("Dequeue: " + q1.dequeue()); // Expected: 10
        q1.display();                      // Expected: [20, 30]

        System.out.println("Dequeue: " + q1.dequeue()); // Expected: 20
        System.out.println("Dequeue: " + q1.dequeue()); // Expected: 30
        System.out.println("Dequeue: " + q1.dequeue()); // Expected: Queue is empty

        System.out.println("\n----- Testing Queue2 (Eager Enqueue, Lazy Dequeue) -----");
        Queue2 q2 = new Queue2();
        q2.enqueue(100);
        q2.enqueue(200);
        q2.enqueue(300);
        q2.display();                      // Expected: [100, 200, 300]

        System.out.println("Peek: " + q2.peek()); // Expected: 100
        System.out.println("Dequeue: " + q2.dequeue()); // Expected: 100
        q2.display();                      // Expected: [200, 300]

        System.out.println("Dequeue: " + q2.dequeue()); // Expected: 200
        System.out.println("Dequeue: " + q2.dequeue()); // Expected: 300
        System.out.println("Dequeue: " + q2.dequeue()); // Expected: Queue is empty
    }
}
