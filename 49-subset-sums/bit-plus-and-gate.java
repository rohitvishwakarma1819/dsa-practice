class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        int totalSubsets = 1<<N;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        for(int i=1;i<totalSubsets;++i){
            int sum=0;
            for(int j=0;j<N;++j){
                if((i & (1<<j)) >0)
                sum+=arr.get(j);
            }
            ans.add(sum);
        }
        return ans;
    }
}

// T-> O(2^N*N)
// S-> O(1)