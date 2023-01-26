import java.util.Stack;
import java.util.Arrays;
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
        int[] arr = new int[stack.size()];
        int n = stack.size();
        for(int i = 0; i < n; ++i) {
            arr[i] = stack.pop();
        }
        Arrays.sort(arr);
        for(int num : arr) {
            stack.push(num);
        }
	}

}
// O(NlogN)
// O(N)