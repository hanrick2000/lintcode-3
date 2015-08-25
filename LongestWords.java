class LongestWords {
    /**
     * Time: O(N)
     * Space: O(N)
     *
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> result = new ArrayList<>();
        if (dictionary == null || dictionary.length == 0) {
            return result;
        }

        int len = 0;
        for (String word : dictionary) {
            if (word == null) {
                continue;
            }
            if (word.length() > len) {
                result.clear();
                result.add(word);
                len = word.length();
            } else if (word.length() == len) {
                result.add(word);
            }
        }
        return result;
    }
};
