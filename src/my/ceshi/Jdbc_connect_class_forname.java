//该类用于演练Class.forName的用法与sql的增删改查


package my.ceshi;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class Jdbc_connect_class_forname {
    public static void main(String[] args) throws Exception {


  //方法一：

//调用src下写的文件
        Properties info =new Properties();//万事万物皆对象
        info.load(new FileInputStream("src\\jdbc.properties") {

        });//读入写的配置文件

        //给变量赋值
        String user=info.getProperty("user");
        String password=info.getProperty("password");
        String url=info.getProperty("url");
        String driver=info.getProperty("driver");

      /*  //方法二：直接用成员变量赋值
        String user = "root";
        String password = "123";
        String url = "jdbc:mysql://localhost:3306/myemployees";
        String driver = "com.mysql.jdbc.Driver";
*/

        //注册驱动
        Class.forName(driver);//class类的反射用法（用于加载类），比 DriverManager.registerDriver(new Driver())的效率高多了
        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //处理连接
        System.out.println("连接成功");
        System.out.println();
        System.out.println();


        //sql查询语句
        String sql = "update employees set email='hh5203' where employee_id=100";//修改语句
        //获取执行命令对象
        Statement statement = connection.createStatement();
        //使用刚刚获取的对象执行sql
        int update = statement.executeUpdate(sql);//返回为一个int的值（不会显示），只能执行增删改
        String sql2 = "select first_name,last_name,email from employees where employee_id=100";//一个查询语句
        boolean execute = statement.execute(sql2);//这个方法可以用于任何sql语句，但只会返回一个布尔值，没多大用，但可以用来判断表与库或数据是否删除或创建
        //获取一个可以执行查询语句的对象
        ResultSet set = statement.executeQuery(sql2);//只能执行查询语句

        boolean fiag = set.next();//一个类似于指针的方法，只会返回布尔类型  在这里还用不上（用于配合循环，查询出整张表）

        String first_name = set.getString(1);//获取查询出的第一个值
        String last_name = set.getString(2);//获取查询出的第二个值
        String email = set.getString(3);//获取查询出的第三个值
        //最后只能查出一行值，因为变量一次只能储存一个值

        //处理执行结果
        System.out.println(update > 0 ? "修改成功" : "修改失败");
        System.out.println();
        System.out.println();


//输出一行结果
        System.out.println("查询id=100的结果为:" + "\n" + first_name + "\t" + last_name + "\t" + email);
        System.out.println();
        System.out.println();

//接下来实验循环查询出增张表
        String sql3 = "select first_name,last_name,email,salary from employees where employee_id>100 and employee_id<160";//一个查询语句
        ResultSet show = statement.executeQuery(sql3);//只能执行查询语句
        System.out.println("查询id在100到160的结果为：");
        System.out.println("姓" + "\t\t\t\t" + "名" + "\t\t\t\t" + "邮箱" + "\t\t\t\t" + "工资" + "\t\t\t\t");
        while (show.next()) {//这里用while比较好，因为不知道循环的次数
            // 说明一下：show.next()是一个类似于指针的方法，从查出的第一列指起，只会返回布尔类型(用于配合循环，查询出整张表）
            String first_name2 = show.getString(1);//获取查询出的第一个值
            String last_name2 = show.getString(2);//获取查询出的第二个值
            String email2 = show.getString(3);//获取查询出的第三个
            int salary2 = show.getInt(4);//获取查询出的第四个
            System.out.print("\n" + first_name2 + "\t\t\t" + last_name2 + "\t\t\t" + email2 + "\t\t\t" + salary2);
        }

        //关闭连接（每次都要,除非用连接池）
        set.close();
        statement.close();
        connection.close();


    }


}

