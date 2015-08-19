public class RemoveElement {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int start = 0;
        for (int end = 0; end < A.length; end++) {
            if (A[end] != elem) {
                A[start++] = A[end];
            }
        }
        return start;
    }
}

