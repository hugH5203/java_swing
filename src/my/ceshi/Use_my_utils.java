//此类用来调用封装的增删改查



package my.ceshi;

import java.util.List;

public class Use_my_utils {
    public static void main(String[] args) throws Exception{
        //输出一个结果
        Boys boys = My_utils.my_query("select * from boys where id=?", 2);
        System.out.println(boys);

        //输出一个结果集合
        List<Boys> list = My_utils.my_query_multi("select* from boys");//没有占位符则不用写
        for(Boys boys1:list){//遍历版for循环，遍历一个输出一个
            System.out.println(boys1);
        }

    }



}
