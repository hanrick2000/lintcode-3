class TrailingZeros {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        long zeros = 0;
        while (n > 0) {
            zeros += n / 5;
            n /= 5;
        }
        return zeros;
    }
}

