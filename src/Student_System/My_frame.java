package Student_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class My_frame extends JFrame {
    String text;
    String pwd;

public  void come_in(){


        JFrame jFrame = new JFrame("欢迎来到社会人汇总系统");
        jFrame.setSize(600, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        JPanel jPanel = new JPanel(null);
        JLabel jLabel = new JLabel("用户名");
        jLabel.setBounds(30, 100, 60, 40);
        jPanel.add(jLabel);
        JTextField jTextField = new JTextField(10);
        jTextField.setBounds(120, 100, 400, 40);
        jTextField.setFont(new Font("楷体", Font.BOLD, 18));
        jTextField.setForeground(Color.BLUE);
        jPanel.add(jTextField);
        JLabel jLabel2 = new JLabel("密码");
        jLabel2.setBounds(40, 200, 60, 40);
        jPanel.add(jLabel2);
        JPasswordField jPasswordField = new JPasswordField(10);
        jPasswordField.setBounds(120, 200, 400, 40);
        jPasswordField.setEchoChar('$');
        jPasswordField.setFont(new Font("微软雅黑", Font.BOLD, 18));
        jPasswordField.setForeground(Color.red);
        jPanel.add(jPasswordField);
        Button button = new Button("登录");
        button.setBounds(450, 300, 100, 40);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 text = jTextField.getText();
                char[] password = jPasswordField.getPassword();
                pwd = new String(password);
            }
        });
        jPanel.add(button);
        // jFrame.pack();

        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }

    public String getText() {
        return text;
    }

    public String getPwd() {
        return pwd;
    }

    public static void main(String[] args) {
    new My_frame().come_in();
    }

}
