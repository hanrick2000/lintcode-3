class Fibonacci {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int prev = 0;
        int curr = 1;
        for (int i = 3; i <= n; i++) {
            int temp = curr;
            curr += prev;
            prev = temp;
        }
        return curr;
    }
}


