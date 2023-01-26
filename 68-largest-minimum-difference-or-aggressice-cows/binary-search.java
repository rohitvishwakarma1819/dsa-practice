import java.util.*;
public class Solution {

    public static int chessTournament(int[] positions, int n,  int c) 
	{
        Arrays.sort(positions);
        int low = 1;
        int high = positions[n-1] - positions[0];
        int ans = low;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(canLive(positions, mid, c)) {
                ans = mid;
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return ans;
    }
    
   public static boolean canLive(int[] nums, int gap, int players) {
        int placed = 1;
        int lastRoom = nums[0];
        
        for(int i=1; i < nums.length; ++i) {
            if(nums[i] >= lastRoom + gap) {
                placed++;
                lastRoom = nums[i];
            }
            if(placed >= players) return true;
            if(players-placed > nums.length - i - 1) return false;
        }
        if(placed >= players)
        return true;
       return false;
    }

}

// T -> O(2*(N log N))
// S -> O(1)