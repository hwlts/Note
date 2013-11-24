package WeakPoint.Design_Pattern_In_Java.Singleton;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Start.");

        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if (obj1 == obj2)
        {
            System.out.println("obj1和obj2是同一对象实例。");
        }
        else
        {
            System.out.println("obj1和obj2并非同与对象实例。");
        }

        System.out.println("End.");
    }
}