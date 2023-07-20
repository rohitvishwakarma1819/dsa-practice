class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return dfs(text1, text2, m - 1, n - 1, dp);
    }

    public int dfs(String text1, String text2, int i, int j, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j))
            return dp[i][j] = 1 + dfs(text1, text2, i - 1, j - 1, dp);
        return dp[i][j] = Math.max(dfs(text1, text2, i, j - 1, dp), dfs(text1, text2, i - 1, j, dp));
    }
}
// T -> O(N*M)
// S -> O(N * M) + O(N + M)