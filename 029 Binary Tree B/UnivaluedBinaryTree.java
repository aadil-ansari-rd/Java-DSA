// ✅ Java Program to check if a Binary Tree is Univalued
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class UnivaluedBinaryTree {

    // Function to check if tree is univalued
    public static boolean isUnivalued(Node root) {
        if (root == null) return true; // Empty tree is univalued
        return isSameValue(root, root.data);
    }

    // Helper recursive function to check each node
    private static boolean isSameValue(Node node, int value) {
        if (node == null) return true; // Null node doesn't violate condition
        
        if (node.data != value) return false; // If any value differs
        
        // Check left and right subtree recursively
        return isSameValue(node.left, value) && isSameValue(node.right, value);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(1);
        root.left.right = new Node(1);

        System.out.println(isUnivalued(root)); // Output: true
    }
}
