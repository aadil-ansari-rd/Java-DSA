class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class BSTToGreaterSumTree {

    int sum = 0; // running cumulative sum

    // Function to convert BST to Greater Sum Tree
    public void convertToGST(Node root) {
        if (root == null) return;

        // Traverse right subtree first (greater values)
        convertToGST(root.right);

        // Update current node
        sum += root.data;
        root.data = sum;

        // Traverse left subtree
        convertToGST(root.left);
    }

    // Inorder traversal to print updated tree
    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Main to test
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(10);

        BSTToGreaterSumTree tree = new BSTToGreaterSumTree();
        tree.convertToGST(root);

        // After conversion
        System.out.print("Inorder of Greater Sum Tree: ");
        tree.inorder(root);  // Output should show descending accumulation
    }
}
