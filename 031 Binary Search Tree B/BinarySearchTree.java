class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

class BST {
    // Inorder Traversal
    // ---------------------------------------------------------------
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Build BST from array
    // ------------------------------------------------------------
    public Node buildBST(int[] arr) {
        Node root = null;

        for (int num : arr) {
            root = insertInBST(root, num);
        }
        return root;
    }

    // Insert in BST ----------------------------------
    public Node insertInBST(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (data < root.data)
            root.left = insertInBST(root.left, data);
        else if (data > root.data)
            root.right = insertInBST(root.right, data);
        return root;
    }

    
}

public class BinarySearchTree {
    public static void main(String[] args) {
        
    }
}







