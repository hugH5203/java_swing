package Student_System;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class Fuctions {
    //查询全部
    public static void showall(JdbcTemplate template) {
        List<Student> list1 = template.query("select* from student", new BeanPropertyRowMapper<Student>(Student.class));
        for (Student student : list1) {
            System.out.println(student);
        }
    }

    //按学号查找
    public static void show_one(JdbcTemplate template, int sno) {
        Map<String, Object> map = template.queryForMap("select * from student where sno=?", sno);
        System.out.println(map);
    }

    //添加学生记录
    public static void insert(JdbcTemplate template, String name, String sex, int sno, String classname) {
        int update1 = template.update("insert into student(name,sex,sno,classname) values(?,?,?,?)", name, sex, sno, classname);
        System.out.println(update1 > 0 ? "插入成功" : "插入失败\n仔细想想是什么地方错了呢？（或许是输入值的类型）");//处理结果
    }

    //修改学生记录(根据姓名)
    public static void update(JdbcTemplate template, String name1, String sex, int sno, String classname, String name2) {
        int update2 = template.update("update student set name=?,sex=?,sno=?,classname=? where name=?", name1, sex, sno, classname, name2);
        System.out.println(update2 > 0 ? "修改成功" : "修改失败\n仔细想想是什么地方错了呢？（或许是输入值的类型）");//处理结果
    }

    //删除学生记录(根据姓名)
    public static void delete(JdbcTemplate template, String name) {
        int update3 = template.update("delete from student where name=?", name);
        System.out.println(update3 > 0 ? "删除成功" : "删除失败\n仔细想想是什么地方错了呢？（或许是输入值的类型）");//处理结果
    }


}
