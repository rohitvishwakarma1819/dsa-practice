import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int nums[]) {
       Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> currList = new ArrayList<>();
        subsetUtil(nums,ans,currList,0);
        Collections.sort(ans,(a,b) -> {
            int al = a.size();
            int bl = b.size();
            int i=0,j=0;
            while(i<al&&j<bl){
                if(a.get(i)!=b.get(j))
                    return a.get(i)-b.get(j);
                i++;
                j++;
            }
            if(al<bl)
                return -1;
            return 1;
        });
        return ans;
    }
    
    public static void subsetUtil(int[] nums, ArrayList<ArrayList<Integer>> subsets,ArrayList<Integer> currSubset,int i){
         if (i >= nums.length) {
            ArrayList<Integer> l = new ArrayList<>();
            for (int num : currSubset) {
                l.add(num);
            }
            subsets.add(l);
            return;
        }
        currSubset.add(nums[i]);
        subsetUtil(nums, subsets, currSubset, i + 1);
        int next = currSubset.get(currSubset.size() - 1);
        currSubset.remove(currSubset.size() - 1);
        if (currSubset.size() > 0) {
            if (currSubset.get(currSubset.size() - 1) == next)
                return;
        }
        subsetUtil(nums, subsets, currSubset, i + 1);

    }

}