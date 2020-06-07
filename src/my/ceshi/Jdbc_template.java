
//此类也是用来演示运行sql语句的增删改查，但它比阿帕奇的dbutils类更加方便，只需要传入一个数据源对象参数，就可以完成增删改查，连连接都都不用关
//这里我用的是阿里巴巴的druid数据源
package my.ceshi;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class Jdbc_template {
    public static void main(String[] args) throws Exception {
        // DataSource ds = Druid_connect_pool.get_druid_DataSource();//获取数据源对象(这一步可以简写)
        JdbcTemplate template = new JdbcTemplate(Druid_connect_pool.get_druid_DataSource());//一个Spring框架提供的处理jdbc 的类，需要传入一个数据源对象
//使用方法之修改
        //该update方法只需要传入sql语句与占位符的值
        int update = template.update("update boys set boyName=? where id=?", "黑夫", 4);
        System.out.println(update > 0 ? "修改成功" : "修改失败");//处理结果

        //插入
        int update2 = template.update("insert into boys(boyName,userCP) values(?,?)", "龙傲天", 1000);
        System.out.println(update2 > 0 ? "插入成功" : "插入失败");//处理结果

        //删除
        int update3 = template.update("delete from boys where boyName=?", "龙傲天");
        System.out.println(update3 > 0 ? "删除成功" : "删除失败");//处理结果
//查询
        //查询单条记录，把查询出来的单条记录封装成map集合，然后输出
        Map<String, Object> map = template.queryForMap("select * from beauty where id=?", 2);
        System.out.println(map);
        System.out.println();

        //查询多条记录,将多个map集合封装成一个List集合，然后输出（现实工作中很少用）
        List<Map<String, Object>> list = template.queryForList("select * from beauty ");

        for (Map<String, Object> map2 : list) {//读一条输出一条，让输出更加好看
            System.out.println(map2);
        }
        System.out.println();

      //查询多条记录，将其封装成实体类对象的List集合（现实生活中多数用该方法）
            //BeanPropertyRowMapper<>()该类你可以自己实现也可以使用spring框架提供的，这里使用的是提供的
            List<Boys> list2 = template.query("select* from boys", new BeanPropertyRowMapper<Boys>(Boys.class));
            for (Boys boys:list2) {
                System.out.println(boys);
            }


       //接下来是查询单个记录（一行一列，或一个值），一般用于聚合函数的查询
        Long aLong = template.queryForObject("select count(*) from beauty", Long.class);//该返回什么类型的值，就传入什么类型的类文件
        System.out.println(aLong);

    }

    }

