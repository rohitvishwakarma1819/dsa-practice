class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        
        if(root == null) 
            return l;
        
        TreeNode node = root;
        
        while(node != null) {
            if(node.left == null) {
                l.add(node.val);
                node = node.right;
            }else {
                TreeNode temp = node.left;
                while(temp.right != null && temp.right != node) {
                    temp = temp.right;
                }
                if(temp.right == null) {
                    temp.right = node;
                    node = node.left;
                }else {
                    temp.right = null;
                    l.add(node.val);
                    node = node.right;
                }
            }
        }
        return l;
    }
}
// O(N)
// O(1)