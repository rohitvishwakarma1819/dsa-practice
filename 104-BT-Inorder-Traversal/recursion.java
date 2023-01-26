class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inorderUtil( root, l);
        return l;
    }
    void inorderUtil(TreeNode root, List<Integer> l){
        if(root == null)
            return;
        inorderUtil(root.left,l);
        l.add(root.val);
        inorderUtil(root.right,l);
    }
}
// O(N)
// O(H)