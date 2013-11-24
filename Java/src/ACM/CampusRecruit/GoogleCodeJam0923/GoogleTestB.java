package ACM.CampusRecruit.GoogleCodeJam0923;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class GoogleTestB
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream file = new FileInputStream("C:\\Users\\Administrator\\Desktop\\B-large-practice.in");
        Scanner in = new Scanner(file);

        File fileOut = new File("C:\\Users\\Administrator\\Desktop\\test.out");
        FileWriter out = new FileWriter(fileOut);

        int T = in.nextInt();
        for (int i = 1; i <= T; ++i)
        {
            out.write("Case #" + i + ": ");
            int t = in.nextInt();
            if (t == 1)
            {
                BigInteger n = in.nextBigInteger();
                BigInteger p = new BigInteger("1");
                BigInteger q = new BigInteger("1");

                List<Boolean> l = new LinkedList<Boolean>();
                while (n.compareTo(new BigInteger("1")) > 0)
                {
                    if (n.remainder(new BigInteger("2")).equals(new BigInteger("0")))
                        l.add(true);        //left child
                    else
                        l.add(false);       //right child

                    n = n.divide(new BigInteger("2"));
                }

                Collections.reverse(l);

                for (Boolean b : l)
                {
                    if (b)
                    {
                        q = q.add(p);
                    }
                    else
                    {
                        p = p.add(q);
                    }
                }

                out.write(p + " " + q + "\r\n");
            }
            else
            {
                BigInteger x = in.nextBigInteger();
                BigInteger y = in.nextBigInteger();
                List<Boolean> l = new LinkedList<Boolean>();

                BigInteger n = new BigInteger("1");

                while (!x.equals(new BigInteger("1")) || !y.equals(new BigInteger("1")))
                {
                    if ((x.compareTo(y)) < 0)
                    {
                        l.add(true);        //left child;
                        y = y.add(x.negate());
                    }
                    else
                    {
                        l.add(false);       //right child;
                        x = x.add(y.negate());
                    }
                }

                Collections.reverse(l);

                for (Boolean b : l)
                {
                    if (b)
                    {
                        n = n.multiply(new BigInteger("2"));
                    }
                    else
                    {
                        n = n.multiply(new BigInteger("2")).add(new BigInteger("1"));
                    }
                }

                out.write(n + "\r\n");
            }
        }
        out.close();
        in.close();
    }
}
