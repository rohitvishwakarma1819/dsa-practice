// Brute Force Approach
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        long[] prod = new long[n];
        long max = nums[0];
        for (int i = 0; i < n; ++i)
            prod[i] = nums[i];
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                prod[j] = prod[j] * nums[i];
                max = Math.max(max, nums[i]);
                max = Math.max(max, prod[j]);
            }
        }
        return (int) max;
    }
}
// T -> O(N2)
// S -> O(N)