/*
 * Time: O(m + n)
 * Space: O(m + n)
 */
class MergeSortedArrayII {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArrayII(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>(A.size() + B.size());
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            int k = A.get(i) <= B.get(j) ? A.get(i++) : B.get(j++);
            result.add(k);
        }

        while (i < A.size()) {
            result.add(A.get(i++));
        }
        while (j < B.size()) {
            result.add(B.get(j++));
        }
        return result;
    }
}
