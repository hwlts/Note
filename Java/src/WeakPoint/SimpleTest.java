package WeakPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleTest
{
    public static void main(String[] args)
    {
        List<String> l = new ArrayList<String>();
        l.add("girl");
        l.add("boy");
        l.add("gird");

        Collections.sort(l);

        System.out.println(l);
    }
}
