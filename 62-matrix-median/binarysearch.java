import java.util.ArrayList;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
        int r = matrix.size(), c = matrix.get(0).size();
        int low = matrix.get(0).get(0), high = low;
        for(int i=0;i<r;++i) {
            low = Math.min(matrix.get(i).get(0),low);
            high = Math.max(matrix.get(i).get(c-1), high);
        }
        int median =(r*c)/2 +1;
        while(low<high) {
            int mid = (low+high)/ 2;
            int count=0;
            for(int i=0;i<r;++i){
                count += upper_bound(matrix.get(i),mid);
            }
            
            if(count<median){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
	}
    
    public static int upper_bound(ArrayList<Integer> arr, int target) {
        int low=0, high = arr.size()-1;
        int ans=high+1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr.get(mid)<=target){
                low = mid+1;
            }else {
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
}

// T-> O(N log(max(matrix)))
// O(1)