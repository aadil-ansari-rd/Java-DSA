// ✅ Java program to delete leaf nodes with value x
class Node {
    int data;
    Node left, right;
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class DeleteLeafNodes {

    // Function to delete leaf nodes with value x
    public static Node deleteLeafNodes(Node root, int x) {
        if (root == null) return null; // Base case
        
        // Recursively delete in left and right subtree
        root.left = deleteLeafNodes(root.left, x);
        root.right = deleteLeafNodes(root.right, x);
        
        // After recursion, check if current node is leaf and value is x
        if (root.left == null && root.right == null && root.data == x) return null;
        
        return root;
    }

    // Inorder Traversal to print tree
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(2);
        root.right.right = new Node(4);

        System.out.print("Inorder before deletion: ");
        inorder(root);
        System.out.println();

        root = deleteLeafNodes(root, 2);

        System.out.print("Inorder after deletion: ");
        inorder(root);
        System.out.println();
    }
}
