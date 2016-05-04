public class ClosestNumberInSortedArray {
    /**
     * Time: O(log n)
     * Space: O(1)
     *
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
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
        if (low == 0) {
            return 0;
        }
        return Math.abs(A[low] - target) < Math.abs(A[low - 1] - target)
               ? low : low - 1;
    }
}
