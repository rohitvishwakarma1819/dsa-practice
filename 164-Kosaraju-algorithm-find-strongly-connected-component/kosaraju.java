import java.util.*;

public class Solution {

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        // Write your code here
        // Step 1. Topological sort
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[n];
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                dfs(i, vis, stack, graph);
            }
        }
        ArrayList<Integer>[] transpose = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            transpose[i] = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            vis[i] = false;
            for (Integer neighbor : graph[i]) {
                transpose[neighbor].add(i);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!vis[node]) {
                ArrayList<Integer> list = new ArrayList<>();
                reverseDFS(node, vis, list, transpose);
                ans.add(list);
            }
        }
        return ans;

    }

    public static void dfs(int node, boolean[] vis, Stack<Integer> stack, ArrayList<Integer>[] graph) {
        if (!vis[node]) {
            vis[node] = true;
            for (Integer neighbor : graph[node]) {
                dfs(neighbor, vis, stack, graph);
            }
            stack.push(node);
        }
    }

    public static void reverseDFS(int node, boolean[] vis, ArrayList<Integer> list, ArrayList<Integer>[] graph) {
        if (!vis[node]) {
            vis[node] = true;
            for (Integer neighbor : graph[node]) {
                reverseDFS(neighbor, vis, list, graph);
            }
            list.add(node);
        }
    }

}