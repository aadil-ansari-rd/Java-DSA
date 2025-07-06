class Node {
    public int data;
    public Node next;
    public Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    Node head, tail;

    // -------------------------------------------------------------------------------------------------------
    // Size of doubly linked list
    public int getSize() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }
    // -------------------------------------------------------------------------------------------------------

    // Print Linked List
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // -------------------------------------------------------------------------------------------------------
    // Add First
    public void addFirst(int data) {
        // Create a new node with the given data
        Node newNode = new Node(data);
        // If the list is empty, set both head and tail to the new node
        if (head == null) {
            head = tail = newNode;
        } else {
            // Link the new node to the current head
            newNode.next = head;
            // Link the current head back to the new node
            head.prev = newNode;
            // Update the head to the new node
            head = newNode;
        }
    }

    // -------------------------------------------------------------------------------------------------------
    // Add Last
    public void addLast(int data) {
        // Create a new node with the given data
        Node newNode = new Node(data);
        // If the list is empty, set both head and tail to the new node
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // Link the current tail to the new node
        tail.next = newNode;
        // Link the new node back to the current tail
        newNode.prev = tail;
        // Update the tail to the new node
        tail = newNode;
    }

    // -------------------------------------------------------------------------------------------------------
    // Remove First
    public void removeFirst() {
        // If the list is empty, do nothing
        if (head == null) {
            return;
        }
        // If there's only one node, clear both head and tail
        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }
        // Move head to the next node
        head = head.next;
        // Remove the backward link from new head
        head.prev = null;
    }

    // -------------------------------------------------------------------------------------------------------
    // Remove Last
    public void removeLast() {
        // If the list is empty, do nothing
        if (head == null)
            return;

        // If there is only one node, clear both head and tail
        if (head.next == null) {
            head = tail = null;
            return;
        }
        // Disconnect the last node
        tail.prev.next = null;
        // Update the tail to the previous node
        tail = tail.prev;
    }

    // -------------------------------------------------------------------------------------------------------
    // Reverse
    public void reverse() {
        Node prev = null;
        Node curr = head;
        // Set the current head as the new tail
        tail = head;
        while (curr != null) {
            // Save the next node before breaking the link
            Node next = curr.next;
            // Reverse the next and prev pointers
            curr.next = prev; // Point next to previous node
            curr.prev = next; // Point prev to original next node
            // Move prev and curr one step forward
            prev = curr;
            curr = next;
        }
        // After reversal, prev will be the new head
        head = prev;
    }
    // -------------------------------------------------------------------------------------------------------


    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addLast(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        dll.print();
        dll.reverse();
        dll.print();
    }
}
