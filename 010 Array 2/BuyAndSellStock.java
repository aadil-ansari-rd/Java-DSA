// class Solution {
//     public int maxProfit(int[] prices) {
//         int minBuy = prices[0];
//         int maxProfit = Integer.MIN_VALUE;
//         for (int i = 1; i < prices.length; i++) {
//             minBuy = Math.min(minBuy, prices[i]);
//             int profit = prices[i] - minBuy;
//             maxProfit = Math.max(maxProfit, profit);
//         }
//         if (maxProfit <= 0) {
//             return 0;
//         }
//         return maxProfit;

//     }
// }



class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (minBuy < prices[i]) {
                int profit = prices[i] - minBuy;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                minBuy = prices[i];
            }
        }
        return maxProfit;

    }
}