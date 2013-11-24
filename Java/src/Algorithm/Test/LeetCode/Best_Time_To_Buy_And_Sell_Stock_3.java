package Algorithm.Test.LeetCode;

/**
 * Say you have an array for which
 * the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 */

public class Best_Time_To_Buy_And_Sell_Stock_3
{
    public int maxProfit(int[] prices)
    {
        if (prices.length <= 1)
            return 0;

        int[] firstProfits = new int[prices.length];
        int minPrice = prices[0];
        int firstProfit = 0;
        for (int i = 0; i < prices.length; ++i)
        {
            if (prices[i] < minPrice)
            {
                minPrice = prices[i];
                firstProfits[i-1] = firstProfit;
            }
            else
            {
                firstProfit = ((prices[i]-minPrice)>firstProfit) ? (prices[i] - minPrice) : firstProfit;
                firstProfits[i] = firstProfit;
            }
        }

        int MaxProfit = 0;
        int maxPrice = prices[prices.length-1];
        int secondProfit = 0;
        for (int i = prices.length-1; i >= 0; --i)
        {
            if (prices[i] > maxPrice)
            {
                maxPrice = prices[i];
            }
            else
            {
                secondProfit = ((maxPrice-prices[i]) > secondProfit) ? (maxPrice-prices[i]) : secondProfit;
            }

            if ((secondProfit+firstProfits[i]) > MaxProfit)
                MaxProfit = secondProfit+firstProfits[i];
        }

        return MaxProfit;
    }
}