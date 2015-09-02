public class CountOneInBinary {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        int count = 0;
        if (num < 0) {
            num = -num;
            count++;
        }
        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }
}
