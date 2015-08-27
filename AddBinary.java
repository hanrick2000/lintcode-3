public class AddBinary {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int count = 0;
        while (i >= 0 || j >= 0 || count > 0) {
            int sum = count;
            if (i >= 0) {
                if (a.charAt(i) == '1') {
                    sum++;
                }
                i--;
            }
            if (j >= 0) {
                if (b.charAt(j) == '1') {
                    sum++;
                }
                j--;
            }
            sb.append(sum % 2);
            count = sum >= 2 ? 1 : 0;
        }
        return sb.reverse().toString();
    }
}
