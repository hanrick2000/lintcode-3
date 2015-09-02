public class EditDistance {
    /**
     * Time: O(N*M)
     * Space: O(N*M)
     *
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        //initialization.
        int[][] f = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            f[0][j] = j;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                f[i][j] = Math.min(f[i][j - 1], f[i - 1][j]) + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                } else {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        return f[word1.length()][word2.length()];
    }
}
