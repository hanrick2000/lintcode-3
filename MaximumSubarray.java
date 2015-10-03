public class MaximumSubarray {
    /**
     * Time: O(N^2)
     * Space: O(1)
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;
            for (int j = i; j < nums.size(); j++) {
                sum += nums.get(j);
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int maxSubArray_dp(ArrayList<Integer> nums) {
        if (nums == null) {
            return 0;
        }

        int[] sums = new int[nums.size()];
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            sums[i] = sum;
        }

        int min = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < sums.length; i++) {
            maxSum = Math.max(maxSum, sums[i] - min);
            min = Math.min(min, sums[i]);
        }
        return maxSum;
    }


    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int maxSubArray_dp_spaceOptimization(ArrayList<Integer> nums) {
        if (nums == null) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            maxSum = Math.max(maxSum, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return maxSum;
    }
}
