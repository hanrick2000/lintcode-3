public class SingleNumber {
    /**
     *@param A : an integer array
     *return : a integer
     */
    public int singleNumber(int[] A) {
        if (A == null) {
            throw new IllegalArgumentException();
        }

        int single = 0;
        for (int number : A) {
            single ^= number;
        }
        return single;
    }
}
