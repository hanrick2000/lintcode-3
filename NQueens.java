class NQueens {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        dfs(n, new ArrayList<Integer>(), solutions);
        return print(solutions, n);
    }

    private void dfs(int n, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> solutions) {
        if (list.size() == n) {
            solutions.add(new ArrayList<Integer>(list));
        }

        for (int i = 1; i <= n; i++) {
            if (!isValid(list, i)) {
                continue;
            }
            list.add(i);
            dfs(n, list, solutions);
            list.remove(list.size() - 1);
        }
    }

    private boolean isValid(ArrayList<Integer> list, int x) {
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

    private ArrayList<ArrayList<String>> print(ArrayList<ArrayList<Integer>> solutions, int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<>(solutions.size());
        for (ArrayList<Integer> solution : solutions) {
            ArrayList<String> board = new ArrayList<String>(n);
            for (int x : solution) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    sb.append(i == x ? "Q" : ".");
                }
                board.add(sb.toString());
            }
            result.add(board);
        }
        return result;
    }
}
