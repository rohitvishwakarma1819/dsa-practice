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
    long max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs2(root);
        return (int) max;
    }

    public long dfs2(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        long left = dfs2(root.left);
        long right = dfs2(root.right);
        long currMax = root.val;
        if (currMax + left > currMax) {
            currMax += left;
        }
        if (currMax + right > currMax) {
            currMax += right;
        }
        max = Math.max(max, currMax);
        return Math.max(root.val, Math.max(root.val + left, root.val + right));
    }
}