
class Solution {
    static int matrixMultiplication(int N, int arr[]) {
        int[][] dp = new int[N][N];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solve(arr, 1, N - 1, dp);
    }

    public static int solve(int[] arr, int l, int r, int[][] dp) {
        if (l == r)
            return 0;
        if (dp[l][r] != -1)
            return dp[l][r];
        int min = Integer.MAX_VALUE;
        for (int i = l; i < r; ++i) {
            int steps = arr[l - 1] * arr[i] * arr[r] + solve(arr, l, i, dp) + solve(arr, i + 1, r, dp);
            min = Math.min(min, steps);
        }
        return dp[l][r] = min;
    }
}
// T -> O(N^3)
// S -> O(N^2) + O(N) [Stack space]