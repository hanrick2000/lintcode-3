public class PlusOne {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        boolean plus = true;
        int i = digits.length - 1;
        while (plus && i >= 0) {
            if (digits[i] == 9) {
                digits[i--] = 0;
            } else {
                digits[i]++;
                plus = false;
            }
        }
        if (plus) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }
}
