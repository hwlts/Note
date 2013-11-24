package WeakPoint.DesignPatternInJava.Factory_Method;

public class Main
{
    public static void main(String[] args)
    {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("结城浩");
        Product card2 = factory.create("户村");
        Product card3 = factory.create("佐藤花子");

        card1.use();
        card2.use();
        card3.use();
    }
}
