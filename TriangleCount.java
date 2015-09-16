public class TriangleCount {
    /**
     * Time: O(N^2)
     * Space: O(1)
     *
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        if (S == null || S.length < 3) {
            return 0;
        }
        Arrays.sort(S);

        int result = 0;
        for (int i = S.length - 1; i >= 2; i--) {
            int low = 0;
            int high = i - 1;
            while (low < high) {
                if (S[low] + S[high] > S[i]) {
                    result += high - low;
                    high--;
                } else {
                    low++;
                }
            }
        }
        return result;
    }
}

