class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
      LinkedList<Integer> post = new LinkedList<>();
        
        if(root == null) return post;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = root;
        
        while(!stack.empty()) {
            node = stack.pop();
            post.addFirst(node.val);
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
        return post;
    }
}
// O(N)
// O(H)