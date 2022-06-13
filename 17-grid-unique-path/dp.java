class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        arr[m-1][n-1]=1;
        return fillPath(arr,0,0);
        
    }
    public int fillPath(int[][] dp, int r, int c){
        if(r>=dp.length || c>=dp[0].length){
            return 0;
        }
        if(dp[r][c]!=0)
            return dp[r][c];
        
        int bottomR=r+1;
        int rightC=c+1;
        dp[r][c] = fillPath(dp,bottomR,c) +fillPath(dp,r,rightC);
        return dp[r][c];
    }
}

// T-> O(N X M)
// S -> O(N X M)