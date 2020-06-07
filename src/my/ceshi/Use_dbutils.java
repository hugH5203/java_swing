//此类为对dbutils类的使用，是开源组织阿帕奇提供的，它查询的基础是有一个与表所对应的实体类，非常好用。在这里我之所以只用boys表，因为我只建了这个实体类



package my.ceshi;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class Use_dbutils {
    public static void main(String[] args) throws Exception {
        //增删改都可以用update方法
        Connection conn = Druid_connect_pool.druid_GteConnect();
        QueryRunner qu=new QueryRunner();//获取dbutils的对象
        int update = qu.update(conn, "update boys set boyName=? where id=2", "胡歌");
        System.out.println("第一次命令：增删改类型");
        System.out.println(update>0? "修改成功":"修改失败");
        System.out.println();

        //接下来是查询单条语句,其中的BeanHandler<>()的参数必须为一个指定的类.class，z这样才能返回该对象
        Boys boy = qu.query(conn, "select * from boys where id=?", new BeanHandler<>(Boys.class),1);
        //上面的BeanHandler<>()需要用到一个无参的构造，如果已经创建了构造函数，回去加上无参的，否则报错，为什么是无参构造呢？因为不好传参数
        System.out.println("第二次命令：查询单条记录");
        System.out.println(boy);//打印它

        System.out.println();


        //再然后是多条记录的查询
        List<Boys> list= qu.query(conn, "select * from boys where id>? and id<?", new BeanListHandler<>(Boys.class), 0, 5);
        System.out.println("第三次命令：多条查询");
        for (Boys boy2:list) {//让输出结果好看些
            System.out.println(boy2);
        }
        System.out.println();
        //接下来是单行单列查询（即一个值的查询），因为此处的结果不再是一个对象，所以并不需要一个实体类（Bean）,所以不需要用Bean/Bean List handler<>()
        Object count = qu.query(conn, "select count(*) from beauty ", new ScalarHandler());//
        System.out.println("第四次命令：单个值查询");
        System.out.println(count);

        //关闭连接
        Druid_connect_pool.druid_close(null, null, conn);

    }





}


