import java.util.* ;
import java.io.*; 
public class Solution {
  public static String fourSum(int[] nums, int target, int n) {
      // Write your code here.
      Arrays.sort(nums);
      for(int i=0;i<=(n-4);++i){
          for(int j=i+1;j<=(n-3);++j){
              for(int k=j+1;k<=(n-2);++k){
                  int sum = target-nums[i]-nums[j]-nums[k];
                  if(binSearch(nums,k+1,nums.length-1,sum)){
                      return "Yes";
                  }
              }
          }
      }
      return "No";
  }
  
    public static boolean binSearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}

// T -> O(N3)
// T -> O(N)