class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int minSoFar = max;
        int maxSoFar = max;
        for (int i = 1; i < nums.length; ++i) {
            int num = nums[i];
            int temp = Math.max(num, Math.max(minSoFar * num, maxSoFar * num));
            minSoFar = Math.min(num, Math.min(minSoFar * num, maxSoFar * num));
            maxSoFar = temp;
            max = Math.max(maxSoFar, max);
        }

        return max;
    }
}

// T -> O(N)
// S -> O(1)
// Here intution is that if all nums[i] is +ve than max will be product of all
// numbers in nums else at each index i
// the max will be if nums[i] is -ve is min product ant i - 1(which will be
// negative since array contains negative numbers)
// multiplied by nums[i] or if nums[i] is +ve it would be max product at i - 1 *
// nums[i]

// Awesome approach