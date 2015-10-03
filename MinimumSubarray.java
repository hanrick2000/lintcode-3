public class MinimumSubarray {
    /**
     * Time: O(N)
     * Space: O(1)
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null) {
            return 0;
        }

        int minSum = Integer.MAX_VALUE;
        int sumSoFar = 0;
        int maxSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sumSoFar += nums.get(i);
            minSum = Math.min(minSum, sumSoFar - maxSum);
            maxSum = Math.max(maxSum, sumSoFar);
        }
        return minSum;
    }
}

