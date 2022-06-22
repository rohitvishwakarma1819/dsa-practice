class Solution {
    public int majorityElement(int[] nums) {
        int ans=0;
        int count=0;
        for(int num:nums){
            if(count>0){
                if(num==ans)
                    count++;
                else
                    count--;
            }else{
                ans=num;
                count=1;
            }
        }
        return ans;
    }
}