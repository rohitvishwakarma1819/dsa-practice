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