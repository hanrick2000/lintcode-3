public class ValidPalindrome {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!isValid(s.charAt(left))) {
                left++;
            } else if (!isValid(s.charAt(right))) {
                right--;
            } else if (lowerCase(s.charAt(left)) == lowerCase(s.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <='9');
    }

    private char lowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char)(c - 'A' + 'a');
        }
        return c;
    }
}
