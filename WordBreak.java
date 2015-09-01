public class WordBreak {
    /**
     * Time: O(N^2) => O(NL), L is the max length of words in dict.
     * Space: O(N)
     *
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null) {
            return false;
        }

        int maxWordLen = getLen(dict);
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = i - 1; j >= 0 && i - j <= maxWordLen; j--) {
                if (dict.contains(s.substring(j, i)) && f[j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }

    private int getLen(Set<String> dict) {
        int len = 0;
        for (String s : dict) {
            len = Math.max(len, s.length());
        }
        return len;
    }
}
