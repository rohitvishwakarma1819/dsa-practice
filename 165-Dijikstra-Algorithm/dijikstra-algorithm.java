
//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.dijkstra(V, adj, S);

            for (i = 0; i < V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        ArrayList<int[]>[] graph = new ArrayList[V];
        for (int i = 0; i < V; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < adj.size(); ++i) {
            for (int j = 0; j < adj.get(i).size(); ++j) {
                int to = adj.get(i).get(j).get(0), dis = adj.get(i).get(j).get(1);
                graph[i].add(new int[] { to, dis });
                graph[to].add(new int[] { i, dis });
            }
        }

        int[] dis = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        dis[S] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int[] neighbor : graph[node]) {
                int to = neighbor[0], d = neighbor[1];
                if ((dis[node] + d) < dis[to]) {
                    dis[to] = dis[node] + d;
                    q.add(to);
                }
            }
        }
        return dis;
    }
}

// T -> O(N^2)
// S -> O(N^2)