package leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//
// Time: O(n)
// Space: O(1)
// Intuition: Keep track of min, calculate maxProfit (cur - min) each time 
public class BestTimeToBuyAndSellStock_121 {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        int min = prices[0];
        int maxProfit = 0;

        for (int p : prices) {
            min = Math.min(min, p);
            maxProfit = Math.max(maxProfit, p - min);
        }

        System.out.printf("Max profit: %d", maxProfit);
    }
}
