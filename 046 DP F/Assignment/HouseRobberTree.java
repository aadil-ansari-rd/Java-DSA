// Class to represent a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class HouseRobberTree {

    // Main function to call
    public int rob(TreeNode root) {
        int[] result = solveWithDP(root);
        return Math.max(result[0], result[1]);
    }

    // Returns an array {notRob, rob}
    private int[] solveWithDP(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        // Get DP values from left and right children
        int[] left = solveWithDP(node.left);
        int[] right = solveWithDP(node.right);

        // If we do NOT rob this node → take max of children robbed or not
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        // If we rob this node → add node value + children not robbed
        int rob = node.val + left[0] + right[0];

        return new int[]{notRob, rob};
    }

    // Example test
    public static void main(String[] args) {
        HouseRobberTree solution = new HouseRobberTree();

        // Example tree: [3,2,3,null,3,null,1]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(solution.rob(root)); // Output: 7
    }
}
