public class SingleNumberII {
    /**
     * @param A : An integer array
     * @return : An integer
     */
    public int singleNumberII(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int number : A) {
            if (!count.containsKey(number)) {
                count.put(number, 1);
            } else if (count.get(number) == 1) {
                count.put(number, 2);
            } else {
                count.remove(number);
            }
        }
        if (count.size() != 1) {
            throw new IllegalArgumentException();
        }
        return count.keySet().iterator().next();
    }
}
