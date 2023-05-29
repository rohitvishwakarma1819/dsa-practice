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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return util(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1, map);
    }

    public TreeNode util(int[] pre, int[] in, int inLeft, int inRight, int preLeft, int preRight,
            HashMap<Integer, Integer> map) {
        if (inLeft > inRight || preLeft > preRight)
            return null;
        TreeNode node = new TreeNode(pre[preLeft]);
        int index = map.get(pre[preLeft]);
        int leftSize = index - inLeft;
        int rightSize = inRight - index;
        node.left = util(pre, in, inLeft, index - 1, preLeft + 1, preLeft + leftSize, map);
        node.right = util(pre, in, index + 1, inRight, preRight - rightSize + 1, preRight, map);
        return node;
    }

    public int findIndex(int[] arr, int left, int right, int target) {
        for (int i = left; i <= right; ++i)
            if (arr[i] == target)
                return i;
        return -1;
    }
}