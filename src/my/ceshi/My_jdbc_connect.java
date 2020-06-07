
//自己封装的connect类

package my.ceshi;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class My_jdbc_connect {
    static String user;
    static String password;
    static String url;
    static String driver;


    static {

//调用src下写的文件
        Properties info =new Properties();//万事万物皆对象
        try {
            info.load(new FileInputStream("src\\jdbc.properties2.properties") {

            });//读入写的配置文件
        } catch (IOException e) {
            e.printStackTrace();
        }

        //给变量赋值
 user=info.getProperty("user");
 password=info.getProperty("password");
   url=info.getProperty("url");
      driver=info.getProperty("driver");

        try {
            Class.forName(driver);//注册驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection myGetConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);


    }


    public static void myClose(ResultSet resultSet, Statement statement, Connection connection) {


        try {
            if (resultSet != null) {

                resultSet.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (statement != null) {

                    statement.close();


                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {

                    connection.close();


                }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}



