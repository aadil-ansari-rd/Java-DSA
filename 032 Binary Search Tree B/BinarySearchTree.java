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

    // BST from sorted array
    public Node createBstFromSortedArr(int[] arr, int st, int end) {
        if (st > end) { // Correct base condition: end is inclusive
            return null;
        }

        int mid = st + (end - st) / 2;
        Node newNode = new Node(arr[mid]);

        // Recursively build left and right subtrees
        newNode.left = createBstFromSortedArr(arr, st, mid - 1);
        newNode.right = createBstFromSortedArr(arr, mid + 1, end);

        return newNode;
    }

}

public class BinarySearchTree {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        BST bst = new BST();
        Node root = bst.createBstFromSortedArr(arr, 0, arr.length -1);
        bst.inorder(root);
    }
}
