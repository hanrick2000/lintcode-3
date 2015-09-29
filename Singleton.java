class Singleton {
    private static Singleton instance;

    private Singleton() {};

    /**
     * @return: The same instance of this class every time
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
