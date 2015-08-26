public class ClimbingStairs {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev = 1;
        int curr = 2;
        for (int i = 3; i <= n; i++) {
            int temp = curr;
            curr += prev;
            prev = temp;
        }
        return curr;
    }
}
