//{ Driver Code Starts

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            int edges[][] = new int[E][3];
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }
            ot.println(new Solution().spanningTree(V, E, edges));
        }
        ot.close();
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int spanningTree(int V, int E, int edges[][]) {
        // Code Here.
        Set<Integer> set = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        set.add(0);
        ArrayList<int[]>[] graph = new ArrayList[V];
        for (int i = 0; i < V; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[] { v, w });
            graph[v].add(new int[] { u, w });
        }
        for (int[] edge : graph[0]) {
            pq.add(new int[] { 0, edge[0], edge[1] });
        }
        int sum = 0;
        while (set.size() < V) {
            int[] arr = pq.poll();
            int u = arr[0], v = arr[1], w = arr[2];
            if (set.contains(v))
                continue;
            set.add(v);
            sum += w;
            for (int[] edge : graph[v]) {
                if (!set.contains(edge[0])) {
                    pq.add(new int[] { v, edge[0], edge[1] });
                }
            }
        }
        return sum;
    }
}

// T -> O(ELogV)
// S -> O(E + V) -> O(PriorityQueue + HashSet)