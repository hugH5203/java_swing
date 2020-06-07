//此类用于测试最传统的数据库连接方式  DriverManager.registerDriver(new Driver() )

package my.ceshi;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
import com.mysql.jdbc.Driver;

public class Jdbc_connect_ceshi {
    public static void main(String[] args) throws Exception {
        //加载驱动
        DriverManager.registerDriver(new Driver() );
        //获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees", "root", "123");
        System.out.println("连接成功");
        //sql查询语句
        String sql="update employees set email='hh5203' where employee_id=100";//修改语句
        //获取执行命令对象
        Statement statement= connection.createStatement();
        //使用刚刚获取的对象执行sql
        int update=statement.executeUpdate(sql);//返回值为一个int的值，将会显示在控制台
        //处理执行结果
        System.out.println(update>0?"查询成功":"查询失败");
        //关闭连接（每次都要）
        statement.close();
        connection.close();





    }
}
