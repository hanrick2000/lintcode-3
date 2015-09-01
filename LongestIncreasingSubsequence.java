public class LongestIncreasingSubsequence {
    /**
     * dp.
     * Time: O(N^2)
     * Space: O(N)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] f = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            result = Math.max(result, f[i]);
        }
        return result;
    }

    /**
     * Time: O(NlogN)
     * Space: O(N)
     * binary search, maintain a list of last elements.
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] last = new int[nums.length];
        last[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (last[len - 1] <= nums[i]) {
                last[len++] = nums[i];
            } else {
                int j = search(last, len - 1, nums[i]);
                last[j] = nums[i];
            }
        }
        return len;
    }

    // find index of first num > target
    private int search(int[] last, int high, int target) {
        int low = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (last[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}



