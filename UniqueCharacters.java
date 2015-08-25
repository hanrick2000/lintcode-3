public class UniqueCharacters {
    /**
     * Time: O(N)
     * Space: O(N)
     *
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique_sort(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }

        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public boolean isUnique_booleanArray(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }

        boolean[] flags = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (flags[c]) {
                return false;
            } else {
                flags[c] = true;
            }
        }
        return true;
    }
}
