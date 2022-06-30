class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
         Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n=arr.length;
        int K=0;
        for(int i=0;i<(n-2);++i){
            int l = i+1;
            int r = n-1;
            while(l<r) {
                int total = arr[i]+arr[l]+arr[r];
                if(total==K){
                    ArrayList<Integer> sol = new ArrayList<>();
                    sol.add(arr[i]);
                    sol.add(arr[l]);
                    sol.add(arr[r]);
                    ans.add(sol);
                    int x=arr[l];
                    int y=arr[r];
                    while(l<r && arr[l]==x)
                        l++;
                    while(l<r && arr[r]==y)
                        r--;
                }else if(total<K){
                    l++;
                }else{
                    r--;
                }
            }
           
            while(i<(n-1) && arr[i]==arr[i+1]) 
                i++;
        }
        return ans;
    }
}

// T-> O(NlogN) + O(N2) ~> O(N2)
// S -> O(M)