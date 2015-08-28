public class Triangle {
    /**
     * Time: O(N^2), N is the height of triangle.
     * Space: O(1)
     *
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal_iteration(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        for (int i = 1; i < triangle.size(); i++) {
            ArrayList<Integer> prev = triangle.get(i - 1);
            ArrayList<Integer> curr = triangle.get(i);
            for (int j = 0; j < curr.size(); j++) {
                int sum = curr.get(j);
                if (j == 0) {
                    sum += prev.get(0);
                } else if (j == curr.size() - 1) {
                    sum += prev.get(j - 1);
                } else {
                    sum += Math.min(prev.get(j), prev.get(j - 1));
                }
                curr.set(j, sum);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int n : triangle.get(triangle.size() - 1)) {
            min = Math.min(min, n);
        }
        return min;
    }

    // divide and conquer.//////////////////////////////////////////////////////
    public int minimumTotal_dc(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        return dfs(triangle, 0, 0);
    }

    private int dfs(ArrayList<ArrayList<Integer>> triangle, int x, int y) {
        int n = triangle.size();
        if (x == n) {
            return 0;
        }

        return Math.min(dfs(triangle, x + 1, y), dfs(triangle, x + 1, y + 1))
               + triangle.get(x).get(y);
    }

    // dp.//////////////////////////////////////////////////////////////////////
    public int minimumTotal_dp(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        return dfs(triangle, 0, 0, new int[triangle.size()][triangle.size()]);
    }

    private int dfs(ArrayList<ArrayList<Integer>> triangle, int x, int y, int[][] cache) {
        int n = triangle.size();
        if (x == n) {
            return 0;
        }

        if (cache[x][y] == 0) {
            cache[x][y] = Math.min(dfs(triangle, x + 1, y, cache),
                                   dfs(triangle, x + 1, y + 1, cache)) + triangle.get(x).get(y);
        }
        return cache[x][y];
    }
}

