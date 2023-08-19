class Solution {
    static int palindromicPartition(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return solve(str, 0, n - 1, dp);
    }

    static int solve(String str, int l, int r, int[][] dp) {
        if (l == r)
            return 0;
        if (dp[l][r] != -1)
            return dp[l][r];
        int min = Integer.MAX_VALUE;
        if (isPalindrome(str, l, r))
            return dp[l][r] = 0;
        for (int i = l; i < r; ++i) {
            min = Math.min(min, 1 + solve(str, l, i, dp) + solve(str, i + 1, r, dp));
        }
        return dp[l][r] = min;
    }

    static boolean isPalindrome(String str, int l, int r) {
        while (l <= r) {
            if (str.charAt(l++) != str.charAt(r--))
                return false;
        }
        return true;
    }
}