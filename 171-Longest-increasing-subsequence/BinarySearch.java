class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int num : nums)
            bs(nums, list, num);
        return list.size();
    }

    public void bs(int[] nums, ArrayList<Integer> list, int target) {
        if (target > list.get(list.size() - 1)) {
            list.add(target);
            return;
        }
        int l = 0, h = list.size() - 1;

        int ans = 0;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (list.get(m) < target) {
                l = m + 1;
            } else {
                ans = m;
                h = m - 1;
            }
        }
        list.set(ans, target);
    }
}
// T -> O(NLogN)
// S -> O(N)