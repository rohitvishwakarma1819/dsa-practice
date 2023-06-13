
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V + 1];
        visited[0] = true;
        dfs(0, visited, adj, ans);
        return ans;
    }

    public void dfs(int index, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {
        ans.add(index);
        for (int neighbor : adj.get(index)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                dfs(neighbor, visited, adj, ans);
            }
        }
    }
}

// T -> O(N)
// S -> O(N) + O(H)