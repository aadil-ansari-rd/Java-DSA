// Queue implementation using array
class Queue {
    int[] queue;      // Array to store queue elements
    int size;         // Maximum capacity of the queue
    int front, rear;  // Pointers for front and rear of the queue

    // Constructor to initialize queue with given capacity
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
        return rear == size - 1;
    }

    // Enqueue operation - O(1)
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        // If queue was empty, initialize front to 0
        if (isEmpty()) {
            front++;
        }
        // Insert the element and increment rear
        queue[++rear] = value;
    }

    // Dequeue operation (front removal) - O(1)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        // Remove element at front and increment front pointer
        int value = queue[front++];
        
        // If queue becomes empty after removal, reset pointers
        if (front > rear) {
            front = -1;
            rear = -1;
        }
        return value;
    }

    // Dequeue operation with element shifting - O(n)
    public int dequeue2() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        int value = queue[front];  // Store front element to return

        // Shift all elements one step to the left
        for (int i = front + 1; i <= rear; i++) {
            queue[i - 1] = queue[i];
        }

        rear--;  // Decrease rear since one element is removed

        // If queue becomes empty, reset front and rear
        if (rear < front) {
            front = -1;
            rear = -1;
        }

        return value;
    }

    // Peek operation to return front element - O(1)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }

    // Display all elements from front to rear - O(n)
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class QueueArray {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        System.out.println("Enqueue 10, 20, 30:");
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // 10 20 30

        System.out.println("Dequeue (O(1)):");
        System.out.println("Removed: " + q.dequeue()); // 10
        q.display(); // 20 30

        System.out.println("Peek:-");
        System.out.println("Front: " + q.peek()); // 20

        System.out.println("Using dequeue2 (O(n)):");
        System.out.println("Removed: " + q.dequeue2()); // 20
        q.display(); // 30

        System.out.println("Filling Queue:");
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        q.enqueue(70); // should print full
        q.display(); // 30 40 50 60

        System.out.println("Emptying queue completely:");
        while (!q.isEmpty()) {
            System.out.println("Removed: " + q.dequeue());
        }
        q.display(); // should print empty

        System.out.println("Test complete.");
    }
}