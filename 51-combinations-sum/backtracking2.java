// Given an integer array 'ARR' of size 'N' and an integer 'K', return all the subsets of 'ARR' which sum to 'K'.
// Subset of an array 'ARR' is a tuple that can be obtained from 'ARR' by removing some (possibly all) elements of 'ARR'.
// Note :
// The order of subsets is not important. 

// The order of elements in a particular subset should be in increasing order of the index.
import java.util.*;
public class Solution 
{
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> currList = new ArrayList<>();
         combSumUtil(arr,k,0,0,ans,currList);
        return ans;
    }
    
    public static void combSumUtil(ArrayList<Integer> candidates, int target,int lastSum,int index,ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> currList){
        for(int i=index;i<candidates.size();++i){
           int currSum = lastSum+candidates.get(i);
            if(currSum==target){
                currList.add(candidates.get(i));
                ans.add(new ArrayList<>(currList));
                currList.remove(currList.size()-1);
            }
                
                currList.add(candidates.get(i));
                combSumUtil(candidates,target,currSum,i+1,ans,currList);
                currList.remove(currList.size()-1);
            
        }
    }
}
// T -> O(2^N) worst case
// S -> O(N)