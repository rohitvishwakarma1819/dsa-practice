class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int n = nums2.length;
        int[] nextGreaters = new int[nums2.length];
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums1.length; ++i) {
            map.put(nums1[i], i);
        }
        
        for(int i = n - 1; i >= 0; --i) {
            while(!stack.empty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            
            if(stack.empty()) {
                nextGreaters[i] = -1;
            }else {
                nextGreaters[i] = stack.peek();
            }
            stack.add(nums2[i]);
            if(map.containsKey(nums2[i])) {
                ans[map.get(nums2[i])] = nextGreaters[i];
            }
        }
        
        return ans;
    }
}