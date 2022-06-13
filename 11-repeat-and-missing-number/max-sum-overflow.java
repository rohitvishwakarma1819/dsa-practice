import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        int repeated=0;
        for(int i=0;i<n;++i){
            int index=arr.get(i)%(n+1)-1;
            if(arr.get(index)<(n+1)){
                arr.set(index,arr.get(index)+(n+1));
            }else{
                repeated = index+1;
                break;
            }
        }
        int total = 0; 
        for(int i=0;i<n;++i){
            if(arr.get(i)>n)
                arr.set(i,arr.get(i)-n-1);
            total+=arr.get(i);
        }
        int missing = (n*(n+1)/2)-(total-repeated);
        return new int[]{missing,repeated};
    }
}

// T-> O(N)+O(N)
// S-> O(1)