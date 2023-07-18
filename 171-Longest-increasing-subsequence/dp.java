class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; ++i) {
            int max = 0;
            for (int j = i - 1; j >= 0; --j) {
                if (nums[j] < nums[i])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;

    }
}
// T -> O(N^2)
// S -> O(N)