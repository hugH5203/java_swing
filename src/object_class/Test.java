package object_class;

import Student_System.Student;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        Student student = new Student();
        Class<Student> studentClass = Student.class;
        Class<Student> studentClass1 = Student.class;
        Student student1 = studentClass.newInstance();//获取无参构造器构造出来的一个运行对象，只能用运行期的方法，不能使用字节码对象的方法
        System.out.println(student == student1);//false,说明字节码文件对象与运行对象不是同一个
        System.out.println(studentClass == studentClass1);//true, 两个一模一样，说明字节码文件只会加载一次
        Method setSex = studentClass.getMethod("getClassname");
        setSex.invoke(student);//该参数中的对象必须是运行期对象，而不是字节码文件被加载到内存时的对象
        //  setSex.invoke(studentClass);//报异常 object is not an instance of declaring class 对象不是声明类的一个实例
        Method[] methods = studentClass.getMethods();

        for (Method method : methods) {

            System.out.println(method);
        }


    }

}
