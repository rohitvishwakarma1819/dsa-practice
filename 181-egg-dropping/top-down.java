class Solution {
    // Function to find minimum number of attempts needed in
    // order to find the critical floor.
    static int eggDrop(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solve(n, k, dp);
    }

    static int solve(int e, int f, int[][] dp) {
        if (e == 0)
            return 0;
        if (e == 1 || f == 1)
            return f;
        if (dp[e][f] != -1)
            return dp[e][f];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < f; ++i) {
            min = Math.min(min, Math.max(solve(e - 1, i, dp), solve(e, f - 1 - i, dp)));
        }
        return dp[e][f] = min + 1;
    }
    /*
     * static int eggDrop(int n, int k)
     * {
     * int[][] dp = new int[n + 1][k + 1];
     * for (int i = 1; i <= k; ++i) dp[1][i] = i;
     * for (int i = 1; i <= n; ++i) dp[i][1] = 1;
     * for(int i = 2; i <= n; ++i) {
     * for (int j = 2; j <= k; ++j) {
     * dp[i][j] = Integer.MAX_VALUE;
     * for (int m = 0; m < j; ++m) {
     * dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][m], dp[i][j - 1 - m]));
     * }
     * dp[i][j]++;
     * }
     * }
     * return dp[n][k];
     * }
     * 
     * 10
     * 9
     * 8
     * 7
     * 6
     * 5
     * 4
     * 3
     * 2
     * 1
     */
}