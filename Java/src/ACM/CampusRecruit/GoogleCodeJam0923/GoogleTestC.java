package ACM.CampusRecruit.GoogleCodeJam0923;


import java.io.*;
import java.util.*;

public class GoogleTestC
{
    static void Sort(Integer[] a)
    {
        List<Integer> sortA = new ArrayList<Integer>();
        List<Integer> sortB = new ArrayList<Integer>();

        for (int i = 0; i < a.length; i++)
        {
            if (Math.abs(a[i]) % 2 == 1)
            {
                sortA.add(a[i]);
            }
            else
            {
                sortB.add(a[i]);
            }
        }

        Collections.sort(sortA);
        Collections.sort(sortB);

        int IndexA = 0;
        int IndexB = sortB.size() - 1;

        for (int i = 0; i < a.length; i++)
        {
            if (Math.abs(a[i]) % 2 == 1)
            {
                a[i] = sortA.get(IndexA);
                IndexA++;
            }
            else
            {
                a[i] = sortB.get(IndexB);
                IndexB--;
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        FileInputStream file = new FileInputStream("C:\\Users\\Administrator\\Desktop\\C-large-practice.in");
        Scanner in = new Scanner(file);

        File fileout = new File("C:\\Users\\Administrator\\Desktop\\test.out");
        FileWriter out = new FileWriter(fileout);

        String line;
        int T = in.nextInt();
        for (int i = 1; i <= T; ++i)
        {
            out.write("Case #" + i + ": ");
            int length = in.nextInt();
            Integer[] a = new Integer[length];
            for (int j = 0; j < length; ++j)
            {
                a[j] = in.nextInt();
            }

            Sort(a);

            int j = 0;
            String res = "";

            for (; j < length - 1; ++j)
            {
                res += (a[j] + " ");
            }
            res += (a[j] + "");

            if (i != T)
            {
                out.write(res += "\r\n");
            }
            else
            {
                out.write(res);
            }
        }
        out.close();
        in.close();
    }
}
