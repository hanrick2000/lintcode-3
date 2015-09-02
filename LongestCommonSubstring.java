public class LongestCommonSubstring {
    /**
     * Time: O(N*M)
     * Space: O(N*M)
     *
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }

        int[][] f = new int[A.length() + 1][B.length() + 1];
        int result = 0;
        for (int i = 1; i < A.length() + 1; i++) {
            for (int j = 1; j < B.length() + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    result = Math.max(result, f[i][j]);
                }
            }
        }
        return result;
    }
}
