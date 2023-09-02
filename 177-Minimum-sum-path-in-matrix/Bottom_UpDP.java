class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sums = new int[m][n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                sums[i][j] = grid[i][j];
                if (i == m - 1 && j == n - 1)
                    continue;
                if (i == m - 1) {
                    sums[i][j] = sums[i][j + 1] + grid[i][j];
                } else if (j == n - 1) {
                    sums[i][j] = sums[i + 1][j] + grid[i][j];
                } else {
                    sums[i][j] = grid[i][j] + Math.min(sums[i + 1][j], sums[i][j + 1]);
                }
            }
        }
        return sums[0][0];
    }
}

// T -> O(M*N)
// S -> O(M*N)