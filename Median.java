public class Median {
    /**
     * Time: O(N)
     * Space: O(1)
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int medianIndex = nums.length / 2;
        if (nums.length % 2 == 0) {
            medianIndex--;
        }
        return quickSelect(nums, 0, nums.length - 1, medianIndex);
    }

    private int quickSelect(int[] A, int low, int high, int medianIndex) {
        int pos = partition(A, low, high);
        if (pos == medianIndex) {
            return A[pos];
        }
        if (pos > medianIndex) {
            return quickSelect(A, low, pos - 1, medianIndex);
        } else {
            return quickSelect(A, pos + 1, high, medianIndex);
        }
    }

    private int partition(int[] A, int low, int high) {
        int pivot = A[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (A[j] < pivot) {
                swap(A, i++, j);
            }
        }
        swap(A, i, high);
        return i;
    }

    private static void swap(int[] A, int one, int two) {
        int temp = A[one];
        A[one] = A[two];
        A[two] = temp;
    }
}

