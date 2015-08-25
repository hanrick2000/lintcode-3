public class LengthOfLastWord {
    /**
     * Time: O(N)
     * Space: O(N)
     *
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord_sort(String s) {
        if (s == null) {
            return 0;
        }

        s.trim();
        String[] arr = s.split(" ");
        if (arr.length == 0) {
            return 0;
        }
        return arr[arr.length - 1].length();
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int lengthOfLastWord_twoPointers(String s) {
        if (s == null) {
            return 0;
        }

        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        if (i < 0) { // all spaces
            return 0;
        }

        int j = i;
        while (j >= 0 && s.charAt(j) != ' ') {
            j--;
        }
        return i - j;
    }
}
