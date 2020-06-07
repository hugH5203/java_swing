package object_class;

import Student_System.Student;

public class Bjiao {
    public static void main(String[] args) {
        String a="haha";
        String b=new String("haha");
        System.out.println(a.equals(b));
        System.out.println(a==b);
        Student student=new Student();
        Student student1=new Student(5,"dd","f",2,"dd");
        System.out.println(student==student1);
        System.out.println(student.equals(student1));



    }
}
