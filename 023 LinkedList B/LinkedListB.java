import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// ----------------------------------------------------------------------------------------------------

public class LinkedListB {

    public static Node head, tail;

    // ------------------------------------------------------------------------------------------------

    // Size of LinkedList
    public int getSize() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // ------------------------------------------------------------------------------------------------

    // Print LinkedList
    public void printList() {
        if (head == null) {
            System.out.println("LinkedList is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ------------------------------------------------------------------------------------------------

    // Add element to the start of the LinkedList.
    public void addStart(int data) {
        Node newNode = new Node(data);

        // If LinkedList is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // If LinkedList is not empty
        newNode.next = head;
        head = newNode;
    }

    // ------------------------------------------------------------------------------------------------

    // Add element to the end of the LinkedList
    public void addLast(int data) {
        if (head == null) {
            addStart(data);
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
    }

    // ------------------------------------------------------------------------------------------------

    // Add element to the index
    public void addAtIndex(int data, int index) {
        if (index == 0) {
            addStart(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    // ------------------------------------------------------------------------------------------------

    // Remove element from start

    public int removeStart() {
        int size = getSize();
        if (size == 0) {
            System.out.println("LinkedList is empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        return val;

    }
    // public int removeStart(){
    // if(head==null){
    // System.out.println("LinkedList is empty.");
    // return Integer.MIN_VALUE;
    // }
    // int val = head.data;
    // head= head.next;
    // if(head==null)tail=null; //It is when you had ony one node in ur linked list
    // return val ;

    // }

    // ------------------------------------------------------------------------------------------------

    // Remove element from end

    public int removeEnd() {
        int size = getSize();
        if (size == 0) {
            System.out.println("LinkedList is empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        return val;
    }
    // public int removeEnd(){
    // if(head==null){
    // System.out.println("LinkedList is empty.");
    // return Integer.MIN_VALUE;
    // }
    // if(head==tail){
    // int val = head.data;
    // head = tail= null;
    // return val;
    // }
    // Node prev= head;
    // while(prev.next.next!=null){
    // prev= prev.next;
    // }
    // int val = tail.data;
    // prev.next=null;
    // tail = prev;
    // return val;
    // }

    // ------------------------------------------------------------------------------------------------

    // Search in LinkedList

    // Case 1 : Iterative Search
    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // Case 2 : Recursive Search
    public int recSearch(int key) {
        return helper(head, key);
    }

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    // ------------------------------------------------------------------------------------------------

    // Reverse LinkedList

    // Case 1 : Iterative Reverse
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;
        tail = head; // Now tail pointing to head
        while (curr != null) {
            next = curr.next; // next is pointing to next node from current node
            curr.next = prev; // To reverse : curr is pointing to the prev node
            prev = curr; // Now : prev has updated
            curr = next; // Now : curr has updated
        }
        head = prev;
    }

    // Case 2 : Recursive Reverse
    public void reverse2() {
        tail = head; // old head becomes new tail
        head = reverseRecursive(head);
    }

    public Node reverseRecursive(Node head) {
        // Base case: empty list or single node
        if (head == null || head.next == null)
            return head;

        // Reverse the rest of the list
        Node newHead = reverseRecursive(head.next);

        // Adjust the pointers
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // ------------------------------------------------------------------------------------------------

    // Delete Nth from end : First elemnt is assumed to be the tail
    public void deleteNthFromEnd(int idx) {
        int size = getSize();

        if (size == 0 || idx < 1 || idx > size)
            return; // Corner Cases

        if (size == idx) { // First element
            head = head.next;
            return;
        }
        int i = 1;
        int iToFind = size - idx;
        Node prev = head;
        while (i < iToFind) {
            i++;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return;
    }

    // ------------------------------------------------------------------------------------------------

    // Check Paliindrome
    public boolean checkPallindrome() {
        if (head == null || head.next == null)
            return true;
        // Find Middle Node
        Node mid = findMidNode(head);

        // Reverse 2nd half
        Node curr = mid;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        // check if equal
        while (right != null) {
            if (left.data != right.data)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public Node findMidNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // ------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------------------------------------------

    // Detect Cycle in linkedlist
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null)
            return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1 move
            fast = fast.next.next; // +2 move

            if (slow == fast) // cycle detected
                return true;
        }

        return false; // no cycle
    }

    // ------------------------------------------------------------------------------------------------

    // Remove Cycle in linkedlist
    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean hasCycle = false;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle)
            return; // No cycle

        // Step 2: Find the start of the cycle
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Break the cycle
        prev.next = null;
    }

    // ------------------------------------------------------------------------------------------------
    // Merger Sort

    public void doMergeSort() {
        head = mergeSort(head); // assign sorted list to head
        setTail();
    }

    // Main function for Merge sort
    public Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node mid = findMid(head);
        Node rightHead = mid.next;
        mid.next = null; // LinkedList has splitted into two

        Node leftSort = mergeSort(head);
        Node rightSort = mergeSort(rightHead);

        return merge(leftSort, rightSort);
    }

    // Find Mid
    public Node findMid(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted
    public Node merge(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = (list1 != null) ? list1 : list2;
        return dummy.next;

    }

    // Set Tail
    public void setTail() {
        Node temp = head;
        if (head == null || head.next == null) {
            tail = head;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }

    // ------------------------------------------------------------------------------------------------

    // Zig Zag merge from both end
    public void ZigZag() {
        // Base Case
        if (head == null || head.next == null) {
            return; // Nothing to be zig zag
        }

        // Step 1 : Find Mid
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // Split LinkedList
        Node second = mid.next;
        mid.next = null;

        // Step 2 : Reverse right part
        second = reverse(second);

        // Step 3 : Merge
        Node first = head;
        while (second != null) {
            Node temp1 = first.next;
            Node temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
        setTail();
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    // ------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        LinkedListB li = new LinkedListB();
        li.addLast(6);
        li.addLast(5);
        li.addLast(4);
        li.addLast(3);
        li.addLast(2);
        li.addLast(1);

        li.printList();
        li.ZigZag();
        li.printList();
    }
}
