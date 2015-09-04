public class MatrixZigzagTraversal {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */
    public int[] printZMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] result = new int[m * n];
        int r = 0;
        boolean isForward = true;
        for (int sum = 0; sum < m + n - 1; sum++) {
            for (int i = 0; i <= sum; i++) {
                int y = sum - i;
                int x = i;
                if (!isForward) {
                    y = i;
                    x = sum - i;
                }
                if (y < n && x < m) {
                    result[r++] = matrix[y][x];

                }
            }
            isForward = !isForward;
        }
        return result;
    }
}
