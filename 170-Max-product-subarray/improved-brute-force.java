class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prod = 1;
        int max = nums[0];
        for (int i = 0; i < n; ++i) {
            prod *= nums[i];
            if (prod == 0) {
                prod = 1;
                max = Math.max(0, max);
                continue;
            }
            max = Math.max(max, prod);
        }
        prod = 1;
        for (int i = n - 1; i >= 0; --i) {
            prod *= nums[i];
            if (prod == 0) {
                prod = 1;
                continue;
            }
            max = Math.max(max, prod);
        }
        return max;
    }
}

// T -> O(N)
// S -> O(1)