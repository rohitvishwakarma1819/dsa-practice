class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
     List<Integer> l = new ArrayList<>();
        postorderUtil(root,l);
        return l;
    }
    void postorderUtil(TreeNode root, List<Integer> l){
        if(root == null)
            return;
        postorderUtil(root.left,l);
        postorderUtil(root.right,l);
        l.add(root.val);

    }
}
// O(N)
// O(H)