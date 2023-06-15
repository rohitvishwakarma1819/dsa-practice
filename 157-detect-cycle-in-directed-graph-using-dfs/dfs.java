import java.util.ArrayList;

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
        for (int i = 1; i < n; ++i) {
            if (dfs(i, graph, visited, inStack))
                return true;
        }
        return false;
    }

  public static boolean dfs(int node, ArrayList<Integer>[] graph, boolean[] visited, boolean[] inStack) {
      if (inStack[node]) return true;
      if (visited[node]) return false;

      visited[node] = true;
      inStack[node] = true;

      for (int neighbor: graph[node]) if (dfs(neighbor, graph, visited, inStack)) return true;
      inStack[node] = false;

      return false;
  }

// T -> O(N)
// S -> O(N + N + N)