/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer> list = new ArrayList<>();
        util(A, B, list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            arr[i] = list.get(i);
        }
        
        return arr;
    }
    
    public void util(TreeNode node, int B, ArrayList<Integer> list) {
        if (node == null) return;
        
        list.add(node.val);
        if (node.val == B) return;
        
        util(node.left, B, list);
        if (list.get(list.size() - 1) == B) return;
        
        util(node.right, B, list);
        if (list.get(list.size() - 1) == B) return;
        list.remove(list.size() - 1);
    }
}

// O(N)
// O(H) + O(Path.length)