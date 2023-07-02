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
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        colors[node] = color;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbor : graph[curr]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    colors[neighbor] = colors[curr] * -1;
                    q.add(neighbor);
                } else {
                    if (colors[neighbor] == colors[curr])
                        return false;
                }
            }
        }
        return true;
    }
}

// T -> O(V + 2E)
// S -> O(3V)