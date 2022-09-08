class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)return nums[0];
        int l = 0, h = nums.length-1;
        while(l<=h){
            int m = (l+h)/2;
            if(m==0 || m== nums.length-1)return nums[m];
            if(m%2==0){
                if(nums[m]==nums[m+1]){
                    l=m+2;
                }else{
                    if(nums[m-1]!=nums[m])return nums[m];
                    h=m-2;
                }
            }else {
                if(nums[m] == nums[m-1]){
                    l = m+1;
                }else{
                    if(nums[m] != nums[m+1]) return nums[m];
                    h=m-1;
                }
            }
        }
        return -1;
        
    }
}

// T-> O(log n)
// S -> O(1)