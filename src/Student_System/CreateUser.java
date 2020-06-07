package Student_System;

import my.ceshi.Druid_connect_pool;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Scanner;

public class CreateUser {//创建用户
    public static void createUser() {
        JdbcTemplate template = new JdbcTemplate(Druid_connect_pool.get_druid_DataSource());
        System.out.println("--------------------------------------------以下是注册模式----------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        int password=scanner.nextInt();
        int update = template.update("insert into admin(username,password) values(?,?)", username, password);
        System.out.println(update > 0 ? "注册成功\n要牢记密码哦！\n接下来就是登陆咯" : "注册失败\n仔细想想是什么地方错了呢？（或许是输入值的类型");//处理结果


    }

}
