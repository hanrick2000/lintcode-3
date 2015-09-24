public class UniqueBinarySearchTree {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees_recursion(int n) {
        if (n <= 1) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += numTrees(i - 1) * numTrees(n - i);
        }
        return result;
    }

    public int numTrees_dp(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                cache[i] += cache[j - 1] * cache[i - j];
            }
        }
        return cache[n];
    }
}
