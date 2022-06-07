import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static void sort012(int[] nums)
    {
        //Write your code here
         int l=0;
        int m=0;
        int h = nums.length-1;
        while(m<=h){
            switch(nums[m]){
                case 0:
                    swap(nums,l++,m++);
                    break;
                case 1:
                    m++;
                    break;
                case 2:
                    swap(nums,m,h--);
                    break;
            }
        }
    }
    public static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

// TS -> O(N)
// SC -> O(1)