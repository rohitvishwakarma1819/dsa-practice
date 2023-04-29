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
    public List<List<Integer>> levelOrder(TreeNode root) {
        int level = 0;
        List<List<Integer>> l = new ArrayList<>();
        if (root == null)
            return l;

        List<Integer> l1 = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        Queue<TreeNode> q2 = new LinkedList<>();

        int index = 0;
        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();
            l1.add(node.val);
            if (node.left != null) {
                q2.add(node.left);
            }
            if (node.right != null) {
                q2.add(node.right);
            }

            if (q1.isEmpty()) {
                q1 = q2;
                l.add(l1);
                l1 = new ArrayList<>();
                q2 = new LinkedList<>();
            }
        }
        return l;
    }
}