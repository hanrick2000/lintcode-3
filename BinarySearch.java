class BinarySearch {
    /**
     * Time: O(logN)
     * Space: O(1)
     *
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if (nums[low] == target) {
            return low;
        }
        if (nums[high] == target) {
            return high;
        }
        return -1;
    }
}
