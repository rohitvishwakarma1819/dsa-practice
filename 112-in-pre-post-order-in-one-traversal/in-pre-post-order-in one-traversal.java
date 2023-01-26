import java.util.* ;
import java.io.*; 
import javafx.util.Pair;
/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/

public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
        List<Integer> in = new LinkedList<>();
        List<Integer> pre = new LinkedList<>();
        List<Integer> post = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(in);ans.add(pre); ans.add(post);
        
        if(root == null) return ans;
        
        Stack<Pair<BinaryTreeNode<Integer>, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        
        while(!stack.empty()) {
            Pair<BinaryTreeNode<Integer>, Integer> p = stack.pop();
            if(p.getValue() == 1) {
                pre.add(p.getKey().data);
                stack.push(new Pair(p.getKey(), 2));
                if(p.getKey().left != null) {
                    stack.push(new Pair(p.getKey().left, 1));
                }
            }
            else if(p.getValue() == 2) {
                in.add(p.getKey().data); 
                stack.push(new Pair(p.getKey(), 3));
                if(p.getKey().right != null) {
                    stack.push(new Pair(p.getKey().right, 1));
                }
            }else {
                post.add(p.getKey().data);
            }
        }
        return ans;
    }
}

// O(N)
// O(N)