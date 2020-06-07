package father_and_son;

public class Manyclass {


    int age=18;

   static class Small{
        int age2=10;


    }

    public static void main(String[] args) {
        Small small=new Small();
        System.out.println(small.age2);//除非内部类是static 修饰的，就可以直接new
       // Manyclass.Small small1=new Manyclass().new Small();这就是内部类不是static 修饰的时候的实例化方式，想要调用内部类的方法，必须先实例化外部类



    }
}
