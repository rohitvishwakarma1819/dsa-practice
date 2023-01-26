class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i:nums)
            hmap.put(i,hmap.getOrDefault(i,0)+1);
        PriorityQueue<Integer> q = new PriorityQueue<>((n1,n2) -> hmap.get(n1)-hmap.get(n2));
        
        for(int i: hmap.keySet()) {
            q.add(i);
            if(q.size()>k)
                q.poll();
        }
        
        int[] ans = new int[k];
        for(int i=0;i<k;++i)
            ans[i]=q.poll();
        return ans;
    }
}