package WeakPoint.Crazy_Java_Programmer.Expression;

public class Mutable_String
{
    public static void main(String[] args)
    {
        StringBuilder str = new StringBuilder("Hello ");
        System.out.println(str);
        System.out.println(System.identityHashCode(str));

        str.append("Java");
        System.out.println(str);
        System.out.println(System.identityHashCode(str));

        str.append(", crazyit.org");
        System.out.println(str);
        System.out.println(System.identityHashCode(str));
    }
}
