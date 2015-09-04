public class PartitionArrayByOddAndEven {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        if (nums == null) {
            return;
        }

        int odd = 0;
        int even = nums.length - 1;
        while (odd < even) {
            if (nums[odd] % 2 == 1) {
                odd++;
            } else if (nums[even] % 2 == 0) {
                even--;
            } else {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
            }
        }
    }
}
