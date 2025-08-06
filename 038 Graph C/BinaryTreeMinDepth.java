// ✅ Main class to run the example
public class BinaryTreeMinDepth {

    // ✅ TreeNode class definition
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // ✅ Solution class with minDepth method
    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;

            // If left is null, go down right
            if (root.left == null) {
                return 1 + minDepth(root.right);
            }

            // If right is null, go down left
            if (root.right == null) {
                return 1 + minDepth(root.left);
            }

            // Both left and right are present → take the minimum
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

    // ✅ Main method for testing
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Solution sol = new Solution();
        int result = sol.minDepth(root);
        System.out.println("Minimum Depth = " + result);  // Output: 2
    }
}
