import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Write your code here.
        HashMap<Integer,Integer> freq = new HashMap<>();
        int xor=0;
        int count=0;
        for(int i=0;i<arr.size();++i){
            xor^=arr.get(i);
            int num = xor^x;
            if(xor==x)
                count++;
            if(freq.containsKey(num))
                count+=freq.get(num);
            freq.put(xor,freq.getOrDefault(xor,0)+1);
        }
        return count;
	}
}

// T -> O(N)
// S -> O(N)