public class CompareStrings {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if (A == null || B == null || A.length() < B.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < A.length(); i++) {
            int c = A.charAt(i) - 'A';
            count[c]++;
        }

        for (int i = 0; i < B.length(); i++) {
            int c = B.charAt(i) - 'A';
            if (count[c] == 0) {
                return false;
            } else {
                count[c]--;
            }
        }
        return true;
    }
}
