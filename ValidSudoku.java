class ValidSudoku {
    /**
      * @param board: the board
      * @return: wether the Sudoku is valid
      */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] grid = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                if (num < 0 || num > 9) {
                    return false;
                }
                if (rows[i][num] || cols[j][num] || grid[i / 3 * 3 + j / 3][num]) {
                    return false;
                } else {
                    rows[i][num] = true;
                    cols[j][num] = true;
                    grid[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }

        return true;
    }
}