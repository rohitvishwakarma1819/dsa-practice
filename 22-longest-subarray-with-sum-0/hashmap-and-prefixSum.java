class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int ans=0;
        int sum=0;
        for(int i=0;i<n;++i){
            int num = arr[i];
            sum+=num;
            if(sum==0){
                ans = Math.max(ans,i+1);
            }
            if(!hmap.containsKey(sum)){
                hmap.put(sum,i);
            }else{
                ans = Math.max(ans,i-hmap.get(sum));
            }
        }
        return ans;
    }
}

// T -> O(N)
//  S-> O(N)