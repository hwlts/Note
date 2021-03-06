package Books.MultiThreadDesignPattern.ThreadPerMessage;

public class Host
{
    private final Helper helper = new Helper();

    public void request(final int count, final char c)
    {
        System.out.println("\thandle(" + count + ", " + c + ") BEGIN");

        new Thread()
        {
            public void run()
            {
                helper.handle(count,c);
            }
        }.start();

        System.out.println("\thandle(" + count + ", " + c + ") END");
    }
}
