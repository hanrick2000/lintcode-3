public class DistinctSubsequences {
    /**
     * Time: O(N*M)
     * Space: O(N*M)
     *
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) {
            return 0;
        }

        // initialization, if T == "", return 1.
        int[][] f = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i < S.length() + 1; i++) {
            f[i][0] = 1;
        }

        for (int i = 1; i < S.length() + 1; i++) {
            for (int j = 1; j < T.length() + 1; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        return f[S.length()][T.length()];
    }
}
