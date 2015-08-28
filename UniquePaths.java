public class UniquePaths {
    /**
     * recursion.
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }


    // memoization.
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        return paths(m - 1, n - 1, new int[n][m]);
    }

    private int paths(int m, int n, int[][] cache) {
        if (m == 0 || n == 0) {
            return 1;
        }
        if (cache[n][m] != 0) {
            return cache[n][m];
        }
        cache[n][m] = paths(m - 1, n, cache) + paths(m, n - 1, cache);
        return cache[n][m];
    }

    // dp.
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] cache = new int[n][m];
        // initialization
        for (int i = 0; i < m; i++) {
            cache[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            cache[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
            }
        }
        return cache[n - 1][m - 1];
    }
}