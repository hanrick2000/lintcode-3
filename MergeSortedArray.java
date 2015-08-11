/*
 * Time: O(m + n)
 * Space: O(1)
 */
class MergeSortedArray {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        while (m > 0 && n > 0) {
            A[m + n - 1] = A[m - 1] >= B[n - 1] ? A[--m] : B[--n];
        }

        while (n > 0) {
            A[n - 1] = B[--n];
        }
    }

    public void mergeSortedArray_v2(int[] A, int m, int[] B, int n) {
        while (n > 0) {
            A[m + n - 1] = m > 0 && A[m - 1] >= B[n - 1] ? A[--m] : B[--n];
        }
    }
}
