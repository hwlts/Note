package WeakPoint;

public class StaticConstructor
{
    static int i = 0;

    StaticConstructor()
    {
        i++;
    }

    public static void main(String[] args)
    {
        StaticConstructor s1 = new StaticConstructor();
        StaticConstructor s2 = new StaticConstructor();
    }
}
