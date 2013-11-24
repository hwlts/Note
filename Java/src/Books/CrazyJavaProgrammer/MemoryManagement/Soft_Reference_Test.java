package Books.CrazyJavaProgrammer.MemoryManagement;

import java.lang.ref.SoftReference;


/**
 * 内存足够时运行
 * 与-Xmx2m -Xms2m时运行
 * 可以看到不同之处
 *
 * The memory will be released when gc() is called and the heap memory is tight.
 */

class Person
{
    String name;
    int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String toString()
    {
        return "Person[" + name + ", age=" + age + "]";
    }
}

public class Soft_Reference_Test
{
    public static void main(String[] args) throws Exception
    {
        SoftReference<Person>[] people = new SoftReference[100000];

        for (int i = 0; i < people.length; ++i)
        {
            people[i] = new SoftReference<Person>(new Person("名字"+i,(i+1)*4%100));
        }

        System.out.println(people[2000].get());
        System.out.println(people[4000].get());

        System.gc();
        System.runFinalization();

        System.out.println(people[2000].get());
        System.out.println(people[4000].get());
    }
}
