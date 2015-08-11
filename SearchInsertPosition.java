public class SearchInsertPosition {
    /**
     * Time: O(logN)
     * Space: O(1)
     *
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) return 0;

        int low = 0;
        int high = A.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if (A[low] >= target) {
            return low;
        }
        if (A[high] >= target) {
            return high;
        }
        return A.length;
    }
}

