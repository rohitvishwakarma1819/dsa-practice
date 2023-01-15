class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int ri = 0;
        for(ri=0;ri<n-1;++ri){
            if(nums[ri] > nums[ri+1]) {
                break;
            }
        }
        
        int l = 0, h = n-1;
        if(ri != n-1) {
            if(nums[0]<=target && target <= nums[ri]){
                h = ri;
            }else{
                l = ri+1;
            }
        }
        while(l<=h){
            int m = (l+h)/2;
            if(nums[m]==target) return m;
            if(nums[m] < target){
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return -1;
    }
}
// T -> O(N + logN)
// S -> O(1)