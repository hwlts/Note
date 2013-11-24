package ACM.CampusRecruit.WorksApplication;

public class ReductionFraction
{
    public static int maxGCD(int a, int b)
    {
        if (a < b)
        {
            int t = a;
            a = b;
            b = t;
        }

        while (a % b != 0)
        {
            int t = a % b;
            a = b;
            b = t;
        }

        return b;
    }

    public static void main(String[] args)
    {
        System.out.print(maxGCD(15,80));
    }
}
