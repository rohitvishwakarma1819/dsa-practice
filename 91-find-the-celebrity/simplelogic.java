public class Solution {
	public static int findCelebrity(int n) {
        // Write your code here.
        int candidate = 0;
        for(int i = 1; i < n; ++i) {
            if(Runner.knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; ++i) {
            
            if(i != candidate && !Runner.knows(i, candidate)) return -1;
            if(i != candidate && Runner.knows(candidate, i)) return -1;
        }
        return candidate;
    }
}
// O(N)
//O(1)