import java.util.*;
public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        //Write your code here
      class Meeting {
            final int start, end, index;

            Meeting(int start, int end, int index) {
                this.start = start;
                this.end = end;
                this.index = index;
            }
        }
        int n = start.length;
        Meeting[] meetings = new Meeting[start.length];
        for (int i = 0; i < n; ++i) {
            meetings[i] = new Meeting(start[i], end[i], i + 1);
        }
        Arrays.sort(meetings, (a, b) -> {
            if (a.end == b.end) {
                return a.index - b.index;
            } else {
                return a.end - b.end;
            }
        });
        List<Integer> ans = new ArrayList<>();
        int currEnd = -1;
        for (int i = 0; i < n; ++i) {
            if (meetings[i].start > currEnd) {
                ans.add(meetings[i].index);
                currEnd = meetings[i].end;
            }
        }
        return ans;
    }
   
}


// T-> O(N) + O(NLogN) + O(N) => O(NLogN)
// S-> O(N)