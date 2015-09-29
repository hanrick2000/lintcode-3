### Singleton

```java
class Singleton {
    private static Singleton instance;

    private Singleton() {};

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

1. `private` constructor
2. `static` field
3. `static` method: `getInstance()`