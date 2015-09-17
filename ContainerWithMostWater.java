public class ContainerWithMostWater {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int result = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int area = 0;
            if (heights[left] <= heights[right]) {
                area = heights[left] * (right - left);
                left++;
            } else {
                area = heights[right] * (right - left);
                right--;
            }
            result = Math.max(result, area);
        }
        return result;
    }
}
