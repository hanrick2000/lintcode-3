public class LongestIncreasingContinuousSubsequence {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int max = 1;
        int lenIncrease = 1;
        int lenDecrease = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                lenIncrease++;
                lenDecrease = 1;
            } else if (A[i] < A[i - 1]) {
                lenDecrease++;
                lenIncrease = 1;
            } else {
                lenIncrease++;
                lenDecrease++;
            }
            max = Math.max(max, Math.max(lenIncrease, lenDecrease));
        }
        return max;
    }
}
