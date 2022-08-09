// There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
// What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

// Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.


import java.util.*;
public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here
        class Meeting {
            int start,end;
            Meeting(int s,int e){
                start = s;
                end = e;
            }
        }
        PriorityQueue<Meeting> pq = new PriorityQueue<>((a,b)->a.end-b.end);
        for(int i = 0;i < start.size();++i){
            pq.add(new Meeting(start.get(i),end.get(i)));
        }
        int lastEnd = -1;
        int meetingsCount=0;
        while(!pq.isEmpty()){
            Meeting m = pq.poll();
            if(m.start>=lastEnd){
                lastEnd=m.end;
                meetingsCount++;
            }
        }
        return meetingsCount;
    }
}