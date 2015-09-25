### Find Peak Element

#### 1.Brute force

Time: O(N)

```java
public int findPeak(int[] A) {
    if (A == null || A.length < 3) {
        return -1;
    }
    
    for (int i = 1; i < A.length - 1; i++) {
        if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
            return i;
        }
    }
    return -1;
}
```

#### 1.Binary search

Time: O(logN)

```java
public int findPeak(int[] A) {
    if (A == null || A.length < 3) {
        return -1;
    }

    int low = 0;
    int high = A.length - 1;
    while (low < high) {
        int mid = low + (high - low) / 2;
        if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
            return mid;
        } else if (A[mid] > A[mid - 1]) {
            low = mid;
        } else {
            high = mid;
        }
    }
    return low;
}
```
