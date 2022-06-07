class Solution {
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int maxSum=sum;
        for(int i=1;i<nums.length;++i){
            if(nums[i]>(sum+nums[i])){
                sum=nums[i];
            }else{
                sum+=nums[i];
            }
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}

// TC -> O(N)
// SC -> O(1)