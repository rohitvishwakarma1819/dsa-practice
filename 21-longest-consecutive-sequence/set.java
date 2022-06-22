import java.util.* ;
import java.io.*; 
public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        HashSet<Integer> hset = new HashSet<>();
        for(int num:arr)
            hset.add(num);
        int ans=1;
        for(int num:arr){
            if(!hset.contains(num-1)){
                int count=1;
                int next=num+1;
                while(hset.contains(next++))
                    count++;
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}
// T-> O(N) + O(N) + O(N)
//  fillset | linear iteration   |  finding


// S -> O(N)