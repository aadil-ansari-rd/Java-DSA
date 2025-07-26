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

    // Search In BST
    // ---------------------------------------------------------------------
    public boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        if (key < root.data)
            return search(root.left, key);
        return search(root.right, key);
    }

    // Delete a Node
    // -----------------------------------------------------------------------------=
    public Node deleteNode(Node root, int key) {
        if (root == null)
            return null;

        // Step 1: Traverse to the node
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            // Step 2: Node found
            // Case 1 & 2: One or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Case 3: Two children
            Node successor = findMin(root.right); // smallest in right subtree
            root.data = successor.data; // copy successor value
            root.right = deleteNode(root.right, successor.data); // delete successor
        }
        return root;
    }

    // Helper function to find the smallest node in right subtree
    private Node findMin(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // Function to print nodes in range using inorder traversal
    // ----------------------------
    public void printInRange(Node root, int k1, int k2) {
        if (root == null)
            return;

        // Traverse left subtree if there is a possibility of valid nodes
        if (root.data > k1) {
            printInRange(root.left, k1, k2);
        }

        // Print current node if it lies within the range
        if (root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
        }

        // Traverse right subtree if there is a possibility of valid nodes
        if (root.data < k2) {
            printInRange(root.right, k1, k2);
        }
    }

    // Main function to print root-to-leaf paths ---------------------------------
    public void printPaths(Node root) {
        printPathsHelper(root, "");
    }

    // Helper function for recursion -------------
    private void printPathsHelper(Node node, String path) {
        if (node == null)
            return;

        // Add current node to path
        path += node.data;

        // If leaf node, print the path
        if (node.left == null && node.right == null) {
            System.out.println(path);
            return;
        }

        // Continue to child nodes
        path += "->";
        printPathsHelper(node.left, path);
        printPathsHelper(node.right, path);
    }

    // Validate BST
    // -------------------------------------------------------------------------
    public boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(Node node, long min, long max) {
        if (node == null)
            return true;

        // Check current node validity
        if (node.data <= min || node.data >= max)
            return false;

        // Left subtree must be in (min, node.val)
        // Right subtree must be in (node.val, max)
        return validate(node.left, min, node.data) &&
                validate(node.right, node.data, max);
    }

    // Mirror BST
    public Node createMirror(Node root) {
        if (root == null)
            return null;
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);
        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        int[] arr = {50, 30, 70, 20, 40, 60, 80, 10, 25, 65};
        BST bst = new BST();
        Node root = bst.buildBST(arr);

        System.out.println("✅ Inorder Traversal (Sorted BST):");
        bst.inorder(root);
        System.out.println();

        System.out.println("\n✅ Search Tests:");
        System.out.println("Search 25: " + bst.search(root, 25)); // true
        System.out.println("Search 90: " + bst.search(root, 90)); // false

        System.out.println("\n✅ Root to Leaf Paths:");
        bst.printPaths(root);

        System.out.println("\n✅ Print Nodes in Range [20,80]:");
        bst.printInRange(root, 20, 80);
        System.out.println();

        System.out.println("\n✅ Validate BST: " + bst.isValidBST(root)); // true

        System.out.println("\n✅ Delete Leaf Node (25):");
        root = bst.deleteNode(root, 25);
        bst.inorder(root);
        System.out.println();

        System.out.println("\n✅ Delete Node with One Child (20):");
        root = bst.deleteNode(root, 20);
        bst.inorder(root);
        System.out.println();

        System.out.println("\n✅ Delete Node with Two Children (30):");
        root = bst.deleteNode(root, 30);
        bst.inorder(root);
        System.out.println();

        System.out.println("\n✅ Mirror BST (Inorder Traversal of Mirror):");
        root = bst.createMirror(root);
        bst.inorder(root);
        System.out.println();

        System.out.println("\n✅ Validate BST after Mirror: " + bst.isValidBST(root)); // false
    }
}







// // ✅ Node Class
// class Node {
//     int data;
//     Node left, right;

//     Node(int data) {
//         this.data = data;
//     }
// }

// class BST {

//     // ✅ Inorder Traversal (Left, Root, Right) - Sorted Order in BST
//     public void inorder(Node root) {
//         if (root == null) return;
//         inorder(root.left);
//         System.out.print(root.data + " ");
//         inorder(root.right);
//     }

//     // ✅ Build BST from an Array
//     public Node buildBST(int[] arr) {
//         Node root = null;
//         for (int num : arr) {
//             root = insertInBST(root, num);
//         }
//         return root;
//     }

//     // ✅ Insert a Node in BST
//     public Node insertInBST(Node root, int data) {
//         if (root == null) return new Node(data);
//         if (data < root.data)
//             root.left = insertInBST(root.left, data);
//         else if (data > root.data)
//             root.right = insertInBST(root.right, data);
//         return root;
//     }

//     // ✅ Search for a Key in BST
//     public boolean search(Node root, int key) {
//         if (root == null) return false;
//         if (root.data == key) return true;
//         if (key < root.data)
//             return search(root.left, key);
//         return search(root.right, key);
//     }

//     // ✅ Delete a Node from BST (Handles all 3 cases)
//     public Node deleteNode(Node root, int key) {
//         if (root == null) return null;

//         // Step 1: Find node to delete
//         if (key < root.data) {
//             root.left = deleteNode(root.left, key);
//         } else if (key > root.data) {
//             root.right = deleteNode(root.right, key);
//         } else {
//             // Node found
//             // Case 1: Node with one child or no child
//             if (root.left == null) return root.right;
//             if (root.right == null) return root.left;

//             // Case 2: Node with two children
//             // Get inorder successor (smallest in right subtree)
//             Node successor = findMin(root.right);
//             root.data = successor.data;
//             // Delete the successor
//             root.right = deleteNode(root.right, successor.data);
//         }
//         return root;
//     }

//     // ✅ Helper Function to Find Minimum Node (Inorder Successor)
//     private Node findMin(Node node) {
//         while (node.left != null) {
//             node = node.left;
//         }
//         return node;
//     }

//     // ✅ Print Nodes in Given Range [k1, k2] (Inorder Traversal)
//     public void printInRange(Node root, int k1, int k2) {
//         if (root == null) return;

//         if (root.data > k1)
//             printInRange(root.left, k1, k2);

//         if (root.data >= k1 && root.data <= k2)
//             System.out.print(root.data + " ");

//         if (root.data < k2)
//             printInRange(root.right, k1, k2);
//     }

//     // ✅ Print All Root-to-Leaf Paths
//     public void printPaths(Node root) {
//         printPathsHelper(root, "");
//     }

//     // ✅ Helper DFS Function to Track Path
//     private void printPathsHelper(Node node, String path) {
//         if (node == null) return;

//         // Add current node to path
//         path += node.data;

//         // Leaf Node → Print Path
//         if (node.left == null && node.right == null) {
//             System.out.println(path);
//             return;
//         }

//         // Go to left and right subtree
//         path += "->";
//         printPathsHelper(node.left, path);
//         printPathsHelper(node.right, path);
//     }

//     // ✅ Validate BST using Range (MIN, MAX Method)
//     public boolean isValidBST(Node root) {
//         return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }

//     // ✅ Helper Function to Validate BST
//     private boolean validate(Node node, long min, long max) {
//         if (node == null) return true;

//         if (node.data <= min || node.data >= max) return false;

//         // Left subtree → (min, node.data)
//         // Right subtree → (node.data, max)
//         return validate(node.left, min, node.data) &&
//                 validate(node.right, node.data, max);
//     }

//     // ✅ Mirror the BST (Swap Left and Right Subtree)
//     public Node createMirror(Node root) {
//         if (root == null) return null;

//         // Mirror Left and Right Subtree
//         Node leftMirror = createMirror(root.left);
//         Node rightMirror = createMirror(root.right);

//         // Swap Left and Right
//         root.left = rightMirror;
//         root.right = leftMirror;

//         return root;
//     }
// }
