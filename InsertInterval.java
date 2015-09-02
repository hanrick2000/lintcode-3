/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class InsertInterval {
    /**
     * Time: O(N)
     * Space: O(N)
     *
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }

        int i = 0;
        for (i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.end < newInterval.start) {
                result.add(curr);
            } else if (newInterval.end < curr.start) {
                break;
            } else {
                newInterval.start = Math.min(newInterval.start, curr.start);
                newInterval.end = Math.max(newInterval.end, curr.end);
            }
        }
        result.add(newInterval);
        while (i < intervals.size()) {
            result.add(intervals.get(i++));
        }
        return result;
    }
}
