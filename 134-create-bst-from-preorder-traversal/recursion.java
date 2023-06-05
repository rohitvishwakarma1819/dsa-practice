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
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode build(int[] preorder, int min, int max) {
        if (index >= preorder.length)
            return null;
        if (preorder[index] < min || preorder[index] > max)
            return null;

        TreeNode node = new TreeNode(preorder[index]);
        index++;
        node.left = build(preorder, min, preorder[index - 1]);
        node.right = build(preorder, preorder[index - 1], max);
        return node;
    }
}