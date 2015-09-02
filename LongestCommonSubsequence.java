public class LongestCommonSubsequence {
    /**
     * Time: O(N*M)
     * Space: O(N*M)
     *
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }

        int[][] f = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i < A.length() + 1; i++) {
            for (int j = 1; j < B.length() + 1; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) { // error
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[A.length()][B.length()];
    }
}

