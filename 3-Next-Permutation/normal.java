class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i;
        for(i=n-2;i>=0;--i){
            if(nums[i]<nums[i+1]){
                break;
            }
        }
        if(i==-1){
             reverse(nums,0,n-1);
            return;
        }
        for(int j=n-1;j>=0;--j){
            if(nums[i]<nums[j]){
                nums[i] = nums[i]^nums[j];
                nums[j] = nums[i]^nums[j];
                nums[i] = nums[i]^nums[j];
                reverse(nums,i+1,n-1);
                return;
            }
        }
    }
    
    public void reverse(int[] arr, int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start++]=arr[end];
            arr[end--]=temp;
        }
    }
}
// T-> O(N)
// S->O(1)




/*
    1,1,2
    1,2,1
    2,1,1
    
    1,1,2,3
    1,1,3,2
    1,2,1,3
    1,2,3,1
    1,3,1,2
    1,3,2,1
    
    2,1,1,3
    2,1,3,1
    2,3,1,1
    
    3,1,1,2
    

    1,2,3
    1,3,2
    2,1,3
    2,3,1
    3,1,2
    3,2,1
    1,2,3
    
    
    1,2,3,4
    1,2,4,3
    1,3,2,4
    1,3,4,2
    1,4,2,3
    1,4,3,2
    2,1,3,4
    2,1,4,3
    2,3,1,4
    2,3,4,1
    2,4,1,3
    2,4,3,1
    3,1,2,4
    3,1,4,2
    3,2,1,4
    3,2,4,1
    3,4,1,2
    3,4,2,1
    4,1,2,3
    4,1,3,2
    4,2,1,3
    4,2,3,1
    4,3,1,2
    4,3,2,1
    

    Intuition is that eg: 1, 3, 4, 2
    =>         4
             3   2
           1     
           then it is easily observable that elemets from rtl increases first and then decreses 
           so we need to find the first breaking and swap the element that just breaks the order ex 3 
           here with the element just greater to it on right eg: 4 here.
            so it will be[ 1 4 3 2]
            Then reverse  the remaining element becuase that will give us the smallest number just 
            greater than previous permutation

*/