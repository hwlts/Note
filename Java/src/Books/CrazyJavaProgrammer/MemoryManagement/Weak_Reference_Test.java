package Books.CrazyJavaProgrammer.MemoryManagement;

import java.lang.ref.WeakReference;

/**
 * Whenever gc() is called, the memory will be released.
 */

public class Weak_Reference_Test
{
    public static void main(String[] args) throws Exception
    {
        String str = new String("疯狂Java讲义");

        WeakReference<String> wr = new WeakReference<String>(str);

        str = null;

        System.out.println(wr.get());

        System.gc();
        System.runFinalization();

        System.out.println(wr.get());
    }
}
