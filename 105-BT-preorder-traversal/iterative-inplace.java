class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        
        if(root == null) return pre;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = null;
        
        while(!stack.empty()) {
            node = stack.pop();
            pre.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return pre;
    }
}

// O(N)
// O(N)