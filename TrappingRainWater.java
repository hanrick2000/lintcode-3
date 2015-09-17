public class TrappingRainWater {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        if (heights == null || heights.length < 3) {
            return 0;
        }

        int result = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            if (left > 0 && heights[left] < heights[left - 1]) { //fill left
                result += heights[left - 1] - heights[left];
                heights[left] = heights[left - 1];
            } else if (right < heights.length - 1 && heights[right] < heights[right + 1]) { // fill right
                result += heights[right + 1] - heights[right];
                heights[right] = heights[right + 1];
            } else if (heights[left] <= heights[right]) { // advance
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
