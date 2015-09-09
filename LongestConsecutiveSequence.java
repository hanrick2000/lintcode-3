public class LongestConsecutiveSequence {
    /**
     * Time: O(N)
     * Space: O(N)
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>(num.length);
        for (int n : num) {
            set.add(n);
        }

        int result = 0;
        for (int n : num) {
            if (!set.contains(n)) {
                continue;
            }
            // nums greater than n
            int i = 1;
            while (set.contains(n + i)) {
                set.remove(n + i);
                i++;
            }
            // nums less than n
            int j = 0;
            while (set.contains(n - j - 1)) {
                set.remove(n - j - 1);
                j++;
            }
            result = Math.max(result, i + j);
        }
        return result;
    }
}
