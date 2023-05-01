/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pl = new LinkedList<>();
        find(root, p, pl);
        while (!pl.isEmpty()) {
            TreeNode last = pl.poll();
            if (has(last, q)) {
                return last;
            }
        }
        return null;
    }

    public TreeNode find(TreeNode root, TreeNode p, LinkedList<TreeNode> l) {
        if (root == null)
            return null;
        if (root.val == p.val) {
            l.add(root);
            return root;
        }

        TreeNode left = find(root.left, p, l);
        TreeNode right = find(root.right, p, l);
        if (left != null || right != null) {
            l.add(root);
            return root;
        }
        return null;

    }

    public boolean has(TreeNode root, TreeNode q) {
        if (root == null)
            return false;
        if (root.val == q.val)
            return true;
        return has(root.left, q) || has(root.right, q);
    }
}