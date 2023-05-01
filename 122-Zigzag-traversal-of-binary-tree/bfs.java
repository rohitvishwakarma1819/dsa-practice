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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q.add(root);
        List<Integer> list = new ArrayList<Integer>();

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            list.add(node.val);
            if (node.left != null) {
                q2.add(node.left);
            }
            if (node.right != null) {
                q2.add(node.right);
            }

            if (q.isEmpty()) {
                if (ans.size() % 2 == 0) {
                    ans.add(list);
                } else {
                    Collections.reverse(list);
                    ans.add(list);
                }
                list = new ArrayList<>();
                q = q2;
                q2 = new LinkedList<>();
            }
        }
        return ans;
    }
}