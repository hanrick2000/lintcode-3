public class BestTimeToBuyAndSellStock {
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

        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            buyPrice = Math.min(price, buyPrice);
            maxProfit = Math.max(maxProfit, price - buyPrice);
        }
        return maxProfit;
    }
}
