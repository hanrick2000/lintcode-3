class BestTimeToBuyAndSellStockIII {
    /**
     * Time: O(N)
     * Space: O(N)
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] left = new int[prices.length];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i - 1];
            min = Math.min(min, price);
            left[i - 1] = Math.max(left[i - 1], price - min);
        }

        int[] right = new int[prices.length];
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            int price = prices[i];
            max = Math.max(max, price);
            right[i] = Math.max(right[i + 1], max - price);
        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        return maxProfit;
    }
}
