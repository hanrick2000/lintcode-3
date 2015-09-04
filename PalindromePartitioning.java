public class PalindromePartitioning {
    /**
     * Time: O(N*N!)
     * Space: O(N*N!)
     *
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] isPalindrome = getIsPalindrome(s);
        dfs(s, isPalindrome, 0, new ArrayList<String>(), result);
        return result;
    }

    private void dfs(String s, boolean[][] isPalindrome, int index, ArrayList<String> list, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (!isPalindrome[index][i]) {
                continue;
            }
            list.add(s.substring(index, i + 1));
            dfs(s, isPalindrome, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                isPalindrome[i][j] = isPalindrome(s, i, j);
            }
        }
        return isPalindrome;
    }
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
