class Solution {
    public int trap(int[] height) {
       int ans=0;
        int n=height.length;
        int l=0,r=n-1;
        int lmax = height[0];
        int rmax=height[r];
        
        while(l<r){
            if(height[l]<height[r]){
                lmax=height[l];
                while(l<r && height[l]<=lmax){
                    ans+=lmax-height[l];
                    l++;
                }
            }else{
                rmax=height[r];
                while(l<r && height[r]<=rmax){
                    ans+=rmax-height[r];
                    r--;
                }
            }
        }
        return ans;
        
    }
}

// T -> O(N)
// S -> O(1) 