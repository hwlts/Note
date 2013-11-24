package WeakPoint.Design_Pattern_In_Java.Adapter;

public class Main
{
    public static void main(String[] args)
    {
        Print p = new PrintBanner("Hello");

        p.printWeak();
        p.printStrong();
    }
}
