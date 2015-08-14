class FindPeakElementII {
    /**
     * Time: O(MlogN)
     * Space: O(1)
     *
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        List<Integer> result = new ArrayList<>(2);
        if (A == null || A.length == 0 || A[0].length == 0) {
            return result;
        }

        int low = 0;
        int high = A.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low ) / 2;
            int maxPos = findLinePeak(A[mid]);
            if (A[mid][maxPos] > A[mid - 1][maxPos] && A[mid][maxPos] > A[mid + 1][maxPos]) {
                high = mid;
            } else if (A[mid][maxPos] <= A[mid - 1][maxPos]) {
                high = mid;
            } else {
                low = mid;
            }
        }

        int maxPos = findLinePeak(A[low]);
        if (A[low][maxPos] > A[high][maxPos]) {
            result.add(low);
        } else {
            maxPos = findLinePeak(A[high]);
            result.add(high);
        }
            result.add(maxPos);
            return result;
    }

    private int findLinePeak(int[] line) {
        int maxPos = 0;
        for (int i = 1; i < line.length; i++) {
            if (line[i] > line[maxPos]) {
                maxPos = i;
            }
        }
        return maxPos;
    }
}

