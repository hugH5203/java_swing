//此类用于插入数据批处理的运用，插入50000条记录


package my.ceshi;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Text_insert_databases {
    public static void main(String[] args) throws Exception {
        Connection conn= Druid_connect_pool.druid_GteConnect();
        String sql="insert into beauty(name,sex) values(?,?)";
        PreparedStatement pre = conn.prepareStatement(sql);
        for (int i = 0; i < 50000; i++) {
            pre.setString(1,"赵子龙"+i);//设置占位符的值
            pre.setString(2,"男");
            pre.addBatch();//添加sql命令到批处理包中
            if (i%1000==0){//每一千条处理一次，就相当于循环50次
                pre.executeBatch();//执行批处理中的命令
                pre.clearBatch();//清除批处理包中的命令
            }
        }
        System.out.println("成功插入");
    Druid_connect_pool.druid_close(null,pre,conn);
    }





}
