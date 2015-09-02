public class InterleavingString {
    /**
     * Time: O(NM)
     * Space: O(NM)
     *
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s3.length() != s1.length() + s2.length()) {
            return false;
        }

        boolean[][] f = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            if (s1.substring(0, i).equals(s3.substring(0, i))) {
                f[i][0] = true;
            } else {
                break;
            }
        }
        for (int j = 0; j < s2.length() + 1; j++) {
            if (s2.substring(0, j).equals(s3.substring(0, j))) {
                f[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);
                if (c1 == c3) {
                    f[i][j] = f[i - 1][j];
                }
                if (c2 == c3) {
                    f[i][j] = f[i][j] || f[i][j - 1];
                }
            }
        }
        return f[s1.length()][s2.length()];
    }
}
