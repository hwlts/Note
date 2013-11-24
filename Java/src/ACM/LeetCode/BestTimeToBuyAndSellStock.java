package ACM.LeetCode;

/**
 * Say you have an array for which
 * the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 */

public class BestTimeToBuyAndSellStock
{
    public int maxProfit(int[] prices)
    {
        if (0 == prices.length)
            return 0;

        int maxProfit = 0;
        int l_profit = 0;

        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; ++i)
        {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else
            {
                l_profit = prices[i]-minPrice;
                maxProfit = (l_profit > maxProfit) ? l_profit : maxProfit;
            }
        }

        return maxProfit;
    }
}
