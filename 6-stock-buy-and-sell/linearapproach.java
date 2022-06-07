class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int min = prices[0];
        for(int i=1;i<prices.length;++i){
            int diff = prices[i]-min;
            if(diff<0){
                min=prices[i];
            }else{
                if(diff>max)
                    max=diff;
            }
        }
        return max;
    }
}
// T -> O(N)
// S -> O(1)