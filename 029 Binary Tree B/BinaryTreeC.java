import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BuildTreeFromPreOrder {
    static int idx = -1; // used for indexing during tree construction

    // Build Tree
    public Node buildTree(int[] preorder) {
        idx++;
        if (idx >= preorder.length || preorder[idx] == -1) {
            return null;
        }
        Node newNode = new Node(preorder[idx]);
        newNode.left = buildTree(preorder);
        newNode.right = buildTree(preorder);
        return newNode;
    }

    // PreOrder
    public void preorder(Node root) {
        if (root == null)
            return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    // Kth Level Nodes
    // ------------------------------------------------------------------

    // Approach 1 --------------------
    public int height(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public void printLevel(Node root, int k) {
        if (root == null)
            return;
        if (k == 1)
            System.out.print(root.data + " ");
        else {
            printLevel(root.left, k - 1);
            printLevel(root.right, k - 1);
        }
    }

    public void KthLevel(Node root, int k) {
        int h = height(root);
        if (k > h) {
            System.out.println("Level exceeds height");
            return;
        }
        System.out.print("Nodes at level " + k + ": ");
        printLevel(root, k);
        System.out.println();
    }

    // Approach 2 --------------------

    public void KthLevel(Node root, int level, int k) {
        if (root == null)
            return;

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        KthLevel(root.left, level + 1, k);
        KthLevel(root.right, level + 1, k);
    }

    // Lowest Common
    // -------------------------------------------------------------------------------

    // Approach 1 -------------------------------

    public boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null)
            return false;
        path.add(root);
        if (root.data == n)
            return true;

        if (getPath(root.left, n, path) || getPath(root.right, n, path))
            return true;

        path.remove(path.size() - 1);
        return false;
    }

    public Node lca1(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
            return null;
        }

        int i = 0;
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i).data != path2.get(i).data)
                break;
            i++;
        }

        return path1.get(i - 1);
    }

    // Approach 2 -------------------------------

    public Node lca2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // leftLca = val , rightLca = null
        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }
        return root;
    }

    // Minimum distance between two nodes
    // -----------------------------------------------------------

    public int minDist(Node root, int n1, int n2) {
        Node lca = lca1(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        return dist1 + dist2;
    }

    public int lcaDist(Node root, int n) {
        if (root == null)
            return -1;
        if (root.data == n)
            return 0;
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    // Kth Ancestor of a node
    // ------------------------------------------------------------------------
    public int KthAncestor(Node root, int n, int k) {
        if (root == null)
            return -1;
        if (root.data == n)
            return 0;
        int leftDist = KthAncestor(root.left, n, k);
        int rightDist = KthAncestor(root.right, n, k);
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    // Transform to sum tree
    // --------------------------------------------------------------------
    public int transform(Node root) {
        if (root == null)
            return 0;

        int leftSum = transform(root.left);
        int rightSum = transform(root.right);

        int oldValue = root.data;
        root.data = leftSum + rightSum;

        return root.data + oldValue;
    }
}

public class BinaryTreeC {
    public static void main(String[] args) {
        BuildTreeFromPreOrder tree = new BuildTreeFromPreOrder();
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6

        // Build Tree using PreOrder Array
        int[] preorder = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = tree.buildTree(preorder);


        // ✅ Kth Level Nodes (Approach 1)
        System.out.print("Kth Level (level=3): ");
        tree.KthLevel(root, 3);

        // ✅ Kth Level Nodes (Approach 2)
        System.out.print("\nKth Level Optimized (level=2): ");
        tree.KthLevel(root, 1, 2);
        System.out.println();

        // ✅ LCA Method 1
        Node lca1 = tree.lca1(root, 4, 5);
        System.out.println("\nLCA1 of (4,5): " + (lca1 != null ? lca1.data : "Not found"));

        // ✅ LCA Method 2
        Node lca2 = tree.lca2(root, 4, 6);
        System.out.println("LCA2 of (4,6): " + (lca2 != null ? lca2.data : "Not found"));

        // ✅ Minimum Distance
        int dist = tree.minDist(root, 4, 6);
        System.out.println("Distance between 4 and 6: " + dist);

        // ✅ Kth Ancestor
        System.out.print("\nKth Ancestor of node=5 with k=2: ");
        tree.KthAncestor(root, 5, 2);

        // ✅ Transform to Sum Tree
        tree.transform(root);
        System.out.print("\nAfter Transform to Sum Tree, Preorder Traversal: ");
        tree.preorder(root);
    }
}



// class Node {
//     int data;
//     Node left, right;

//     Node(int data) {
//         this.data = data;
//         left = right = null;
//     }
// }

// class BuildTreeFromPreOrder {
//     // ✅ Height of tree
//     public int height(Node root) {
//         if (root == null)
//             return 0;

//         // height = 1 + max(left subtree height, right subtree height)
//         return 1 + Math.max(height(root.left), height(root.right));
//     }

//     // ✅ Print all nodes at level k
//     public void printLevel(Node root, int k) {
//         if (root == null)
//             return;

//         // if current level is 1, print the node
//         if (k == 1)
//             System.out.print(root.data + " ");
//         else {
//             // recursively go to k-1 level in both subtrees
//             printLevel(root.left, k - 1);
//             printLevel(root.right, k - 1);
//         }
//     }

//     // ✅ Print kth level using height-based approach
//     public void KthLevel(Node root, int k) {
//         int h = height(root); // get tree height
//         if (k > h) {
//             System.out.println("Level exceeds height");
//             return;
//         }
//         System.out.print("Nodes at level " + k + ": ");
//         printLevel(root, k); // print kth level nodes
//         System.out.println();
//     }

//     // ✅ Optimized: Print Kth level using level parameter
//     public void KthLevel(Node root, int level, int k) {
//         if (root == null)
//             return;

//         if (level == k) {
//             // if current level equals desired level, print node
//             System.out.print(root.data + " ");
//             return;
//         }

//         // recursively increase level to reach k
//         KthLevel(root.left, level + 1, k);
//         KthLevel(root.right, level + 1, k);
//     }

//     // ✅ Get path from root to node `n`
//     public boolean getPath(Node root, int n, ArrayList<Node> path) {
//         if (root == null)
//             return false;

//         // add current node to path
//         path.add(root);

//         if (root.data == n)
//             return true;

//         // check if node is found in left or right subtree
//         if (getPath(root.left, n, path) || getPath(root.right, n, path))
//             return true;

//         // if not found, backtrack (remove last node)
//         path.remove(path.size() - 1);
//         return false;
//     }

//     // ✅ Lowest Common Ancestor using Path Comparison
//     public Node lca1(Node root, int n1, int n2) {
//         ArrayList<Node> path1 = new ArrayList<>();
//         ArrayList<Node> path2 = new ArrayList<>();

//         // get paths to both nodes
//         if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
//             return null; // if any node not found
//         }

//         // find first mismatch in paths
//         int i = 0;
//         while (i < path1.size() && i < path2.size()) {
//             if (path1.get(i).data != path2.get(i).data)
//                 break;
//             i++;
//         }

//         // last common matched node is LCA
//         return path1.get(i - 1);
//     }

//     // ✅ Optimized Recursive LCA
//     public Node lca2(Node root, int n1, int n2) {
//         if (root == null || root.data == n1 || root.data == n2) {
//             return root; // base case
//         }

//         // find LCA in left and right subtree
//         Node leftLca = lca2(root.left, n1, n2);
//         Node rightLca = lca2(root.right, n1, n2);

//         if (rightLca == null) return leftLca;
//         if (leftLca == null) return rightLca;

//         // if both sides return non-null → this is LCA
//         return root;
//     }

//     // ✅ Minimum distance between 2 nodes = dist(LCA to n1) + dist(LCA to n2)
//     public int minDist(Node root, int n1, int n2) {
//         Node lca = lca1(root, n1, n2); // get LCA of both nodes
//         int dist1 = lcaDist(lca, n1);  // distance from LCA to n1
//         int dist2 = lcaDist(lca, n2);  // distance from LCA to n2
//         return dist1 + dist2;
//     }

//     // ✅ Find distance from root to a node
//     public int lcaDist(Node root, int n) {
//         if (root == null)
//             return -1;
//         if (root.data == n)
//             return 0;

//         int leftDist = lcaDist(root.left, n);
//         int rightDist = lcaDist(root.right, n);

//         if (leftDist == -1 && rightDist == -1) {
//             return -1; // node not found
//         } else if (leftDist == -1) {
//             return rightDist + 1;
//         } else {
//             return leftDist + 1;
//         }
//     }

//     // ✅ Kth Ancestor of node n
//     public int KthAncestor(Node root, int n, int k) {
//         if (root == null)
//             return -1;
//         if (root.data == n)
//             return 0;

//         int leftDist = KthAncestor(root.left, n, k);
//         int rightDist = KthAncestor(root.right, n, k);

//         if (leftDist == -1 && rightDist == -1) {
//             return -1; // node not found
//         }

//         // distance from current node to target node
//         int max = Math.max(leftDist, rightDist);

//         // if current node is the Kth ancestor
//         if (max + 1 == k) {
//             System.out.println(root.data); // print the kth ancestor
//         }

//         return max + 1;
//     }

//     // ✅ Convert tree to Sum Tree
//     public int transform(Node root) {
//         if (root == null)
//             return 0;

//         // recursively convert left and right subtree
//         int leftSum = transform(root.left);
//         int rightSum = transform(root.right);

//         int oldValue = root.data;

//         // update current node data to sum of left + right subtree values
//         root.data = leftSum + rightSum;

//         // return total sum including current node's old value (for parent use)
//         return root.data + oldValue;
//     }
// }
