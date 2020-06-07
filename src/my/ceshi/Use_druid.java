//此类用于演示运用我封装的druid


package my.ceshi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Use_druid {
    public static void main(String[] args) throws Exception {
        Connection connection = Druid_connect_pool.druid_GteConnect();


        //该处为我运用封装类的实验
        String sql = "select name,sex,phone from beauty where id=1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        resultSet.next();//此处必须用该方法，否则指针会指向第一行的上方并报异常
        String name = resultSet.getString(1);
        String sex = resultSet.getString(2);
        if (name != null) {
            System.out.println(name + "\t\t" + sex);
        } else {
            System.out.println("数据不对");
        }


        Druid_connect_pool.druid_close(resultSet, preparedStatement, connection);
    }


}
