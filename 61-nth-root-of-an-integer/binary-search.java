public class Solution {
    public static double findNthRootOfM(int n, double m) {
        double eps = 1e-7;
        double low = 1, high = m;
        
        while(high-low > eps) {
            double mid = (low+high)/2;
            if(pow(mid,n) < m){
                low=mid;
            }else{
                high = mid;
            }
        }
        return low;
    }
    
    public static double pow(double num, int n){
       double ans=1.0;
        while(n-- >0){
            ans*=num;
        }
        return ans;
    }
}

// T -> N X Log(Mx10^d)
//     power         decimal places
// S -> (1)