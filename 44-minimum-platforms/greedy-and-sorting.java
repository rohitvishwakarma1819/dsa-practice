import java.util.*;
public class Solution {
    public static int calculateMinPatforms(int arr[], int dep[], int n) {
        // Write your code here.
        Arrays.sort(arr);
        Arrays.sort(dep);
        int j=0;
        int max=0;
        for(int i=0;i<n;++i){
            if(arr[i]>dep[j]){
                j++;
            }else{
                max++;
            }
        }
        return max;
    }
}

// T-> O(2LogN) +O(N)
// S-> O(1)