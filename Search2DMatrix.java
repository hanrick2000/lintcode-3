public class Search2DMatrix {
    /**
     * Time: O(logM + logN) => O(logMN)
     * Space: O(1)
     *
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        // find target line
        int low = 0;
        int high = n - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] > target) {
                high = mid;
            } else {
                low = mid;
            }
        }

        int targetLine = 0;
        if (matrix[low][0] <= target && matrix[low][m - 1] >= target) {
            targetLine = low;
        } else {
            targetLine = high;
        }

        // find target in line
        low = 0;
        high = m - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (matrix[targetLine][mid] > target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return matrix[targetLine][low] == target || matrix[targetLine][high] == target);
    }

    public boolean searchMatrix_once(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = m * n - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid / m][mid % m] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return matrix[low / m][low % m] == target || matrix[high / m][high % m] == target;
    }
}

