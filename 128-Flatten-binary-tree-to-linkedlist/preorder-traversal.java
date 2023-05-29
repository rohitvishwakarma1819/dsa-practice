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
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        prev = root;
        TreeNode right = root.right;
        preOrder(root.left);
        preOrder(right);
        root.left = null;
        // return root;
    }

    public void preOrder(TreeNode root) {
        if (root == null)
            return;
        TreeNode right = root.right;
        prev.right = root;
        prev = root;
        preOrder(root.left);
        preOrder(right);
        root.left = null;

    }
}