class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        preorderTraversalUtil(root,l);
        return l;
    }
    void preorderTraversalUtil(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        preorderTraversalUtil(root.left,list);
        preorderTraversalUtil(root.right,list);
        
        
    }
}