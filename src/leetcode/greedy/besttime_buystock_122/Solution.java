package leetcode.greedy.besttime_buystock_122;//import org.junit.Test;

/**
 * @author Yancey
 * @version 1.0
 * @className Solution
 * @date 2024-03-14-20:40
 * @url https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
 * @description 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有一股 股票。
 * 你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：
 * 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7
 */

public class Solution {
    private int p = 0;

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println("new Solution().maxProfit(prices) = " + new Solution().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 只有在后一天价格高于当前价格时才买，只有卖出价格高于购入价才卖
        for (int i = 1; i < n; i++) {

            if (prices[i] - prices[i - 1] > 0) {
                int price = prices[i] - prices[i - 1];
                p += price;
            }
        }

        return p;
    }
}
