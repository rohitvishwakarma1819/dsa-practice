class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solve(word1, word2, 0, 0, dp);
    }

    public int solve(String word1, String word2, int i, int j, int[][] dp) {
        if (j == word2.length())
            return word1.length() - i;
        if (i == word1.length())
            return word2.length() - j;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = 0 + solve(word1, word2, i + 1, j + 1, dp);
        } else {
            int max = Integer.MAX_VALUE;
            // replace
            max = Math.min(max, 1 + solve(word1, word2, i + 1, j + 1, dp));
            // delete
            max = Math.min(max, 1 + solve(word1, word2, i + 1, j, dp));
            // insert
            max = Math.min(max, 1 + solve(word1, word2, i, j + 1, dp));
            return dp[i][j] = max;
        }
    }
}
// T -> O(N*M)
// S -> O(N*M) + O(N + M)