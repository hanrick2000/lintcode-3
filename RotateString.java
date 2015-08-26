public class RotateString {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        if (str == null ||str.length == 0) {
            return;
        }
        int len = str.length;
        offset = offset % len;
        if (offset == 0) {
            return;
        }

        rotate(str, 0, len - offset - 1);
        rotate(str, len - offset, len - 1);
        rotate(str, 0, len - 1);
    }

    private void rotate(char[] str, int start, int end) {
        for (int i = 0; i <= (end - start) / 2; i++) {
            char temp = str[start + i];
            str[start + i] = str[end - i];
            str[end - i] = temp;
        }
    }
}
