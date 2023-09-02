class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        boolean[][] dp = new boolean[201][200 * 100 + 1];
        for (int i = 0; i <= nums.length; ++i)
            dp[i][0] = true;
        if (total % 2 != 0)
            return false;
        int target = total / 2;
        for (int i = 1; i <= nums.length; ++i) {
            for (int j = 1; j <= target; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}