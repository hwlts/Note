package Books.CrazyJavaProgrammer.Expression;


public class Immutable_String
{
    public static void main(String[] args)
    {
        String str = "Hello ";
        System.out.println(System.identityHashCode(str));

        str += "Java";
        System.out.println(System.identityHashCode(str));

        str += ", crazyit.org";
        System.out.println(System.identityHashCode(str));
    }
}
