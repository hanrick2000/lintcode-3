public class UniquePathsII {
    /**
     * recusion.
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        return paths(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }

    private int paths(int[][] obstacleGrid, int i, int j) {
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i == 0) {
            return paths(obstacleGrid, 0, j - 1);
        }
        if (j == 0) {
            return paths(obstacleGrid, i - 1, 0);
        }

        return paths(obstacleGrid, i - 1, j) + paths(obstacleGrid, i, j - 1);
    }

    // memoization.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        return paths(obstacleGrid, n - 1, m - 1, new int[n][m]);
    }

    private int paths(int[][] obstacleGrid, int i, int j, int[][] cache) {
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i == 0) {
            return paths(obstacleGrid, 0, j - 1, cache);
        }
        if (j == 0) {
            return paths(obstacleGrid, i - 1, 0, cache);
        }

        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        cache[i][j] = paths(obstacleGrid, i - 1, j, cache) + paths(obstacleGrid, i, j - 1, cache);
        return cache[i][j];
    }

    // dp.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] cache = new int[n][m];
        // initialization
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            cache[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            cache[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
            }
        }
        return cache[n - 1][m - 1];
    }
}
