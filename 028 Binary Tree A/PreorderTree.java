import java.util.ArrayDeque;
import java.util.Queue;

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

    // Preorder print that includes -1 for null nodes (same as input format)
    public void printPreorderInputArray(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        printPreorderInputArray(root.left);
        printPreorderInputArray(root.right);
    }

    // Preorder Traversal
    public void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder Traversal
    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Postorder Traversal
    public void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Level Order Traversal O(N) — Line by Line
    public void levelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // nodes in current level

            // Print current level nodes
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                System.out.print(current.data + " ");

                // Enqueue left and right child
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            System.out.println(); // new line after each level
        }
    }

    // Height of tree
    public int height(Node root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Count of nodes
    public int count(Node root) {
        if (root == null)
            return 0;
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return (leftCount + rightCount) + 1;
    }

    // Sum of nodes
    public int sum(Node root) {
        if (root == null)
            return 0;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return root.data + (leftSum + rightSum);
    }
}

public class PreorderTree {
    public static void main(String[] args) {
        int[] preorder = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BuildTreeFromPreOrder btree = new BuildTreeFromPreOrder();
        Node root = btree.buildTree(preorder);
        System.out.println("Print Original array with the help of root");
        btree.printPreorderInputArray(root);
        System.out.println();
        System.out.println("Preorder");
        btree.preorder(root);
        System.out.println();
        System.out.println("Inorder");
        btree.inorder(root);
        System.out.println();
        System.out.println("Postorder");
        btree.postorder(root);
        System.out.println();
        System.out.println("Levelorder");
        btree.levelOrder(root);
        System.out.println();
        System.out.println("Height(In terms of nodes) : " + btree.height(root));
        System.out.println("Height(In terms of edges) : " + (btree.height(root) - 1));// No. of edges = No. of nodes -1
        System.out.println("Count of Nodes : " + btree.count(root));
        System.out.println("Sum of Nodes : " + btree.sum(root));

    }

}


// // Node class representing each tree node
// class Node {
//     int data;
//     Node left, right;

//     Node(int data) {
//         this.data = data;
//         left = right = null;
//     }
// }

// // Class containing all tree-related methods
// class BuildTreeFromPreOrder {
//     static int idx = -1;  // index to track current node in preorder array

//     // ✅ Build Tree using preorder array with null marker (-1)
//     public Node buildTree(int[] preorder) {
//         idx++;  // move to next index
//         // Base case: if current element is -1, return null (no node)
//         if (idx >= preorder.length || preorder[idx] == -1) {
//             return null;
//         }
//         // Create new node
//         Node newNode = new Node(preorder[idx]);
//         // Recursively build left and right subtree
//         newNode.left = buildTree(preorder);
//         newNode.right = buildTree(preorder);
//         return newNode;
//     }

//     // ✅ Print preorder with -1, same as input array format
//     public void printPreorderInputArray(Node root) {
//         if (root == null) {
//             System.out.print(-1 + " ");
//             return;
//         }
//         System.out.print(root.data + " ");
//         printPreorderInputArray(root.left);
//         printPreorderInputArray(root.right);
//     }

//     // ✅ Preorder Traversal: Root → Left → Right
//     public void preorder(Node root) {
//         if (root == null) return;
//         System.out.print(root.data + " ");
//         preorder(root.left);
//         preorder(root.right);
//     }

//     // ✅ Inorder Traversal: Left → Root → Right
//     public void inorder(Node root) {
//         if (root == null) return;
//         inorder(root.left);
//         System.out.print(root.data + " ");
//         inorder(root.right);
//     }

//     // ✅ Postorder Traversal: Left → Right → Root
//     public void postorder(Node root) {
//         if (root == null) return;
//         postorder(root.left);
//         postorder(root.right);
//         System.out.print(root.data + " ");
//     }

//     // ✅ Level Order Traversal (BFS), prints level by level
//     public void levelOrder(Node root) {
//         if (root == null) return;

//         Queue<Node> queue = new ArrayDeque<>();
//         queue.offer(root);

//         while (!queue.isEmpty()) {
//             int levelSize = queue.size(); // number of nodes in current level

//             // Print nodes of current level
//             for (int i = 0; i < levelSize; i++) {
//                 Node current = queue.poll();
//                 System.out.print(current.data + " ");

//                 // Enqueue left and right children
//                 if (current.left != null) queue.offer(current.left);
//                 if (current.right != null) queue.offer(current.right);
//             }
//             System.out.println(); // line break after each level
//         }
//     }

//     // ✅ Height of tree = Max depth from root
//     public int height(Node root) {
//         if (root == null) return 0;
//         int leftHeight = height(root.left);
//         int rightHeight = height(root.right);
//         return Math.max(leftHeight, rightHeight) + 1;
//     }

//     // ✅ Count total number of nodes in the tree
//     public int count(Node root) {
//         if (root == null) return 0;
//         int leftCount = count(root.left);
//         int rightCount = count(root.right);
//         return leftCount + rightCount + 1;
//     }

//     // ✅ Sum of all node values in the tree
//     public int sum(Node root) {
//         if (root == null) return 0;
//         int leftSum = sum(root.left);
//         int rightSum = sum(root.right);
//         return root.data + leftSum + rightSum;
//     }
// }
