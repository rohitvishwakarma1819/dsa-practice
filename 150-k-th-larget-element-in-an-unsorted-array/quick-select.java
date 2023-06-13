class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            list.add(num);
        return partition(list, k);
    }

    public int partition(List<Integer> nums, int k) {
        int pivot = nums.get(new Random().nextInt(nums.size()));
        List<Integer> left = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot)
                right.add(num);
            else if (num == pivot)
                mid.add(num);
            else
                left.add(num);
        }

        if (k <= left.size())
            return partition(left, k);

        if (left.size() + mid.size() < k) {
            return partition(right, k - (left.size() + mid.size()));
        }

        return pivot;
    }
}