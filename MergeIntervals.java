/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class MergeIntervals {
    /**
     * Time: O(NlogN)
     * Space: O(1)
     *
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        int i = 1;
        while (i < intervals.size()) {
            Interval prev = intervals.get(i - 1);
            Interval curr = intervals.get(i);
            if (curr.start > prev.end) {
                i++;
            } else {
                intervals.set(i - 1, new Interval(prev.start, Math.max(prev.end, curr.end)));
                intervals.remove(i);
            }
        }
        return intervals;
    }
}
