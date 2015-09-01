public class PalindromePartitioningII {
    /**
     * Time: O(N^2)
     * Space: O(N^2)
     *
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        boolean[][] cache = getTable(s);

        int[] f = new int[s.length() + 1];
        f[0] = -1;
        for (int i = 1; i < s.length() + 1; i++) {
            f[i] = i - 1;
            for (int j = 0; j < i; j++) {
                if (cache[j][i]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[s.length()];
    }

    private boolean[][] getTable(String s) {
        boolean[][] cache = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (isPalindrome(s, i, j)) {
                    cache[i][j] = true;
                }
            }
        }
        return cache;
    }

    private boolean isPalindrome(String s, int i, int j) {
        for (int k = 0; k < (j - i + 1) / 2; k++) {
            if (s.charAt(i + k) != s.charAt(j - 1 - k)) {
                return false;
            }
        }
        return true;
    }
}
