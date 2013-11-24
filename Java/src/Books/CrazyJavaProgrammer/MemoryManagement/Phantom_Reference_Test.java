package Books.CrazyJavaProgrammer.MemoryManagement;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class Phantom_Reference_Test
{
    public static void main(String[] args) throws Exception
    {
        String str = new String("疯狂Java讲义");

        ReferenceQueue<String> rq = new ReferenceQueue<String>();

        PhantomReference<String> pr = new PhantomReference<String>(str,rq);

        str = null;

        System.out.println(pr.get());

        System.gc();
        System.runFinalization();

        System.out.println(rq.poll() == pr);
    }
}
