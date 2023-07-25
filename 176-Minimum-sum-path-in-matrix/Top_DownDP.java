class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sums = new int[m][n];
        for (int[] arr : sums)
            Arrays.fill(arr, Integer.MAX_VALUE);
        solve(grid, sums, 0, 0, 0);
        return sums[0][0];
    }

    public void solve(int[][] grid, int[][] sums, int r, int c, int sum) {
        int newSum = sum + grid[r][c];
        if (newSum < sums[r][c]) {
            sums[r][c] = newSum;
            if (isValid(r, c + 1, grid.length, grid[0].length)) {
                solve(grid, sums, r, c + 1, newSum);
            }
            if (isValid(r + 1, c, grid.length, grid[0].length)) {
                solve(grid, sums, r + 1, c, newSum);
            }
        }
    }

    public boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}

// T -> O(M*N)
// S -> O(M*N)