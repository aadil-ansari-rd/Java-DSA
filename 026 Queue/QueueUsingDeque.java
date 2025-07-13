import java.util.ArrayDeque;
import java.util.Deque;

class Queue1 {
    // Using Deque to implement Queue (FIFO: front = head, rear = tail)
    Deque<Integer> dq = new ArrayDeque<>();

    // Check if the queue is empty
    public boolean isEmpty() {
        return dq.isEmpty();
    }

    // Enqueue: Add element to the rear of the queue
    public void enqueue(int val) {
        dq.offerLast(val);
    }

    // Dequeue: Remove and return element from the front of the queue
    public int dequeue() {
        return dq.pollFirst();
    }

    // Peek: Return the front element without removing it
    public int peek() {
        return dq.peekFirst();
    }

    // Display all elements from front to rear
    public void display() {
        System.out.println(dq);
    }
}

public class QueueUsingDeque {
    public static void main(String[] args) {
        Queue1 q = new Queue1();

        // Enqueue some elements
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        // Display current queue
        System.out.print("Queue: ");
        q.display();  // Output: [10, 20, 30]

        // Peek at front element
        System.out.println("Front element (peek): " + q.peek()); // 10

        // Dequeue two elements
        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Dequeued: " + q.dequeue()); // 20

        // Display queue after dequeues
        System.out.print("Queue after dequeues: ");
        q.display(); // Output: [30]

        // Check if empty
        System.out.println("Is queue empty? " + q.isEmpty()); // false

        // Dequeue last element
        System.out.println("Dequeued: " + q.dequeue()); // 30
        System.out.println("Is queue empty now? " + q.isEmpty()); // true
    }
}
