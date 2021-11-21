import java.util.LinkedList;

/**
 * Project name(项目名称)：保存图书信息
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/21
 * Time(创建时间)： 19:11
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test
{
    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        Book book1 = new Book(1, "数据结构", 69);
        Book book2 = new Book();
        book2.setSerialNumber(2);
        book2.setName("操作系统");
        book2.setPrice(89.5);
        Book book33 = new Book(3, "c程序设计", 149);
        LinkedList<Book> list = new LinkedList<>();
        list.add(book1);
        list.add(book2);
        list.add(book33);
        Book.write(list);
        Book.read();

        Book book3 = Book.read(2);
        if (book3 == null)
        {
            System.out.println("空");
        }
        else
        {
            System.out.println("编号：" + book3.getSerialNumber());
            System.out.println("书名：" + book3.getName());
            System.out.println("价格：" + book3.getPrice());
        }

        LinkedList<Book> list1 = Book.readAll();
        if (list1 == null)
        {
            System.out.println("空");
        }
        else
        {
            System.out.println("list:");
            for (Book book : list)
            {
                System.out.println(book);
            }
        }
        System.out.println();
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}
