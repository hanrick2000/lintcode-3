public class WoodCut {
    /**
     * Time: O(NlogLen), Len is max int in L.
     * Space: O(1)
     *
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }

        int low = 1;
        int high = findMax(L);
        while (low < high) {
            int mid  = low + (high - low + 1) / 2;
            if (cut(L, mid) < k) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return cut(L, low) >= k ? low : 0;
    }

    private int findMax(int[] L) {
        int max = L[0];
        for (int n : L) {
            max = Math.max(max, n);
        }
        return max;
    }

    private int cut(int[] L, int len) {
        int sum = 0;
        for (int n : L) {
            sum += n / len;
        }
        return sum;
    }
}
