class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] minmax = new int[2];
        
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q.add(root);
        q2.add(0);
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            int hd = q2.poll();
            
            if(!map.containsKey(hd)) {
                map.put(hd, node.data);
                minmax[0] = Math.min(minmax[0], hd);
                minmax[1] = Math.max(minmax[1], hd);
            }
            
            if(node.left != null) {
                q.add(node.left);
                q2.add(hd - 1);
            }
            
            if(node.right != null) {
                q.add(node.right);
                q2.add(hd + 1);
            }
        }
        for(int i = minmax[0]; i <= minmax[1]; ++i) {
            arr.add(map.get(i));
        }
        
        return arr;
    }
}
// T-> O(N)
// O-> O(N)