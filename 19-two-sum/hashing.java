class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;++i){
            int num = nums[i];
            int diff = target-num;
            if(hmap.containsKey(diff)){
                res[0]=hmap.get(diff);
                res[1]=i;
                break;
            }
            hmap.put(num,i);
        }
        return res;
    }
}
// T -> O(N)
// S -> O(N)