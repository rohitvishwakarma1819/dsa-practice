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
    class Data {
        int sum;
        boolean isBST;
        int min, max;

        public Data(int s, boolean bst, int min, int max) {
            sum = s;
            isBST = bst;
            this.min = min;
            this.max = max;
        }
    }

    int ans = Integer.MIN_VALUE;
    int sum = Integer.MIN_VALUE;
    int last = Integer.MIN_VALUE;

    public int maxSumBST(TreeNode root) {
        ans = Integer.MIN_VALUE;
        postorder(root);
        return ans > 0 ? ans : 0;
    }

    Data postorder(TreeNode node) {
        if (node.left != null && node.right != null) {
            Data left = postorder(node.left);
            Data right = postorder(node.right);
            if (left.isBST && right.isBST && (left.min < node.val && left.max < node.val)
                    && (right.min > node.val && right.max > node.val)) {
                Data d = new Data(left.sum + right.sum + node.val, true, Math.min(left.min, node.val),
                        Math.max(node.val, right.max));
                ans = Math.max(ans, d.sum);
                return d;
            }
            return new Data(Integer.MIN_VALUE, false, 0, 0);
        } else if (node.left != null) {
            Data left = postorder(node.left);
            if (left.isBST && left.min < node.val && left.max < node.val) {
                Data d = new Data(node.val + left.sum, true, Math.min(node.val, left.min),
                        Math.max(node.val, left.max));
                ans = Math.max(ans, d.sum);
                return d;
            }
            return new Data(Integer.MIN_VALUE, false, 0, 0);

        } else if (node.right != null) {
            Data right = postorder(node.right);
            if (right.isBST && right.min > node.val && right.max > node.val) {
                Data d = new Data(node.val + right.sum, true, Math.min(node.val, right.min),
                        Math.max(node.val, right.max));
                ans = Math.max(ans, d.sum);
                return d;
            }
            return new Data(Integer.MIN_VALUE, false, 0, 0);

        } else {
            Data d = new Data(node.val, true, node.val, node.val);
            ans = Math.max(ans, d.sum);
            return d;
        }
    }
}