class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        solve(coins, dp, amount);
        if (dp[amount] == Integer.MAX_VALUE)
            return -1;
        return dp[amount];
    }

    public int solve(int[] coins, int[] dp, int amount) {
        if (amount == 0)
            return 0;
        if (dp[amount] != -1)
            return dp[amount];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                min = Math.min(min, solve(coins, dp, amount - coin));
            }
        }
        if (min == Integer.MAX_VALUE) {
            return dp[amount] = min;
        }
        return dp[amount] = min + 1;
    }
}

// T -> O(amount)
// S -> O(amount)