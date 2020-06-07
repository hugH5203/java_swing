package student_frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_frame {
    public Main_frame() throws AWTException {

        JFrame jFrame = new JFrame("欢迎来到社会人系统");
        jFrame.setSize(800, 800);
        jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        jTabbedPane.add("添加", new Inster().inster());
        jTabbedPane.add("修改", new Jupdate().j_update());
        jTabbedPane.add("查询", new Showmuch().showstudents());
        jTabbedPane.add("注册", new Jiaru().tianjia());
        jFrame.setContentPane(jTabbedPane);
        jFrame.setVisible(true);

        if (SystemTray.isSupported()){//如果支持系统托盘
            SystemTray tray=SystemTray.getSystemTray();//获取当前平台的系统托盘
            Image image=Toolkit.getDefaultToolkit().getImage("image/nba.jpg");
            PopupMenu menu=new PopupMenu();
            MenuItem open=new MenuItem("打开");
            MenuItem exit=new MenuItem("退出");
            menu.add(open);
            menu.add(exit);
            open.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!jFrame.isShowing()){
                        jFrame.setVisible(true);
                    }
                }
            });
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            TrayIcon trayIcon=new TrayIcon(image,"学生系统",menu);
                    trayIcon.setImageAutoSize(true);
                    tray.add(trayIcon);
        }
        else {
            System.out.println("当前系统不支持托盘");
        }
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");//灰色白框蓝边色风格
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");//深色深框红边风格
       //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//贼丑
       //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");//也丑，不过按钮有浮雕效果
        JFrame jFrame1 = new JFrame("登录中.........");
        jFrame1.setSize(800, 800);
        jFrame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jFrame1.setLocationRelativeTo(null);
        jFrame1.setResizable(false);
        jFrame1.add(new Denglu().come_in());
        jFrame1.setVisible(true);


    }


}
