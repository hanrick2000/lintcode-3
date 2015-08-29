public class JumpGame {
    /**
     * dp.
     * Time: O(N^2)
     * Space: O(N)
     *
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        boolean[] f = new boolean[A.length];
        f[0] = true;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && (j + A[j] >= i)) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[A.length - 1];
    }

    /**
     * Greedy.
     * Time: O(N)
     * Space: O(1)
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int i = 0;
        int end = 0;
        while (i <= end && end < A.length) {
            end = Math.max(end, i + A[i]);
            i++;
        }
        return end >= A.length;
    }
}

