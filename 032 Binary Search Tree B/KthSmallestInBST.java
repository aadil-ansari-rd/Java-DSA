class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class KthSmallestInBST {

    int count = 0;   // how many nodes visited
    int result = -1; // store Kth smallest when found

    // Main function to call
    public int kthSmallest(Node root, int K) {
        inorder(root, K);
        return result;
    }

    // Inorder traversal (Left → Root → Right)
    private void inorder(Node root, int K) {
        if (root == null) return;

        inorder(root.left, K);  // visit left

        count++; // current node is visited
        if (count == K) {
            result = root.data;  // store the result
            return;
        }

        inorder(root.right, K); // visit right
    }

    // Sample test
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1);

        KthSmallestInBST bst = new KthSmallestInBST();
        int K = 3;
        int ans = bst.kthSmallest(root, K);
        System.out.println("Kth Smallest Element: " + ans);  // Output: 3
    }
}
