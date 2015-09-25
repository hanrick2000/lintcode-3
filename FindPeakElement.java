class FindPeakElement {
    /**
     * Time: O(logN)
     * Space: O(1)
     *
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A == null || A.length < 3) {
            return -1;
        }

        int low = 0;
        int high = A.length - 1;
        while (low + 1 < high) {
            int mid  = low + (high - low) / 2;
            if (isPeak(A, mid)) {
                return mid;
            } else if (A[mid] > A[mid - 1]) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if (isPeak(A, low)) {
            return low;
        }
        if (isPeak(A, high)) {
            return high;
        }
        return -1;
    }

    private boolean isPeak(int[] A, int index) {
        return A[index] > A[index - 1] && A[index] > A[index + 1];
    }

////////////////////////////////////////////////////////////////////////////////
    // update
    public int findPeak(int[] A) {
        if (A == null || A.length < 3) {
            return -1;
        }

        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] > A[mid - 1]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

