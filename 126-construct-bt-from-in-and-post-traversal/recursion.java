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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return util(inorder, postorder, 0, postorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode util(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight)
            return null;
        TreeNode node = new TreeNode(postorder[postRight]);
        int index = findIndex(inorder, inLeft, inRight, postorder[postRight]);
        int leftSize = index - inLeft;
        int rightSize = inRight - index;
        node.left = util(inorder, postorder, inLeft, index - 1, postLeft, postLeft + leftSize - 1);
        node.right = util(inorder, postorder, index + 1, inRight, postRight - rightSize, postRight - 1);
        return node;
    }

    public int findIndex(int[] arr, int left, int right, int target) {
        for (int i = left; i <= right; ++i)
            if (arr[i] == target)
                return i;
        return -1;
    }
}