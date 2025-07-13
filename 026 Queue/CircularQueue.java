// Circular Queue implementation using Array
class Queue {
    int[] queue; // Array to hold the elements of the queue
    int size; // Maximum size of the queue
    int front, rear; // Indices for front and rear positions

    // Constructor to initialize the queue with given capacity
    Queue(int capacity) {
        size = capacity;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Check if the queue is full
    public boolean isFull() {
        // Queue is full if the next position of rear is front
        return (rear + 1) % size == front;
    }

    // Insert element at the rear of the queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        // First insertion, initialize both front and rear to 0
        if (isEmpty()) {
            rear = front = 0;
        } else {
            // Move rear to the next position in circular manner
            rear = (rear + 1) % size;
        }
        // Insert the new element
        queue[rear] = value;
    }

    // Remove element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int result = queue[front]; // Store the value to return

        // If only one element was in the queue, reset both pointers
        if (front == rear) {
            front = rear = -1;
        } else {
            // Move front to the next position in circular manner
            front = (front + 1) % size;
        }
        return result;
    }

    // Return the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    // Display all elements from front to rear
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        int i = front;
        while (true) {
            System.out.print(queue[i] + " "); // Print current element
            if (i == rear)
                break; // Stop at rear
            i = (i + 1) % size; // Move to next circular index
        }
        System.out.println();
    }
}

public class CircularQueue {
    public static void main(String[] args) {
        Queue q = new Queue(5); // Capacity 5

        // Test 1: Enqueue elements
        System.out.println("Enqueue 10, 20, 30:");
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // Output: 10 20 30

        // Test 2: Dequeue one element
        System.out.println("Dequeue:");
        System.out.println("Removed: " + q.dequeue()); // Output: 10
        q.display(); // Output: 20 30

        // Test 3: Wrap around case
        System.out.println("Enqueue 40, 50, 60:");
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60); // Should wrap and fill rear at front
        q.display(); // Output: 20 30 40 50 60

        // Test 4: Queue is full
        q.enqueue(70); // Should say queue is full

        // Test 5: Peek
        System.out.println("Front element is: " + q.peek()); // Output: 20

        // Test 6: Dequeue all
        System.out.println("Dequeuing all:");
        while (!q.isEmpty()) {
            System.out.println("Removed: " + q.dequeue());
        }
        q.display(); // Should say queue is empty

        // Test 7: Enqueue after reset
        System.out.println("Reusing queue after emptying:");
        q.enqueue(100);
        q.enqueue(200);
        q.display(); // Output: 100 200
    }
}
