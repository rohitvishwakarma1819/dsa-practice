class Solution {
    public int majorityElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for(int num:nums){
            if(stack.empty() || stack.peek()==num){
                stack.push(num);
            }else{
                stack.pop();
            }
        }
        return stack.pop();
    }
}