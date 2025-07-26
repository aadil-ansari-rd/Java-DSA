class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class BSTRangeSum {

    // Function to calculate range sum in BST
    public int rangeSumBST(Node root, int L, int R) {
        if (root == null) return 0;

        // If node is less than L, explore right subtree only
        if (root.data < L) {
            return rangeSumBST(root.right, L, R);
        }

        // If node is greater than R, explore left subtree only
        if (root.data > R) {
            return rangeSumBST(root.left, L, R);
        }

        // If node is in range, add its value and explore both subtrees
        return root.data + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    // Sample BST builder for testing
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);

        BSTRangeSum bst = new BSTRangeSum();
        int L = 5, R = 11;
        int result = bst.rangeSumBST(root, L, R);
        System.out.println("Range Sum: " + result);  // Output: 30
    }
}
