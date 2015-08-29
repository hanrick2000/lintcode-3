public class JumpGameII {
    /**
     * dp.
     * Time: O(N^2)
     * Space: O(N)
     *
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int[] f = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + A[j] >= i) {
                    min = Math.min(min, f[j]);
                }
            }
            f[i] = min < Integer.MAX_VALUE ? min + 1 : 0;
        }
        return f[A.length - 1];
    }

    /**
     * greedy.
     * Time: O(N)
     * Space: O(1)
     */
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int i = 0;
        int end = 0;
        int steps = 0;
        while (i <= end && end < A.length) {
            if (i + A[i] > end) {
                end = i + A[i];
                steps++;
            }
            i++;
        }
        return end >= A.length ? steps : 0;
    }
}

