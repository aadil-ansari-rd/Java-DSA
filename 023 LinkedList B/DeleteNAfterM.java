// Node class for singly linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class DeleteNAfterM {

    // Function to delete N nodes after M nodes
    public static ListNode deleteNafterM(ListNode head, int M, int N) {
        ListNode curr = head;

        while (curr != null) {
            // Skip M nodes
            for (int i = 1; i < M && curr != null; i++) {
                curr = curr.next;
            }

            // If end reached during skip, stop
            if (curr == null) break;

            // Delete next N nodes
            ListNode temp = curr.next;
            for (int i = 1; i <= N && temp != null; i++) {
                temp = temp.next;
            }

            // Link current node to the node after N deletions
            curr.next = temp;

            // Move to next segment
            curr = temp;
        }

        return head;
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        // Create linked list: 1 → 2 → 3 → 4 → ... → 10
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= 10; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        System.out.print("Original list: ");
        printList(head);

        int M = 2, N = 3;
        head = deleteNafterM(head, M, N);

        System.out.print("Modified list: ");
        printList(head);
    }
}
