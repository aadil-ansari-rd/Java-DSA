public class BestTimeToBuySellGreedy {

    // Function to calculate maximum profit using greedy approach
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0]; // Track lowest price to buy
        int maxProfit = 0; // Track maximum profit found

        for (int i = 1; i < prices.length; i++) {
            // Update minPrice if we find a lower price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate profit if sold today
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices1)); // Output: 0

        int[] prices2 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices2)); // Output: 5
    }
}
