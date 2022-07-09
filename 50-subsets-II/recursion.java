class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        subsetUtil(nums,ans,currList,0);
        return ans;
    }
    
    public void subsetUtil(int[] nums, List<List<Integer>> subsets,List<Integer> currSubset,int i){
         if (i >= nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int num : currSubset) {
                l.add(num);
            }
            subsets.add(l);
            return;
        }
        currSubset.add(nums[i]);
        subsetUtil(nums, subsets, currSubset, i + 1);
        int next = currSubset.get(currSubset.size() - 1);
        currSubset.remove(currSubset.size() - 1);
        if (currSubset.size() > 0 && currSubset.get(currSubset.size() - 1) == next)  return;
        subsetUtil(nums, subsets, currSubset, i + 1);

    }
}

// T-> O(2^N)
// S-> O(1)