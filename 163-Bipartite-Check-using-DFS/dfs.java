class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                if (!solve(graph, i, colors, visited, 2))
                    return false;
            }
        }
        return true;
    }

    public boolean solve(int[][] graph, int node, int[] colors, boolean[] visited, int color) {
        visited[node] = true;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                colors[neighbor] = color * -1;
                if (!solve(graph, neighbor, colors, visited, color * -1)) {
                    return false;
                }
            }
            if (visited[neighbor]) {
                if (colors[neighbor] == color)
                    return false;
            }
        }
        return true;
    }
}

// T -> O(V + 2E)
// S -> O(3V)