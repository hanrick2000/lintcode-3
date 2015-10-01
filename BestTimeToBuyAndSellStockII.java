class BestTimeToBuyAndSellStockII {
    /**
     * Time: O(N)
     * Space: O(1)
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null) {
            throw new IllegalArgumentException();
        }

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price > minPrice) {
                maxProfit += price - minPrice;
            }
            minPrice = price;
        }
        return maxProfit;
    }
}
