class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int[][] dp = new int[201][200 * 100 + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        if (total % 2 != 0)
            return false;
        return solve(nums, 0, total / 2, dp);
    }

    public boolean solve(int[] nums, int ind, int target, int[][] dp) {
        if (target == 0)
            return true;
        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;
        if (ind == nums.length - 1) {
            if (target == nums[ind]) {
                dp[ind][target] = 1;
                return true;
            }
            dp[ind][target] = 2;
            return false;
        }
        boolean notTake = solve(nums, ind + 1, target, dp);
        boolean take = false;
        if (target >= nums[ind]) {
            take = solve(nums, ind + 1, target - nums[ind], dp);
        }
        dp[ind][target] = (take || notTake) ? 1 : 2;
        return (take || notTake);
    }
}