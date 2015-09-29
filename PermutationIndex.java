public class PermutationIndex {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        if (A.length <= 1) {
            return 1;
        }

        long result = permutationIndex(Arrays.copyOfRange(A, 1, A.length));
        int first = A[0];
        Arrays.sort(A);
        int index = findIndex(A, first);
        result += index * factorial(A.length - 1);
        return result;
    }

    private long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private int findIndex(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
