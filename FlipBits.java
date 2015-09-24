class FlipBits {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        int bits = 0;
        a ^= b;
        while (a != 0) {
            bits += a & 1;
            a >>>= 1;
        }
        return bits;
    }
}

