public class WordLadderII {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        dict.remove(start);
        dict.remove(end);

        List<List<String>> result = new ArrayList<>();
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> first = new ArrayList<>(1);
        first.add(start);
        q.offer(first);
        while (!q.isEmpty() && result.isEmpty()) {
            int size = q.size();
            Set<String> found = new HashSet<>(); // error.
            for (int i = 0; i < size; i++) {
                ArrayList<String> currList = q.poll();
                String curr = currList.get(currList.size() - 1);
                Set<String> nextSet = getNextSet(curr, end, dict);
                for (String next : nextSet) {
                    ArrayList<String> nextList = new ArrayList<>(currList);
                    nextList.add(next);
                    if (next.equals(end)) {
                        result.add(nextList);
                    } else {
                        q.offer(nextList);
                    }
                }
                found.addAll(nextSet);
            }
            dict.removeAll(found);
        }
        return result;
    }

    private Set<String> getNextSet(String str, String end, Set<String> dict) {
        Set<String> nextSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char[] charArray = str.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                charArray[i] = c;
                String next = new String(charArray);
                if (next.equals(end)) {
                    nextSet.clear();
                    nextSet.add(next);
                    return nextSet;
                }
                if (dict.contains(next)) {
                    nextSet.add(next);
                }
            }
        }
        return nextSet;
    }
}
