public class MinimumPathSum {
    /**
     * Time: O(N!M!)
     * Space: O(1)
     *
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        return sum(grid, grid.length - 1, grid[0].length - 1);
    }

    private int sum(int[][] grid, int row, int col) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        int top = row == 0 ? Integer.MAX_VALUE : sum(grid, row - 1, col);
        int left = col == 0 ? Integer.MAX_VALUE : sum(grid, row, col - 1);

        return Math.min(top, left) + grid[row][col];
    }

    /**
     * dp - memoization.
     * Time: O(N*M)
     * Space: O(N*M)
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        return sum(grid, grid.length - 1, grid[0].length - 1, new int[grid.length][grid[0].length]);
    }

    private int sum(int[][] grid, int row, int col, int[][] cache) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }

        if (cache[row][col] != 0) {
            return cache[row][col];
        }

        int top = row == 0 ? Integer.MAX_VALUE : sum(grid, row - 1, col, cache);
        int left = col == 0 ? Integer.MAX_VALUE : sum(grid, row, col - 1, cache);
        cache[row][col] = Math.min(top, left) + grid[row][col];
        return cache[row][col];
    }

    /**
     * dp - iteration.
     * Time: O(N*M)
     * Space: O(1)
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        // initialization
        for (int i = 1; i < m; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[n - 1][m - 1];
    }
}

