import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        // Min-heap to store (value, node)
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        // Dummy node to simplify result handling
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }

    // Utility to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Test case
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};
        ListNode result = mergeKLists(lists);
        printList(result);  // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> null
    }
}
