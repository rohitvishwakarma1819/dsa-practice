import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
		// Write your code here.
        int size = permutation.size();
        int j = size-1;
        int i = j-1;
        boolean found = false;
        for(int x = i;x>=0;--x){
            if(permutation.get(x)<permutation.get(j)){
                found = true;
                i=x;
                break;
            }else{
                j=x;
            }
//             i=x;
        }if(!found){
             Collections.sort(permutation);
            return permutation;
        }else{
            for(int h = size-1;j>=0;--h){
                if(permutation.get(i)<permutation.get(h)){
                    int t = permutation.get(i);
                permutation.set(i,permutation.get(h));
            permutation.set(h,t);
            Collections.sort(permutation.subList(i+1,size));
                    break;
                }
            }
            
        }
        return permutation;
	}
}

// T.C. O(nlogn)
// S.C. O(1)