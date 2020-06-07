
//此类为我自己封装的sql类，


package my.ceshi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class My_utils {
    //修改方法(增删改)
    public static int my_update(String sql, Object... params) {//此处的Object...params为一个不知道参数数量的广义参数（代表着有0个或多个参数）
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            conn = Druid_connect_pool.druid_GteConnect();
            pre = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pre.setObject(i + 1, params[i]);//sql中的占位符，设置为参数中的值
            }
            int update = pre.executeUpdate();//返回受影响的结果集
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);

        } finally {
            Druid_connect_pool.druid_close(null, pre, conn);


        }


    }

//查询一条记录
    public static Boys my_query(String sql, Object... params) {

        PreparedStatement pre = null;
        Connection conn = null;
        ResultSet res = null;
        try {
            conn = Druid_connect_pool.druid_GteConnect();
            pre = conn.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                pre.setObject(i + 1, params[i]);//sql中的占位符，设置为参数中的值
            }
            res = pre.executeQuery();
            if (res.next()) {
                int id = res.getInt("id");
                String boyname = res.getString("boyName");
                int userCP = res.getInt("userCP");
                Boys boys = new Boys(id, boyname, userCP);
                return boys;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);

        } finally {
            Druid_connect_pool.druid_close(res, pre, conn);
        }
    }




//查询多条记录
    public static List<Boys> my_query_multi(String sql, Object... params) {//泛型集合

        PreparedStatement pre = null;
        Connection conn = null;
        ResultSet res = null;
        try {
            conn = Druid_connect_pool.druid_GteConnect();
            pre = conn.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                pre.setObject(i + 1, params[i]);//sql中的占位符，设置为参数中的值
            }
            res = pre.executeQuery();
            List <Boys> list=new ArrayList<>() ;//获取集合实例
            while (res.next()) {
                int id = res.getInt("id");
                String boyname = res.getString("boyName");
                int userCP = res.getInt("userCP");
                Boys boys = new Boys(id, boyname, userCP);
              list.add(boys);//加入集合
            }
            return list;//返回这个集合
        } catch (Exception e) {
            throw new RuntimeException(e);

        } finally {
            Druid_connect_pool.druid_close(res, pre, conn);
        }
    }




}
