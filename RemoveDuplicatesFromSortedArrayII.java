public class RemoveDuplicatesFromSortedArrayII {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;

        int len = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[len - 1] || nums[i] != nums[len - 2]) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
