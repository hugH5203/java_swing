package Student_System;

import my.ceshi.Druid_connect_pool;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Scanner;

public class MainFuction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/*        My_frame my_frame=new My_frame();
        my_frame.come_in();
        String username = my_frame.getText();
        String password = my_frame.getPwd();*/

        System.out.println("请问亲有账号吗，输入旁边的代号回答哦！");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t0：老子没有，要注册");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t反正不是0：你爸爸早就有了");

        int have = 0;
        try {
            have = scanner.nextInt();
        } catch (Exception e) {
       e.printStackTrace();
            return;
        }finally {
            System.out.println("您输入的命令不符合要求");
        }

        switch (have) {
            case 0: {
                CreateUser.createUser();
            }
            break;
            default: {
                System.out.println("那就请开始你的表演！");

            }
            break;
        }
        JdbcTemplate template = new JdbcTemplate(Druid_connect_pool.get_druid_DataSource());
        System.out.println("运行了");
        System.out.println("---------------------------------------------------以下是管理员操作模式----------------------------------------------");

        System.out.println("请输入用户名：");
        String username = scanner.next();
        System.out.println("请输入密码：");
        int password = 0;
        try {
            password = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("密码类型错误，请输入数字！");
            return;
        }
        //登录验证
        //方法一：
        /* int update1= template.update("update admin set password=123 where username=? and password=?", username, password);
        System.out.println(update1>0?"登录成功":"登录失败");
         */
        //方法二：
        Long aLong = template.queryForObject("select count(*) from admin where username=? and password=?", Long.class, username, password);//该返回什么类型的值，就传入什么类型的类文件
        System.out.println(aLong > 0 ? "登录成功" : "登录失败\n仔细想想是不是密码或用户名错了呢?");
        if (aLong > 0) {
            System.out.println("请输入你想要进行的操作代号：");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t1：查询所有学生记录");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t2：查询某一学生记录");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t3：添加一个生记录");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t4：修改某一个学生记录");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t5：删除某一个学生记录");
            int i = scanner.nextInt();
            switch (i) {
                case 1: {
                    Fuctions.showall(template);
                }
                break;
                case 2: {
                    System.out.println("请输入要查询学生的学号");
                    int sno = scanner.nextInt();
                    Fuctions.show_one(template, sno);
                }
                break;
                case 3: {
                    System.out.println("请输入姓名：");
                    String name = scanner.next();
                    System.out.println("请输入性别：");
                    String sex = scanner.next();
                    System.out.println("请输入学号：");
                    int sno = scanner.nextInt();
                    System.out.println("请输入班级：");
                    String classname = scanner.next();
                    Fuctions.insert(template, name, sex, sno, classname);
                }
                break;
                case 4: {
                    System.out.println("请输入要修改的学生的姓名：");
                    String name2 = scanner.next();
                    System.out.println("请输入修改后学生的姓名：");
                    String name1 = scanner.next();
                    System.out.println("请输入修改后学生的性别：");
                    String sex = scanner.next();
                    System.out.println("请输入修改后学生的学号：");
                    int sno = scanner.nextInt();
                    System.out.println("请输入修改后学生的班级：");
                    String classname = scanner.next();
                    Fuctions.update(template, name1, sex, sno, classname, name2);
                }
                break;
                case 5: {
                    System.out.println("请输入要删除的学生的姓名");
                    String name = scanner.next();
                    Fuctions.delete(template, name);
                }
                break;
                default: {
                    System.out.println("你输入的代号不对，请重新运行输入");
                }
                break;

            }


        }

    }

}
