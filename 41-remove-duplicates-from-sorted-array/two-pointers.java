class Solution {
    public int removeDuplicates(int[] nums) {
        int pos=1;
        int lastnum = nums[0];
        for(int i=1;i<nums.length;++i){
            if(nums[i] != lastnum){
                nums[pos++] = nums[i];
            }
            lastnum = nums[i];
        }
        return pos;
    }
}

// T -> O(N)
// S -> O(1)