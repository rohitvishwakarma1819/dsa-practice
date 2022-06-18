class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nsum(nums,0,target,4,4,0);
        
    }
    
    public List<List<Integer>> nsum(int[] nums, int start, int target,int n, int originalN,int sumTillNow){
        
        List<List<Integer>> list = new ArrayList<>();
        if(n == 2) {
            HashSet<Integer> hset = new HashSet<>();
            int actualSum = target-sumTillNow;
            for(int i=start;i<nums.length;++i){
                int diff = actualSum-nums[i];
                if(hset.contains(diff)){
                    ArrayList<Integer> solution = new ArrayList<>();
                    for(int j=0;j<originalN;++j)
                        solution.add(j);
                    solution.set(originalN-1,nums[i]);
                    solution.set(originalN-2,diff);
                    list.add(solution);
                    hset.remove(diff);
                    while(i<(nums.length-1) && nums[i]==nums[i+1])
                        ++i;
                }
                hset.add(nums[i]);
            }
           
        }else{
            for(int i=start;i<=(nums.length-n);++i){
                int total = sumTillNow+nums[i];
                if(total>0 && target<0)
                    continue;
                List<List<Integer>> tempList = nsum(nums,i+1,target,n-1,originalN,total);
                for(List<Integer> l : tempList){
                    l.set(originalN-n,nums[i]);
                    list.add(l);
                }
                while(i<=(nums.length-n) && nums[i]==nums[i+1])
                    i++;
            }
        }
        return list;
    }
}

// T -> O(N3)
// T -> O(N)