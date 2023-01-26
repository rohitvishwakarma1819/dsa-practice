import java.util.*;
 class Pair {
        int i, j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

public class Solution{
   
	public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k){
		// Write your code here.
        PriorityQueue<Pair> pq = new PriorityQueue<>((i,j) -> (b.get(j.j) + a.get(j.i)) - (b.get(i.j) + a.get(i.i)));
        Collections.sort(a);
        Collections.sort(b);
        for(int i = 0;i < a.size(); ++i) {
            pq.add(new Pair(i, b.size() - 1));
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(k-- > 0) {
            Pair p = pq.poll();
            list.add(a.get(p.i) + b.get(p.j));
            if( p.j > 0) {
                p.j--;
                pq.add(p);
            }
        }
        
        return list;
	}
}

// T-> O(N log N)
// S -> O(N)