package father_and_son;

import java.util.ArrayList;

public class Son extends Fu {

    String name = "哈哈";
    int age = 10;

    public static void main(String[] args) {
        Fu fu = new Son();
        System.out.println(fu.age);//父类应用指向子类，若有重名的成员变量，输出的一定是之类的成员变量
        System.out.println(fu.name);

        ArrayList<Son> list=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
           Son son =new Son();
            list.add(son);
            System.out.println(son);
        }


    }
}
