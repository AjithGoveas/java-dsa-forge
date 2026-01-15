package LeetCode;

public class L0121 {
    static class Solution {
        // TODO: Make it proper - solution not perfect
        public int maxProfit(int[] prices) {
            int profit = 0;

            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[i] > prices[j]) {
                        continue;
                    } else if (prices[i] < prices[j]) {
                        profit = Math.max(profit, prices[j] - prices[i]);
                    }
                }
            }

            return profit;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(s.maxProfit(prices));
    }
}
