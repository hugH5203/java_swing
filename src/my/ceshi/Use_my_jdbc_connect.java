//测试我封装的connect，登录问题


package my.ceshi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Use_my_jdbc_connect {
    public static void main(String[] args) throws SQLException {
        //获取登录信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.next();//已空格值为结束标记

        System.out.println("请输入密码：");

        int password = scanner.nextInt();
//数据库的连接(用的封装类）

        Connection connection = My_jdbc_connect.myGetConnection();

        //一个登录的sql语句
        String sql="select count(*)from admin where username=? and password=?";//这里的问号是占位符


        //这里用的是预编译对象，比起statement好用多了
       PreparedStatement preparedStatement= connection.prepareStatement(sql);
       preparedStatement.setString(1,username);//第一个占位符的值,占位符从1开始
        preparedStatement.setInt(2,password);
        ResultSet resultSet=preparedStatement.executeQuery();//接收结果
        if (resultSet.next()){
            int count = resultSet.getInt(1);//获取查找出来的结果
            System.out.println(count>0?"登录成功":"登陆失败");
        }
        My_jdbc_connect.myClose(resultSet,preparedStatement,connection);




    }


}