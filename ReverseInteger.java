public class ReverseInteger {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        boolean isNegative = false;
        long original = n;
        if (original < 0) {
            isNegative = true;
            original = -original;
        }

        long result = 0;
        while (original > 0) {
            result *= 10;
            result += original % 10;
            original /= 10;
        }

        if (isNegative) {
            result =  -result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }
}
