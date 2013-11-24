package Algorithm.Test.LeetCode;

/**
 * You are climbing a stair case.
 * It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */

public class Climbing_Stairs
{
    public int climbStairs(int n)
    {
        if (0 == n || 1 == n)
            return 1;

        int a = 1, b = 1, i = 2;
        while(i <= n)
        {
            int t = a;
            a = a + b;
            b = t;
        }
        return a;
    }
}
