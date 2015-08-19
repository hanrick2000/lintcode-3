public class FirstMissingPositive {
    /**
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        for (int n : A) {
            if (n > 0) {
                set.add(n);
            }
        }

        for (int i = 1; i <= A.length; i++) {
            if (!set.contains(i)){
                return i;
            }
        }
        return A.length + 1;
    }
}
