import java.util.* ;
import java.io.*; 
import javafx.util.Pair;
public class Solution{
    public static int[][] pairSum(int[] nums, int target) {
        // Write your code here.
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num: nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        ArrayList<Pair<Integer,Integer>> res = new ArrayList<>();
        for(Map.Entry element : hm.entrySet()){
            int eValue = (int)element.getValue();
            if(eValue==0)
                continue;
            int num = (int)element.getKey();
            int diff = target-num;
            if(hm.containsKey(diff)){
                if(hm.get(diff)==0)
                    continue;
                
                if(diff==num){
                    int count=(hm.get(num)-1)*(hm.get(num))/2;
                    for(int i=0;i<count;++i){
                        res.add(new Pair(num,num));
                    }
                }else{
                    int prod = eValue*hm.get(diff);
                    int min = Math.min(num,diff);
                    int max = Math.max(num,diff);
                    for(int i=0;i<prod;++i){
                        res.add(new Pair(min,max));
                    }
                    hm.put(diff,0);
                }
                    hm.put(num,0);   
            }
        }
        int[][] ans = new int[res.size()][2];
            for(int i=0;i<res.size();++i){
                Pair<Integer,Integer> item = res.get(i);
                ans[i][0]= (int)item.getKey();
                ans[i][1] = (int)item.getValue();
                
            }
            Arrays.sort(ans,(a,b)->a[0]-b[0]);
            return ans;
    }
}

// T-> O(N) + O(N) + O(NlogN)
// S -> O(N) + O(pairssize)