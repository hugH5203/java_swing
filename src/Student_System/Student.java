package Student_System;

public class Student {
    private  int id;
    private  String name;//名字
    private  String sex;//性别
    private int sno;//学号
    private  String classname;//班级

    public Student(int id, String name, String sex, int sno, String classname) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.sno = sno;
        this.classname = classname;
    }

    public Student() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", sno=" + sno +
                ", classname='" + classname + '\'' +
                '}';
    }
}
