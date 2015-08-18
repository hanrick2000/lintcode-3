/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
*/
class FindFirstBadVersion {
    /**
     * Time: O(logN)
     * Space: O(1)
     *
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion_discrete(int n) {
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (VersionControl.isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int findFirstBadVersion(int n) {
        int low = 0;
        int high = n;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (VersionControl.isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        if (VersionControl.isBadVersion(low)) {
            return low;
        }
        return high;
    }
}

