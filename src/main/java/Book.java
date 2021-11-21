import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Project name(项目名称)：保存图书信息
 * Package(包名): PACKAGE_NAME
 * Class(类名): Book
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/21
 * Time(创建时间)： 19:00
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Book
{
    private int SerialNumber;        //编号
    private String name;        //书名
    private double price;       //价格

    public Book()
    {

    }

    public Book(int serialNumber, String name, double price)
    {
        if (serialNumber >= 0)
        {
            this.SerialNumber = serialNumber;
        }
        else
        {
            this.SerialNumber = 0;
        }
        this.name = name;
        if (price >= 0)
        {
            this.price = price;
        }
        else
        {
            this.price = 0;
        }
    }

    public int getSerialNumber()
    {
        return SerialNumber;
    }

    public void setSerialNumber(int serialNumber)
    {
        if (serialNumber >= 0)
        {
            this.SerialNumber = serialNumber;
        }
        else
        {
            this.SerialNumber = 0;
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        if (price >= 0)
        {
            this.price = price;
        }
        else
        {
            this.price = 0;
        }
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("编号： ").append(SerialNumber).append('\t');
        stringbuilder.append("书名： ").append(name).append('\t');
        stringbuilder.append("价格： ").append(price);
        return stringbuilder.toString();
    }

    public static void write(List<Book> books)
    {
        FileWriter fileWriter = null;
        try
        {
            fileWriter = new FileWriter("books.txt"); // 创建FileWriter对象
            for (Book book : books)
            {
                fileWriter.write(book.toString() + "\n"); //循环写入
            }
            fileWriter.write("end");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                if (fileWriter != null)
                {
                    fileWriter.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void read()
    {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try
        {
            fileReader = new FileReader("books.txt");
            bufferedReader = new BufferedReader(fileReader); // 创建BufferedReader对象
            String str;
            while ((str = bufferedReader.readLine()) != null)
            { // 循环读取每行数据
                System.out.println(str); // 输出读取的内容
            }
        }
        catch (FileNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件未找到！！！");
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                if (bufferedReader != null)
                {
                    bufferedReader.close();
                }
                if (fileReader != null)
                {
                    fileReader.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static Book read(int serialNumber)
    {
        Book book = new Book();
        FileReader fileReader = null;
        Scanner input = null;
        try
        {
            File file;
            fileReader = new FileReader("books.txt");
            input = new Scanner(fileReader);
            while (!input.next().equals("end"))
            {
                book.setSerialNumber(input.nextInt());
                input.next();
                book.setName(input.next());
                input.next();
                book.setPrice(input.nextDouble());
                if (book.getSerialNumber() == serialNumber)
                {
                    break;
                }
            }
            return book;
        }
        catch (FileNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件打开失败！！！");
            book = null;
            return null;
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("未知错误:");
            e.printStackTrace();
            book = null;
            return null;
        }
        finally
        {
            try
            {
                if (fileReader != null)
                {
                    fileReader.close();
                }
                if (input != null)
                {
                    input.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static LinkedList<Book> readAll()
    {
        LinkedList<Book> list = new LinkedList<>();

        FileReader fileReader = null;
        Scanner input = null;
        try
        {
            fileReader = new FileReader("books.txt");
            input = new Scanner(fileReader);
            while (!input.next().equals("end"))
            {
                Book book = new Book();
                book.setSerialNumber(input.nextInt());
                input.next();
                book.setName(input.next());
                input.next();
                book.setPrice(input.nextDouble());
                list.add(book);
            }
            return list;
        }
        catch (FileNotFoundException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("文件打开失败！！！");
            return null;
        }
        catch (Exception e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.out.println("未知错误:");
            e.printStackTrace();
            return null;
        }
        finally
        {
            try
            {
                if (fileReader != null)
                {
                    fileReader.close();
                }
                if (input != null)
                {
                    input.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
