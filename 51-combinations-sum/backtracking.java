class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         Arrays.sort(candidates);
        return combSumUtil(candidates,target,0,0,0);
    }
    
    public List<List<Integer>> combSumUtil(int[] candidates, int target,int lastSum,int index, int count){
        List<List<Integer>> combinations = new ArrayList<>();
        
        for(int i=index;i<candidates.length;++i){
            int currSum = lastSum+candidates[i];
            if(currSum == target){
                ArrayList<Integer> l = new ArrayList<>();
                for(int j=0;j<count+1;++j) l.add(0);
                l.set(count,candidates[i]);
                combinations.add(l);
            }else if(currSum<target){
                List<List<Integer>> ll = combSumUtil(candidates,target,currSum,i,count+1);
                if(ll.size()>0){
                    for(List<Integer> l: ll){
                        l.set(count,candidates[i]);
                        combinations.add(l);
                    }
                }
            }else{
                break;
            }
        }
        return combinations;
    }
}
// T -> O(2^N) worst case
// S -> O(N)