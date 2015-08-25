public class TwoStringsAreAnagrams {
    /**
     * Time: O(NlogN)
     * Space: O(N)
     */
    public boolean anagram_sort(String s, String t) {
        if (s == null || t == null) throw new IllegalArgumentException();
        if (s.length() != t.length()) return false;

        char[] charS = s.toCharArray();
        Arrays.sort(charS);
        char[] charT = t.toCharArray();
        Arrays.sort(charT);
        return Arrays.equals(charS, charT);
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public boolean anagram_map(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (count[c] == 0) {
                return false;
            } else {
                count[c]--;
            }
        }
        return true;
    }
}
