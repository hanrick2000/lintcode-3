public class CountAndSay {
    /**
     * Time: O(N^2)
     * Space: O(1)
     *
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        for (int i = 2; i <= n; i++) {
            int size = q.size();
            int num = q.poll();
            int count = 1;
            int j = 0;
            while (j++ < size - 1) {
                int next = q.poll();
                if (next == num) {
                    count++;
                } else {
                    q.offer(count);
                    q.offer(num);
                    count = 1;
                    num = next;
                }
            }
            q.offer(count);
            q.offer(num);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.poll());
        }
        return sb.toString();
    }
}
