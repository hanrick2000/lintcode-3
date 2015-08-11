public class SearchRange {
    /**
     * Time: O(logN)
     * Space: O(1)
     *
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        ArrayList<Integer> result = new ArrayList<>(2);
        if (A == null || A.isEmpty()) {
            result.add(-1);
            result.add(-1);
            return result;
        }

        result.add(findStart(A, target));
        result.add(findEnd(A, target));
        return result;
    }

    private int findStart(ArrayList<Integer> A, int target) {
        int low = 0;
        int high = A.size() - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == target) {
                high = mid;
            } else if (A.get(mid) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if (A.get(low) == target) {
            return low;
        }
        if (A.get(high) == target) {
            return high;
        }
        return -1;
    }

    private int findEnd(ArrayList<Integer> A, int target) {
        int low = 0;
        int high = A.size() - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == target) {
                low = mid;
            } else if (A.get(mid) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if (A.get(high) == target) {
            return high;
        }
        if (A.get(low) == target) {
            return low;
        }
        return -1;
    }
}

