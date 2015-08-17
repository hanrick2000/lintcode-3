public class FindMinimumInRotatedSortedArray {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }

        int low = 0;
        int high = num.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (num[mid] <= num[num.length - 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return num[low];
    }
}
