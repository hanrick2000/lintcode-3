public class SingleNumberIII {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        if (A == null || A.length < 2) {
            throw new IllegalArgumentException();
        }

        Set<Integer> set = new HashSet<>();
        for (int number : A) {
            if (set.contains(number)) {
                set.remove(number);
            } else {
                set.add(number);
            }
        }
        List<Integer> result = new ArrayList<>(2);
        for (int number : set) {
            result.add(number);
        }
        return result;
    }
}
