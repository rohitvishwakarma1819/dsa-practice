public class Solution {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
          HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<BinaryTreeNode> q1 = new LinkedList<>();
        Queue<BinaryTreeNode> q2 = new LinkedList<>();
        Queue<Integer> hd1 = new LinkedList<>();
        Queue<Integer> hd2 = new LinkedList<>();
        q1.add(root);
        hd1.add(0);
        int min = 0, max = 0;
        while(!q1.isEmpty()) {
            BinaryTreeNode node= q1.poll();
            int hd = hd1.poll();
            if(hd < min) min = hd;
            if(hd > max) max = hd;
            
            map.put(hd, node.val);
            
            if(node.left != null) {
                q2.add(node.left);
                hd2.add(hd - 1);
            }
                
            if(node.right != null) {
                q2.add(node.right);
                hd2.add(hd + 1);
            }
            if(q1.isEmpty()) {
                q1 = q2;
                q2 = new LinkedList<>();
                hd1 = hd2;
                hd2 = new LinkedList<>();
            }
        }
         for(int i = min; i <= max; ++i) {
            ans.add(map.get(i));
            // ans.add(i);
        }
        return ans;       
    }
}

// O(N)
//O(N)