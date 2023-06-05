/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTUtil(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        if (root.val < high && root.val > low) {
            return isValidBSTUtil(root.left, low, root.val)
                    &&
                    isValidBSTUtil(root.right, root.val, high);
        } else {
            return false;
        }
    }
}