public class ContinuousSubarraySum {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        ArrayList<Integer> result = new ArrayList<>(2);
        result.add(0);
        result.add(0);
        if (A == null || A.length == 0) {
            return result;
        }

        int sum = 0;
        int minSum = 0;
        int minSumIndex = -1;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum - minSum > maxSum) {
                maxSum = sum - minSum;
                result.set(0, minSumIndex + 1);
                result.set(1, i);
            }
            if (sum < minSum) {
                minSum = sum;
                minSumIndex = i;
            }
        }
        return result;
    }
}
