class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        
        if(root == null) return l;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        
        while(true) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }else {
                if(stack.empty()) break;
                node = stack.pop();
                l.add(node.val);
                node = node.right;
            }
        }
        return l;
    }
}
