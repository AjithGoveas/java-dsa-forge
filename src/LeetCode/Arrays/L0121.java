package LeetCode.Arrays;


/// # [L0121: Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock)
/// ## Level - Easy
/// You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day.
///
/// You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.
///
/// Return the _maximum profit you can achieve from this transaction_. If you cannot achieve any profit, return `0`.
///
/// **Example 1:**
/// ```txt
/// Input: prices = [7,1,5,3,6,4]
/// Output: 5
/// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
/// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
/// ```
///
/// **Example 2:**
/// ```txt
/// Input: prices = [7,6,4,3,1]
/// Output: 0
/// Explanation: In this case, no transactions are done and the max profit = 0.
/// ```

public class L0121 {
    static class Solution {
        // TODO: Make it proper - solution not perfect
        // Maybe try DP for pattern memory
        public int maxProfit(int[] prices) {
            int profit = 0;

            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[i] > prices[j]) {
                        continue;
                    } else if (prices[i] < prices[j]) {
                        int diff = prices[j] - prices[i];

                        if (diff > profit) {
                            profit = diff;
                        }
                    }
                }
            }

            return profit;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(s.maxProfit(prices));
    }
}
