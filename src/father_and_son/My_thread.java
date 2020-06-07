//同时两条线程来挑选幸运中奖者

package father_and_son;

import java.util.Random;

public class My_thread {
    public static void main(String[] args) {
        Random dom=new Random();//主线程的随机数对象
      new Thread(new Runnable() {//匿名对象与匿名类部类写法
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                 //   System.out.println(Thread.currentThread().getName()+":"+new Random().nextInt(50));//输出另一个线程的名字与随机数
                    System.out.println("计科5182中奖者:"+new Random().nextInt(50));//点人回答问题。。。（真实）
                    try {
                        Thread.sleep(1000);//每次输出延迟1秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();//若有异常则抓捕且打印异常
                    }
                }
            }
        }).start();//开启新线程（运行run()函数），告诉操作系统有另一个线程
        for (int i = 0; i < 15; i++) {
          //  System.out.println("\t\t\t\t\t\t\t"+Thread.currentThread().getName()+":"+dom.nextInt(34));//输出主线程的名字与随机数
            System.out.println("\t\t\t\t\t\t\t计科5181中奖者:"+dom.nextInt(34));//点人起来回答问题。。（真实）
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();//捕捉异常
            }
        }


    }
}
