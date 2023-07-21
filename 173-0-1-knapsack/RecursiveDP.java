class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        // your code here
        int[][] dp = new int[wt.length][1001];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solve(W, wt, val, dp, 0);
    }

    public static int solve(int w, int[] wt, int[] val, int[][] dp, int i) {
        if (i == wt.length || w <= 0)
            return 0;
        if (dp[i][w] != -1)
            return dp[i][w];
        int taken = 0;
        if (wt[i] <= w) {
            taken = val[i] + solve(w - wt[i], wt, val, dp, i + 1);
        }
        taken = Math.max(taken, solve(w, wt, val, dp, i + 1));
        return dp[i][w] = taken;
    }
}
// T -> O(N*M)
// S -> O(N*M)