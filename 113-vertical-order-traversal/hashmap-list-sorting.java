/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Data {
        TreeNode node;
        int col;
        public Data(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
        int[] minmax = new int[] {0, 0};
        List<List<Integer>> ans = new LinkedList<>();
        
        Queue<Data> q1 = new LinkedList<>();
        Queue<Data> q2 = new LinkedList<>();
        q1.add(new Data(root, 0));
        HashMap<Integer, List<Integer>> currentMap = new HashMap<>();
        int min = 0, max = 0;
        while(!q1.isEmpty()) {
            Data data = q1.poll();
            
            min = Math.min(min, data.col);
            max = Math.max(max, data.col);
            
            if(data.node.left != null) {
                q2.add(new Data(data.node.left, data.col - 1));
            }
             if(data.node.right != null) {
                q2.add(new Data(data.node.right, data.col + 1));
            }
            List<Integer> list = currentMap.getOrDefault(data.col, new LinkedList<Integer>());
            currentMap.put(data.col, list);
            list.add(data.node.val);
            
            if(q1.isEmpty()) {
                for(Integer col : currentMap.keySet()) {
                    List<Integer> l = currentMap.get(col);
                    Collections.sort(l);
                    List<Integer> l2 = hashmap.getOrDefault(col, new LinkedList<Integer>());
                    hashmap.put(col, l2);
                    for(int i : l)
                        l2.add(i);
                }
                
                q1 = q2;
                q2 = new LinkedList<>();
                currentMap = new HashMap<>();
            }
        }
        
        for(int i = min; i <= max; ++i) {
            ans.add(hashmap.get(i));
        }
        
        return ans;
        
    }
    
}