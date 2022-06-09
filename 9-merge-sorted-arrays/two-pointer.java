class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1=m-1;
        int l2=n-1;
        int cPos=m+n-1;
        if(n==0 )
            return;
        
        while(l1>=0 && l2>=0){
            if(nums1[l1]<nums2[l2]){
                nums1[cPos--] = nums2[l2--];
                
            }else{
                nums1[cPos--]=nums1[l1--];
            }
        }
        while(l2>=0){
            nums1[cPos--]=nums2[l2--];
        }
    }
}

// T-> O(N)
// S -> O(1)