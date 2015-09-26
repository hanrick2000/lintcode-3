public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        boolean[] flags = new boolean[256];
        int start = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i);
            if (!flags[curr]) {
                flags[curr] = true;
                result = Math.max(result, i - start + 1);
            } else {
                while (s.charAt(start) != curr) {
                    flags[s.charAt(start++)] = false;
                }
                start++;
            }
        }
        return result;
    }
}
