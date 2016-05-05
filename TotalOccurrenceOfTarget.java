public class TotalOccurrenceOfTarget {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (A[low] != target) {
            return 0;
        }
        int first = low;
        low = 0;
        high = A.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (A[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return low - first + 1;
    }
}
