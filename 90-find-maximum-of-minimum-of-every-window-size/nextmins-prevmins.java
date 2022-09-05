import java.util.*;
public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        int[] nextMins = new int[n];
        int[] prevMins = new int[n];
        int[] ans = new int[n];
        
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < n; ++i){
            while(!stack.empty() && a[stack.peek()] > a[i])
                nextMins[stack.pop()] = i;
            stack.push(i);
        }
        while(!stack.empty()) {
            nextMins[stack.pop()] = n;
        }
        
         for(int i = n-1; i >= 0; --i){
            while(!stack.empty() && a[stack.peek()] > a[i])
                prevMins[stack.pop()] = i;
            stack.push(i);
        }
        while(!stack.empty()) {
            prevMins[stack.pop()] = -1;
        }
        for(int i = 0; i < n; ++i) {
            ans[i] = Integer.MIN_VALUE;
        }
        for(int i = 0; i < n; ++i) {
            int len = nextMins[i] - prevMins[i] - 1;
              if (len > n) len -= 2;
            else len--;
            ans[len] = Math.max(ans[len], a[i]);
        }
        
        for(int i = n - 2; i >= 0; --i) {
//             if(ans[i] == 0)
            ans[i] = Math.max(ans[i + 1], ans[i]);
        }
        return ans;
    }
}
// O(N)
// O(3N)
// Auxiliary space O(N) stack*
