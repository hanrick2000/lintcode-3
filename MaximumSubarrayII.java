public class MaximumSubarrayII {
    /**
     * Time: O(N)
     * Space: O(N)
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if (nums == null) {
            return 0;
        }

        int[] left = new int[nums.size()];
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int leftMin = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            maxSum = Math.max(maxSum, sum - leftMin);
            left[i] = maxSum;
            leftMin = Math.min(leftMin, sum);
        }

        int[] right = new int[nums.size()];
        sum = 0;
        maxSum = Integer.MIN_VALUE;
        int rightMin = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            sum += nums.get(i);
            maxSum = Math.max(maxSum, sum - rightMin);
            right[i] = maxSum;
            rightMin = Math.min(rightMin, sum);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.size(); i++) {
            max = Math.max(max, left[i - 1] + right[i]);
        }
        return max;
    }
}


