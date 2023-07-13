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
class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; ++i)
            parent[i] = i;
        rank = new int[n];
    }

    public int findParent(int x) {
        if (parent[x] != x) {
            return parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xSet = findParent(x), ySet = findParent(y);
        if (xSet == ySet)
            return;
        if (rank[xSet] > rank[ySet]) {
            parent[ySet] = xSet;
        } else if (rank[xSet] < rank[ySet]) {
            parent[xSet] = parent[ySet];
        } else {
            parent[xSet] = parent[ySet];
            rank[ySet]++;
        }

    }
}

class Solution {
    static int spanningTree(int V, int E, int edges[][]) {
        // Code Here.
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int sum = 0;
        UnionFind ds = new UnionFind(V);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (ds.findParent(u) != ds.findParent(v)) {
                sum += w;
                ds.union(u, v);
            }
        }
        return sum;
    }
}

// T-> O(ELogE) + O(E) + O(2E) ~ O(ELogE)
// S -> O(2N) ~ O(N)