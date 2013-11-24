package ACM.CampusRecruit.GoogleCodeJam0923;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class GoogleTestA
{
    static HashMap<Character, String> number_to_String = new HashMap<Character, String>();

    static
    {
        number_to_String.put('0', "zero");
        number_to_String.put('1', "one");
        number_to_String.put('2', "two");
        number_to_String.put('3', "three");
        number_to_String.put('4', "four");
        number_to_String.put('5', "five");
        number_to_String.put('6', "six");
        number_to_String.put('7', "seven");
        number_to_String.put('8', "eight");
        number_to_String.put('9', "nine");
    }

    static HashMap<Integer, String> consecutive = new HashMap<Integer, String>();

    static
    {
        consecutive.put(2, "double");
        consecutive.put(3, "triple");
        consecutive.put(4, "quadruple");
        consecutive.put(5, "quintuple");
        consecutive.put(6, "sextuple");
        consecutive.put(7, "septuple");
        consecutive.put(8, "octuple");
        consecutive.put(9, "nonuple");
        consecutive.put(10, "decuple");
    }

    static String getString(String s)
    {
        int i = 0;
        String r = "";
        while (i < s.length())
        {
            int c = 1;
            boolean b = false;
            while (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i))
            {
                ++c;
                ++i;
                b = true;
            }
            if (b)
            {
                if (c <= 10)
                {
                    String t = consecutive.get(c) + " " + number_to_String.get(s.charAt(i - 1)) + " ";
                    r += t;
                    ++i;
                    continue;
                }
                else
                {
                    String t = "";
                    for (int j = 0; j < c; ++j)
                    {
                        t += (number_to_String.get(s.charAt(i)) + " ");
                    }
                    r += t;
                    ++i;
                    continue;
                }
            }
            else
            {
                String t = number_to_String.get(s.charAt(i)) + " ";
                r += t;
                ++i;
            }
        }
        return r.substring(0, r.length() - 1);
    }

    public static void main(String[] args) throws Exception
    {

        FileInputStream file = new FileInputStream("C:\\Users\\Administrator\\Desktop\\A-large-practice.in");
        Scanner in = new Scanner(file);

        File fileout = new File("C:\\Users\\Administrator\\Desktop\\test.out");
        FileWriter out = new FileWriter(fileout);

        String line;
        int T = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= T; ++i)
        {
            out.write("Case #" + i + ": ");
            line = in.nextLine();
            String[] initIn = line.split(" ");
            String numbers = initIn[0];
            String[] spt = initIn[1].split("-");
            int begin = 0;
            String r = "";
            for (int j = 0; j < spt.length; ++j)
            {
                int temp = Integer.parseInt(spt[j]);
                int end = begin + temp;
                String s = numbers.substring(begin, end);
                String t = getString(s);
                r += (t + " ");
                begin = end;
            }
            if (i != T)
            {
                String res = r.substring(0, r.length() - 1) + "\r\n";
                out.write(res);
            }
            else
            {
                String res = r.substring(0, r.length() - 1);
                out.write(res);
            }
        }
        out.close();
        in.close();
    }
}
