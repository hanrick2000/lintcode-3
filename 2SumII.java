public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSumII(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        int low = 0;
        int high = nums.length - 1;
        int result = 0;
        while (low < high) {
            if (nums[low] + nums[high] > target) {
                result += high - low;
                high--;
            } else {
                low++;
            }
        }
        return result;
    }
}
