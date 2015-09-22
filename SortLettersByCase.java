public class SortLettersByCase {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        int low = 0;
        int high = chars.length - 1;
        while (low <= high) {
            if (chars[low] >= 'a' && chars[low] <= 'z') {
                low++;
            } else if (chars[high] >= 'A' && chars[high] <= 'Z') {
                high--;
            } else {
                swap(chars, low, high);
            }
        }
    }

    private void swap(char[] chars, int i , int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

