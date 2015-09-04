public class WordLadder {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        dict.remove(start);
        dict.add(end);
        int result = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            result++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                for (String next : getNextSet(curr, dict)) {
                    if (next.equals(end)) {
                        return result + 1;
                    } else {
                        q.offer(next);
                    }
                }
            }
        }
        return 0;
    }

    private Set<String> getNextSet(String str, Set<String> dict) {
        Set<String> nextSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char[] charArray = str.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                charArray[i] = c;
                String next = new String(charArray);
                if (dict.contains(next)) {
                    nextSet.add(next);
                    dict.remove(next);
                }
            }
        }
        return nextSet;
    }
}
