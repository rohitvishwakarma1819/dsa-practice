import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        n++;
        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList();
        for (ArrayList<Integer> edge : edges) {
            graph[edge.get(0)].add(edge.get(1));
        }
        return bfs(graph);
    }

    public static boolean bfs(ArrayList<Integer>[] graph) {
        int[] indegrees = new int[graph.length];
        for (ArrayList<Integer> nodes : graph) {
            for (int v : nodes)
                indegrees[v]++;
        }

        Queue<Integer> q = new LinkedList();
        for (int i = 1; i < indegrees.length; ++i) {
            if (indegrees[i] == 0)
                q.add(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int neighbor : graph[node]) {
                if (--indegrees[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        return count != (graph.length - 1);
    }
}