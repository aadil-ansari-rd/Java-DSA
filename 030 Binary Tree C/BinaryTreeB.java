import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BuildTreeFromPreOrder {
    static int idx = -1;

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

    // Height of tree
    public int height(Node root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Diameter of tree
    // ----------------------------------------------------------------
    // Aproach1 : TC = O(N^2)
    public int diameter(Node root) { // TC = O(N^2)
        if (root == null) {
            return 0;
        }
        // with root
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int rightDiameter = leftHeight + rightHeight + 1;

        // Left Diameter =
        int leftDiameter = diameter(root.left);

        // Right Diameter =
        int rootDiameter = diameter(root.right);

        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }

    // Aproach2 : TC = O(N)
    class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public int diameter2(Node root) {
        return getTreeInfo(root).diameter;
    }

    public TreeInfo getTreeInfo(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo left = getTreeInfo(root.left);
        TreeInfo right = getTreeInfo(root.right);

        // Current Node Height
        int height = Math.max(left.height, right.height) + 1;

        // Diameter via current Node
        int currentDiameter = left.height + right.height + 1;

        // Max diameter
        int diameter = Math.max(currentDiameter, Math.max(left.diameter, right.diameter));

        return new TreeInfo(height, diameter);

    }

    // Is subtree
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null)
            return true;
        if (node == null || subRoot == null || node.data != subRoot.data)
            return false;
        return isIdentical(node.left, subRoot.left) && isIdentical(node.right, subRoot.right);
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null)
            return true; // ✅ empty tree is subtree of any tree
        if (root == null)
            return false;
        if (root.data == subRoot.data && isIdentical(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    // Function to print top view --------------------------------------
    public static void topView(Node root) {
        if (root == null) return;

        // TreeMap stores horizontal distance → node data
        Map<Integer, Integer> topViewMap = new TreeMap<>();
        // Queue stores pairs of node and horizontal distance
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            // If hd not already in map, add it
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.data);
            }

            // Left child → hd - 1
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            // Right child → hd + 1
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Print top view from leftmost to rightmost
        for (int val : topViewMap.values()) {
            System.out.print(val + " ");
        }
    }

    // Helper Pair class
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}

public class BinaryTreeB {
    public static void main(String[] args) {
        BuildTreeFromPreOrder btree = new BuildTreeFromPreOrder();

        // ✅ Main Tree
        int[] preorder = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BuildTreeFromPreOrder.idx = -1; // Reset idx before building tree
        Node root = btree.buildTree(preorder);

        // ✅ Diameter Tests
        System.out.println("Diameter with TC = O(N^2) : " + btree.diameter(root));
        System.out.println("Diameter with TC = O(N)   : " + btree.diameter2(root));

        // ✅ Subtree Test - Example subtree [3, -1, 6, -1, -1]
        int[] subPreorder = {3, -1, 6, -1, -1};
        BuildTreeFromPreOrder.idx = -1;
        Node subRoot = btree.buildTree(subPreorder);

        boolean isSubtree = BuildTreeFromPreOrder.isSubtree(root, subRoot);
        System.out.println("Is Subtree present? : " + isSubtree);

        // ✅ Top View Test
        System.out.print("Top View of Tree: ");
        BuildTreeFromPreOrder.topView(root);
        System.out.println();
    }
}






// // Node class representing a single node in Binary Tree
// class Node {
//     int data;
//     Node left, right;

//     Node(int data) {
//         this.data = data;
//         left = right = null;
//     }
// }

// class BuildTreeFromPreOrder {
//     static int idx = -1;

//     // ✅ Function to build binary tree from preorder traversal (with -1 as null)
//     public Node buildTree(int[] preorder) {
//         idx++;
//         if (idx >= preorder.length || preorder[idx] == -1) {
//             return null; // base case for null node
//         }
//         Node newNode = new Node(preorder[idx]);
//         newNode.left = buildTree(preorder);  // recursively build left subtree
//         newNode.right = buildTree(preorder); // recursively build right subtree
//         return newNode;
//     }

//     // ✅ Function to calculate height of the tree
//     public int height(Node root) {
//         if (root == null) return 0;
//         int leftHeight = height(root.left);
//         int rightHeight = height(root.right);
//         return Math.max(leftHeight, rightHeight) + 1;
//     }

//     // ✅ Approach 1: Diameter of tree using O(N^2) method
//     public int diameter(Node root) {
//         if (root == null) return 0;

//         // Diameter passes through root
//         int leftHeight = height(root.left);
//         int rightHeight = height(root.right);
//         int rootDiameter = leftHeight + rightHeight + 1;

//         // Diameter in left and right subtree
//         int leftDiameter = diameter(root.left);
//         int rightDiameter = diameter(root.right);

//         // Return maximum of three options
//         return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
//     }

//     // ✅ Approach 2: Diameter of tree in O(N) using TreeInfo class
//     class TreeInfo {
//         int height, diameter;
//         TreeInfo(int height, int diameter) {
//             this.height = height;
//             this.diameter = diameter;
//         }
//     }

//     // Function to get TreeInfo containing both height and diameter
//     public TreeInfo getTreeInfo(Node root) {
//         if (root == null) return new TreeInfo(0, 0);

//         TreeInfo left = getTreeInfo(root.left);
//         TreeInfo right = getTreeInfo(root.right);

//         int height = Math.max(left.height, right.height) + 1;
//         int diameterThroughRoot = left.height + right.height + 1;
//         int maxDiameter = Math.max(diameterThroughRoot, Math.max(left.diameter, right.diameter));

//         return new TreeInfo(height, maxDiameter);
//     }

//     // Function to get diameter using efficient O(N) method
//     public int diameter2(Node root) {
//         return getTreeInfo(root).diameter;
//     }

//     // ✅ Function to check if two trees are identical
//     public static boolean isIdentical(Node node, Node subRoot) {
//         if (node == null && subRoot == null) return true;
//         if (node == null || subRoot == null || node.data != subRoot.data) return false;
//         return isIdentical(node.left, subRoot.left) && isIdentical(node.right, subRoot.right);
//     }

//     // ✅ Function to check if a subtree exists in the main tree
//     public static boolean isSubtree(Node root, Node subRoot) {
//         if (subRoot == null) return true; // empty tree is subtree of any tree
//         if (root == null) return false;
//         if (root.data == subRoot.data && isIdentical(root, subRoot)) return true;
//         return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
//     }

//     // ✅ Function to print top view of binary tree
//     public static void topView(Node root) {
//         if (root == null) return;

//         Map<Integer, Integer> topViewMap = new TreeMap<>(); // stores first node at each horizontal distance
//         Queue<Pair> queue = new LinkedList<>(); // BFS queue
//         queue.add(new Pair(root, 0)); // root has horizontal distance = 0

//         while (!queue.isEmpty()) {
//             Pair current = queue.poll();
//             Node node = current.node;
//             int hd = current.hd;

//             // store first node at each horizontal distance
//             if (!topViewMap.containsKey(hd)) {
//                 topViewMap.put(hd, node.data);
//             }

//             if (node.left != null) queue.add(new Pair(node.left, hd - 1)); // left child → hd - 1
//             if (node.right != null) queue.add(new Pair(node.right, hd + 1)); // right child → hd + 1
//         }

//         // Print top view in left-to-right order
//         for (int val : topViewMap.values()) {
//             System.out.print(val + " ");
//         }
//     }

//     // ✅ Helper class to store node and horizontal distance
//     static class Pair {
//         Node node;
//         int hd;
//         Pair(Node node, int hd) {
//             this.node = node;
//             this.hd = hd;
//         }
//     }
// }
