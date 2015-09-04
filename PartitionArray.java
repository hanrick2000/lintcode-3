public class PartitionArray {
    /**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] < k) {
                i++;
            } else if (nums[j] >= k) {
                j--;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return i;
    }
}