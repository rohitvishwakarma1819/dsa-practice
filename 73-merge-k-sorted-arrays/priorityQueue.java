import java.util.ArrayList;
import java.util.PriorityQueue;
public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        
        for(ArrayList<Integer> list : kArrays) {
            for(Integer a: list) pq.add(a);
        }
       
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()) ans.add(pq.poll());
        
        return ans;
	}
}

// T-> O(N)