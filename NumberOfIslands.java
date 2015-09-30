public class NumberOfIslands {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        Map<Integer, Integer> parents = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    int index = i * m + j;
                    parents.put(index, index);
                }
            }
        }

        // merge rows
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] && grid[i][j - 1]) {
                    union(parents, i * m + j, i * m + j - 1);
                }
            }
        }

        // merge colomns
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                if (grid[i][j] && grid[i - 1][j]) {
                    union(parents, i * m + j, (i - 1) * m + j);
                }
            }
        }

        Set<Integer> result = new HashSet<>();
        for (Integer index : parents.keySet()) {
            result.add(find(parents, index));
        }
        return result.size();
    }

    private void union(Map<Integer, Integer> parents, int first, int second) {
        int firstParent = find(parents, first);
        int secondParent = find(parents, second);
        if (firstParent != secondParent) {
            parents.put(secondParent, firstParent);
        }
    }

    private int find(Map<Integer, Integer> parents, int index) {
        int parent = index;
        while (parent != parents.get(parent)) {
            parent = parents.get(parent);
        }

        while (index != parent) {
            int next = parents.get(index);
            parents.put(index, parent);
            index = next;
        }
        return parent;
    }
}
