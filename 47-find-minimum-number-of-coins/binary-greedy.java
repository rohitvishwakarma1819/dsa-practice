public class Solution
{
public static int findMinimumCoins(int amount)
    {
        // Write your code here.
        int[] change = new int[]{1,2,5,10,20,50,100,500,1000};
    int n=0;
    while(amount>0){
        amount-=getCoin(change,amount);
        n++;
    }
    return n;
    }
    
    public static int getCoin(int[] change,int amount){
       int l=0,h=change.length-1;
        int lastlow=0;
        while(l<=h){
            int m=(l+h)/2;
            if(change[m]==amount)
                return change[m];
            if(change[m]<amount){
                lastlow=m;
                
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return change[lastlow];
    }
}

// T-> O(NLogN)
// S-> O(1)