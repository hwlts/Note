package ACM.CampusRecruit.HuaWeiTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test0
{
    public static void main(String[] args) throws IOException
    {
        List<Integer> l = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        final int count = 10;
        int i = 0;
        while (i++ < count && (line = reader.readLine()) != null)
        {
            int s = Integer.parseInt(line);
            l.add(s);
        }
        Collections.sort(l);
        if (l.get(9) >= 60)
        {
            System.out.println(60);
            return;
        }
        else
        {
            int t = l.get(5)/10;
            System.out.println(t*10);
        }
    }
}
