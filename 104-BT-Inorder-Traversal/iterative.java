class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        
        if(root == null) return l;
        
        HashSet<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.empty()) {
            if(stack.peek().left != null && !set.contains(stack.peek().left)) {
                stack.push(stack.peek().left);
            }else {
                TreeNode node = stack.pop();
                l.add(node.val);
                set.add(node);
                if(node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return l;
    }
}
// O(N)
// O(N)