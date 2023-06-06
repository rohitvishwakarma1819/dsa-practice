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
    int lastVal = -1;
    int currentIndex = 0;

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestUtil(root, k);
        return lastVal;
    }

    public void kthSmallestUtil(TreeNode root, int k) {
        if (root == null || currentIndex >= k)
            return;

        kthSmallestUtil(root.left, k);
        if (currentIndex >= k)
            return;
        currentIndex++;
        lastVal = root.val;
        kthSmallestUtil(root.right, k);

    }
}