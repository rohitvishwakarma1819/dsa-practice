class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        int fact =1;
        for(int i=1;i<=n;++i) {
             arr.add(i);
            fact*=i;
        }
        String ans="";
        if(k==fact){
            for(int i=n-1;i>=0;--i)
                ans+=arr.get(i)+"";
            return ans;
        }
        while(arr.size()>0){
            int unitPermutation = fact/n;
            int index = (k/unitPermutation)- (k%unitPermutation==0?1:0);
            ans+=arr.get(index);
            arr.remove(index);
            k-=unitPermutation*index;
            fact/=n;
            n--;
        }
        for(int i=0;i<arr.size();++i)
            ans+=arr.get(i);
        
        return ans;
    }
}

// O(N)
// O(N)