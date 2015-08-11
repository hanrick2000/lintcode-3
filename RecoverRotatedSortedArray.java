/*
 * Time: O(n)
 * Space: O(1)
 */
 public class RecoverRotatedSortedArray {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if (nums == null) {
            return;
        }

        int minIndex = findMin(nums);
        if (minIndex == 0) {
            return;
        }
        reverse(nums, 0, minIndex - 1);
        reverse(nums, minIndex, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }

    private int findMin(ArrayList<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                return i;
            }
        }
        return 0;
    }

    private void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = 0; i <= (end - start) / 2; i++) {
            int temp = nums.get(start + i);
            nums.set(start + i, nums.get(end - i));
            nums.set(end - i, temp);
        }
    }
}
