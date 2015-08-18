public class SearchInRotatedSortedArray {
    /**
     * Time: O(logN)
     * Space: O(1)
     *
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A[low] <= A[mid]) {
                if (A[low] <= target && A[mid] >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if (A[mid] <= target && A[high] >= target) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return A[low] == target ? low : -1;
    }
}

