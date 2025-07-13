// Node class to store data and link to next node
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data; // Store the value
        this.next = null; // Next will point to the next node
    }
}

// Queue class using singly linked list
class Queue {
    Node head, tail; // 'head' is front of the queue, 'tail' is rear

    Queue() {
        head = tail = null;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Check if queue is full (not applicable in linked list)
    public boolean isFull() {
        return false; // Always false since linked list is dynamic
    }

    // Enqueue operation: add element at the rear (tail)
    public void enqueue(int value) {
        Node newNode = new Node(value); // Create new node

        // If queue is empty, both head and tail point to the new node
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }

        // Else, link current tail to new node and move tail forward
        tail.next = newNode;
        tail = newNode;
    }

    // Dequeue operation: remove element from front (head)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        int result = head.data; // Store data to return

        // If only one element was in queue
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next; // Move head to next node
        }
        return result;
    }

    // Peek operation: return front element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return head.data;
    }

    // Display all elements from front to rear
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " "); // Print current node's data
            temp = temp.next; // Move to next node
        }
        System.out.println(); // For new line after printing queue
    }
}

public class QueueLinkedList {
    public static void main(String[] args) {
        Queue q = new Queue();

        System.out.println("Enqueue 10, 20, 30:");
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // Output: 10 20 30

        System.out.println("Peek front element:");
        System.out.println("Front: " + q.peek()); // Output: 10

        System.out.println("Dequeue one element:");
        System.out.println("Removed: " + q.dequeue()); // Output: 10
        q.display(); // Output: 20 30

        System.out.println("Dequeue all elements:");
        System.out.println("Removed: " + q.dequeue()); // 20
        System.out.println("Removed: " + q.dequeue()); // 30
        q.display(); // Should say nothing (empty)

        System.out.println("Try dequeue on empty queue:");
        q.dequeue(); // Should print "Queue is empty."

        System.out.println("Try peek on empty queue:");
        q.peek(); // Should print "Queue is empty."

        System.out.println("Add elements again after empty:");
        q.enqueue(100);
        q.enqueue(200);
        q.display(); // Output: 100 200
    }
}
