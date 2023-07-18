class Solution {
    int ans = 0;

    public int lengthOfLIS(int[] nums) {
        ans = 0;
        int[][] dp = new int[nums.length][nums.length + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solve(nums, 0, -1, dp);
    }

    public int solve(int[] nums, int index, int prevIndex, int[][] dp) {
        if (index == nums.length)
            return 0;
        if (dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];

        int notTake = solve(nums, index + 1, prevIndex, dp);
        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + solve(nums, index + 1, index, dp);
        }
        return dp[index][prevIndex + 1] = Math.max(notTake, take);
    }
}

// T -> O(N^2)
// S -> O(N^2) + O(N)