public class SearchInRotatedSortedArrayII {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean
     */
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }

        int low = 0;
        int high = A.length - 1;
        // temination condition is when there are 2 nums, because both halves are
        // sorted, the dups removal condition will fail.
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (A[low] == A[mid]) {
                low++;
            } else if (A[low] < A[mid]) {
                if (A[low] <= target && target <= A[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if (A[mid] <= target && target <= A[high]) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }

            /*
            if (A[mid] == A[high]) {
                high--;
            } else if (A[mid] < A[high]) {
                if(A[mid] <= target && A[high] >= target) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            } else {
                if (A[low] <= target && A[mid] >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            */
        }
        return A[low] == target || A[high] == target;
    }
}

