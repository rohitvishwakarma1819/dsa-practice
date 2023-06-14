import java.util.*;

public class Solution {

    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        n++;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        if (bfs(visited, graph)) {
            return "Yes";
        }
        return "No";
    }

    public static boolean bfs(boolean[] visited, ArrayList<Integer>[] graph) {
        int[] parent = new int[visited.length];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new LinkedList();
        for (int i = 1; i < visited.length; ++i) {
            if (!visited[i]) {
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int neighbor : graph[node]) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            parent[neighbor] = node;
                            q.add(neighbor);
                        } else if (parent[node] != neighbor) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

}