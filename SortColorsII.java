class SortColorsII {
    /**
     * Time: O(N)
     * Space: O(1)
     *
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null) {
            return;
        }
        sort(colors, 0, colors.length - 1, 1, k);
    }

    private void sort(int[] colors, int start, int end, int smallest, int largest) {
        if (start >= end) {
            return;
        }
        if (smallest >= largest) {
            return;
        }

        int mid = smallest + (largest - smallest) / 2;
        int low = start;
        int high = end;
        while (low <= high) {
            if (colors[low] <= mid) {
                low++;
            } else if (colors[high] > mid) {
                high--;
            } else {
                swap(colors, low++, high--);
            }
        }
        sort(colors, start, low, smallest, mid);
        sort(colors, high, end, mid + 1, largest);
    }

    private void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
