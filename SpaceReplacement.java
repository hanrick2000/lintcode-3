public class SpaceReplacement {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        if (string == null || string.length == 0) {
            return 0;
        }

        // get final length
        int result = length;
        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                result += 2;
            }
        }

        int j = result - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (string[i] == ' ') {
                string[j--] = '0';
                string[j--] = '2';
                string[j--] = '%';
            } else {
                string[j--] = string[i];
            }
        }
        return result;
    }
}
