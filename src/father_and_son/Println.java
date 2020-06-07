package father_and_son;

/**
 * @author HuangHai
 * @date 2020/5/11 13:20
 */
public class Println {
    public static void main(String[] args) {
        int a=1;
        String s="你好";
        String x="哈哈";
        int b=2;
        //System.out.println(s,x); 用逗号隔开是错误的,println的源码里根本就没这个方法
        System.out.println(s+x);
    }
}
