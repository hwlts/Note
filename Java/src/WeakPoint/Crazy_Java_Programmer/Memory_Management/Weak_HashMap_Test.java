package WeakPoint.Crazy_Java_Programmer.Memory_Management;

import java.util.WeakHashMap;

class Crazy_Key
{
    String name;

    public Crazy_Key(String name)
    {
        this.name = name;
    }

    public int hashCode()
    {
        return name.hashCode();
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;

        if (obj != null && obj.getClass() == Crazy_Key.class)
        {
            return name.equals(((Crazy_Key)obj).name);
        }

        return false;
    }

    public String toString()
    {
        return "Crzy_Key[name=" + name + "]";
    }
}

public class Weak_HashMap_Test
{
    public static void main(String[] args) throws Exception
    {
        WeakHashMap<Crazy_Key,String> map = new WeakHashMap<Crazy_Key, String>();

        for (int i = 0; i < 10; ++i)
        {
            map.put(new Crazy_Key(i+1+""),"value"+i+11);
        }

        System.out.println(map);
        System.out.println(map.get(new Crazy_Key("2")));

        System.gc();
        Thread.sleep(50);

        System.out.println(map);
        System.out.println(map.get(new Crazy_Key("2")));

    }
}
