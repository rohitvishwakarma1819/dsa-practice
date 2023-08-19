class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int[][] dp = new int[m + 2][m + 2];
        int[] newCuts = new int[m + 2];
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[m + 1] = n;
        for (int i = 0; i <= m + 1; ++i)
            Arrays.fill(dp[i], -1);
        return solve(newCuts, dp, 0, newCuts.length - 1);
    }

    public int solve(int[] cuts, int[][] dp, int l, int r) {
        if (dp[l][r] != -1)
            return dp[l][r];
        if (r - l == 1)
            return 0;
        int res = cuts[r] - cuts[l];
        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i < r; ++i) {
            min = Math.min(min, solve(cuts, dp, l, i) + solve(cuts, dp, i, r));
        }
        return dp[l][r] = res + min;
    }
}