class NQueensII {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] result = new int[1];
        search(n, new ArrayList<Integer>(), result);
        return result[0];
    }

    private void search(int n, List<Integer> list, int[] result) {
        if (list.size() == n) {
            result[0]++;
        }

        for (int i = 1; i <= n; i++) {
            if (!isValid(list, i)) {
                continue;
            }
            list.add(i);
            search(n, list, result);
            list.remove(list.size() - 1);
        }
    }

    private boolean isValid(List<Integer> list, int x) {
        if (list.contains(x)) {
            return false;
        }
        int y = list.size() + 1;
        for (int y1 = 1; y1 < list.size() + 1; y1++) {
            int x1 = list.get(y1 - 1);
            if ((x1 + y1 == x + y) || (x1 - y1 == x - y)) {
                return false;
            }
        }
        return true;
    }
}