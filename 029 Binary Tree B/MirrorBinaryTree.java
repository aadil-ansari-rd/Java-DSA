// ✅ Java program to invert (mirror) a binary tree
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class MirrorBinaryTree {

    // Function to invert the binary tree
    public static Node invert(Node root) {
        if (root == null) return null; // Base condition

        // Swap left and right child
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert left and right subtrees
        invert(root.left);
        invert(root.right);

        return root;
    }

    // Function to print inorder traversal
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(9);

        System.out.print("Inorder before inversion: ");
        inorder(root);
        System.out.println();

        invert(root);

        System.out.print("Inorder after inversion: ");
        inorder(root);
        System.out.println();
    }
}
