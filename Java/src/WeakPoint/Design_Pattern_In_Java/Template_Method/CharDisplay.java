package WeakPoint.Design_Pattern_In_Java.Template_Method;

public class CharDisplay extends AbstractDisplay
{
    private char ch;

    public CharDisplay(char ch)
    {
        this.ch = ch;
    }

    public void open()
    {
        System.out.print("<<");
    }

    public void print()
    {
        System.out.print(ch);
    }

    public void close()
    {
        System.out.println(">>");
    }
}
