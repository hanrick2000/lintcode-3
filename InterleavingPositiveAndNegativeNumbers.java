class InterleavingPositiveAndNegativeNumbers {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        if (A == null) {
            return;
        }
        int negNum = partition(A);
        int posNum = A.length - negNum;
        // set starting points of swap
        int neg = 1;
        int pos = A.length - 2;
        if (negNum > posNum) {
            pos++;
        } else if (negNum < posNum) {
            neg--;
        }
        while (neg < pos) {
            swap(A, neg, pos);
            neg += 2;
            pos -= 2;
        }
   }

    private int partition(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i <= j) {
            if (A[i] < 0) {
                i++;
            } else if (A[j] >= 0) {
                j--;
            } else {
                swap(A, i, j);
            }
        }
        return i;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
