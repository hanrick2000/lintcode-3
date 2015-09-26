public class MinimumWindowSubstring {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        if (source == null || target == null || target.equals("")) {
            return "";
        }

        int[] targetMap = new int[256];
        for (char c : target.toCharArray()) {
            targetMap[c]++;
        }

        int start = 0;
        int[] found = new int[256];
        int toFind = target.length();
        String result = "";
        for (int i = 0; i < source.length(); i++) {
            char curr = source.charAt(i);
            if (targetMap[curr] > 0) {
                found[curr]++;
                if (found[curr] <= targetMap[curr]) {
                    toFind--;
                }

                if (toFind == 0) {
                    while (start <= i) {
                        char first = source.charAt(start);
                        if (targetMap[first] > 0) {
                            if (found[first] <= targetMap[first]) {
                                break;
                            }
                            found[first]--;
                            toFind++;
                        }
                        start++;
                    }

                    String solution = source.substring(start, i + 1);
                    if (result.equals("")) {
                        result = solution;
                    } else {
                        result = result.length() > solution.length() ? solution : result;
                    }
                }
            }
        }
        return result;
    }
}
