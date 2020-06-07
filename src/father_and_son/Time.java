package father_and_son;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static void main(String[] args) {
        Date d =new Date();//获取当前时间的date类型对象
        SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//一个可以将date类型转化为字符串的对象
        String date = s.format(d);//将date 类型转化为String
        System.out.println(date);//将变成String类型的日期输出

    }
}
