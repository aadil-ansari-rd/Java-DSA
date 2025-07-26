class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

class Info {
    boolean isBST;
    int sum, min, max;

    Info(boolean isBST, int sum, int min, int max) {
        this.isBST = isBST;
        this.sum = sum;
        this.min = min;
        this.max = max;
    }
}

public class MaxSumBSTInBT {

    int maxSum = 0;

    public Info helper(Node root) {
        if (root == null)
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        Info left = helper(root.left);
        Info right = helper(root.right);

        // Check if current subtree is BST
        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            int currSum = root.data + left.sum + right.sum;
            maxSum = Math.max(maxSum, currSum);
            return new Info(true, currSum,
                            Math.min(root.data, left.min),
                            Math.max(root.data, right.max));
        }

        // If not BST, return false and ignore its sum
        return new Info(false, 0, 0, 0);
    }

    public int maxSumBST(Node root) {
        helper(root);
        return maxSum;
    }

    // Test example
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(10);

        MaxSumBSTInBT tree = new MaxSumBSTInBT();
        System.out.println("Maximum Sum of BST in Tree: " + tree.maxSumBST(root));  // Output: 22
    }
}
