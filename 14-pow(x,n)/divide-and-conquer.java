class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1.0;
        long nn=n;
        nn = Math.abs(n);
        double ans=1.0;
        while(nn>0){
            if(nn%2==0){
                x = x*x;
                nn/=2;
            }else{
                ans *= x;
                nn--;
            }
        }
        if(n<0) ans = 1.0/ans;
        return ans;
        
         
    }
}

// T->O(log2N)
// S->O(1)