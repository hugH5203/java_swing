package student_frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Progress extends JFrame {
    static int c=0;
    public Progress() {
        JFrame jFrame = new JFrame("系统进度");
        JPanel jPanel = new JPanel(null);
        jFrame.setSize(400, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        JProgressBar jProgressBar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
        jProgressBar.setBounds(0, 0, 400, 80);
    //方法一：
        /*   new Thread(){
            public void run(){
                for(int i=0;i<=100;i++){
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                }
                jProgressBar.setString("成功登陆！");

            }
        }.start();*/

        //方法二：
        new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c+=5;
                jProgressBar.setValue(c);
                if (c==100){
                    jProgressBar.setString("成功登陆！");
                }
            }
        }).start();

        jProgressBar.setStringPainted(true);
        jPanel.add(jProgressBar);
        jFrame.setContentPane(jPanel);
        JButton btnNewButton = new JButton("进入系统");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               jFrame.dispose();
                try {      //因为该界面加入了系统托盘，所以需要处理一下可能出现的
                    new Main_frame();
                } catch (AWTException e) {
                    e.printStackTrace();
                }

            }
        });
        btnNewButton.setBounds(140, 100, 100, 30);
        jPanel.add(btnNewButton);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Progress();
    }
}
