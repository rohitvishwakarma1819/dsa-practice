class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islands = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                islands += dfs(grid, m, n, i, j);
            }
        }
        return islands;
    }

    int dfs(char[][] grid, int m, int n, int r, int c) {

        if (isSafe(r, c, m, n) && grid[r][c] == '1') {
            grid[r][c] = '0';
            dfs(grid, m, n, r, c + 1);
            dfs(grid, m, n, r + 1, c);
            dfs(grid, m, n, r, c - 1);
            dfs(grid, m, n, r - 1, c);
            return 1;
        }
        return 0;
    }

    boolean isSafe(int r, int c, int m, int n) {
        return (r >= 0 && r < m) && (c >= 0 && c < n);
    }
}