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
        boolean[] inStack = new boolean[n];
        for (int i = 1; i < n; ++i) {
            if (!visited[i] && dfs(i, visited, graph, 0)) {
                return "Yes";
            }
        }
        return "No";
    }

    public static boolean dfs(int index, boolean[] visited, ArrayList<Integer>[] graph, int parent) {
        // if (inStack[index]) return true;
        visited[index] = true;
        for (int neighbor : graph[index]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, graph, index)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

}

// T -> O(N + E)
// S -> O(N)