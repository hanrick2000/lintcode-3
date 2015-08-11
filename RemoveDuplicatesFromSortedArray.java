public class RemoveDuplicatesFromSortedArray {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int newLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[newLen - 1]) {
                nums[newLen++] = nums[i];
            }
        }
        return newLen;
    }
}
