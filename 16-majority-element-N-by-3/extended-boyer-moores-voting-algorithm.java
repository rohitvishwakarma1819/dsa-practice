class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n1=-1,n2=-1;
        int c1,c2;
        c1=c2=0;
        for(int num:nums){
            if(num==n1){
                c1++;
            }else if(num==n2){
                c2++;
            }else if(c1 == 0){
                c1=1;
                n1=num;
            }else if(c2==0){
                c2=1;
                n2=num;
                
            }else{
                c1--;
                c2--;
            }
        }
        
        c1=c2=0;
        for(int num:nums){
            if(n1==num)
                c1++;
            else if(n2==num)
                c2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(c1>nums.length/3)
            ans.add(n1);
        if(c2>nums.length/3)
            ans.add(n2);
        return ans;
    }
}

// T ->  O(N)+O(N)
// S ->  O(1)