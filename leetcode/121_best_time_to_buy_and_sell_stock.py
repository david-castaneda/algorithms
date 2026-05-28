# Time: O(n)
# Space: O(1)
class Solution:
    def maxProfit(self, prices):
        min_price = float("inf")
        max_profit = 0

        for p in prices:
            profit = p - min_price
            min_price = min(p, min_price)
            max_profit = max(profit, max_profit)

        return max_profit