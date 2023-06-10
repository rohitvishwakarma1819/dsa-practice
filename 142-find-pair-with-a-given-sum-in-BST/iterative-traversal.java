/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> small = new Stack<>();
        Stack<TreeNode> large = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            small.push(node);
            node = node.left;
        }
        node = root;
        while (node != null) {
            large.push(node);
            node = node.right;
        }

        while (small.peek() != large.peek()) {
            int sum = small.peek().val + large.peek().val;
            if (sum == k) return true;
            if (sum < k) {
                node = small.pop();
                node = node.right;
                while (node != null) {
                    small.push(node);
                    node = node.left;
                }

            } else {
                node = large.pop();
                node = node.left;
                while (node != null) {
                    large.push(node);
                    node = node.right;
                }
            }
        }
        return false;

    }
}
// TC -> O(N)
// SC -> O(N)