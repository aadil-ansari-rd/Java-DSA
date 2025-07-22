import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class IntersectionUsingHashSet {

    // Function to get intersection node
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        // Add all nodes of list A to the set
        ListNode currA = headA;
        while (currA != null) {
            set.add(currA);
            currA = currA.next;
        }

        // Traverse list B and check for intersection
        ListNode currB = headB;
        while (currB != null) {
            if (set.contains(currB)) {
                return currB; // First common node
            }
            currB = currB.next;
        }

        return null; // No intersection
    }

    // Helper to print list from a given node
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Common part
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        // First List: 3 → 7 → 8 → 10
        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = common;

        // Second List: 99 → 1 → 8 → 10
        ListNode headB = new ListNode(99);
        headB.next = new ListNode(1);
        headB.next.next = common;

        System.out.print("List A: ");
        printList(headA);
        System.out.print("List B: ");
        printList(headB);

        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
