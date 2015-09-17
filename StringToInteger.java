public class StringToInteger {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        boolean isNeg = false;
        int start = 0;
        if (str.charAt(0) == '-') {
            isNeg = true;
            start++;
        } else if (str.charAt(0) == '+') {
            start++;
        }

        long result = 0;
        boolean hasPoint = false;
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hasPoint) {
                if (c != '0') {
                    return 0;
                } else {
                    continue;
                }
            }
            if (c == '.') {
                hasPoint = true;
                continue;
            }
            if (!Character.isDigit(c)) {
                break;
            }

            result = result * 10 + c - '0';
            if (isNeg && -result <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (!isNeg && result >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        if (isNeg) {
            result = -result;
        }
        return (int)result;
    }
}
