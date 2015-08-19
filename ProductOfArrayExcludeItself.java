public class ProductOfArrayExcludeItself {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<>();
        if (A == null || A.isEmpty()) {
            return result;
        }

        long left = 1;
        result.add(left);
        for (int i = 1; i < A.size(); i++) {
            left *= A.get(i - 1);
            result.add(left);
        }

        long right = 1;
        for (int i = A.size() - 2; i >= 0; i--) {
            right *= A.get(i + 1);
            result.set(i, result.get(i) * right);
        }
        return result;
    }
}

