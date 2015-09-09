class HashFunction {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        long hash = 0;
        long num = 1;
        for (int i = key.length - 1; i >= 0; i--) {
            hash += num * key[i];
            hash = hash % HASH_SIZE;
            num = num * 33 % HASH_SIZE;
        }
        return (int)hash;
    }
}
