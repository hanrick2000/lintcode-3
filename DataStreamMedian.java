public class DataStreamMedian {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length,
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(nums.length);
        int median = nums[0];
        result[0] = median;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < median) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(median);
                median = maxHeap.poll();
            } else if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(median);
                median = minHeap.poll();
            }
            result[i] = median;
        }
        return result;
    }
}
