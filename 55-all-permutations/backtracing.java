class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteUtil(nums,res,0);
        return res;
    }
    public void permuteUtil(int[] nums, List<List<Integer>> res, int fixedPos) {
        if(fixedPos == nums.length-1)
        {
            ArrayList<Integer> l = new ArrayList<>();
            for(int i:nums)
                l.add(i);
            res.add(l);
        }
        for(int i=fixedPos;i<nums.length;++i){
            int t = nums[i];
            nums[i]=nums[fixedPos];
            nums[fixedPos]=t;
            permuteUtil(nums,res,fixedPos+1);
            nums[fixedPos]=nums[i];
            nums[i]=t;
        }
        
    }
}

// T -> O(n!xn)
// S -> O(1)