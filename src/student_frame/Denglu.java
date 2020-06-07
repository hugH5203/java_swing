package student_frame;

import my.ceshi.Druid_connect_pool;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Denglu extends JFrame {
    int count = 1;
    int count1;

    public JPanel come_in() {


        JFrame jFrame = new JFrame("欢迎来到社会人汇总系统");
        jFrame.setSize(800, 800);
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

        JLabel jLabel1 = new JLabel(new ImageIcon("image/fengmu.jpg"));
        jLabel1.setBounds(5, 350, 700, 400);
        jPanel.add(jLabel1);
//键盘监控器
        /*jFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }
        });
*/
        Button button = new Button("登录");
        button.setBounds(150, 300, 100, 40);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = jTextField.getText();
                char[] password = jPasswordField.getPassword();
                String pwd = new String(password);
                JdbcTemplate template = new JdbcTemplate(Druid_connect_pool.get_druid_DataSource());
                Long aLong = template.queryForObject("select count(*) from admin where username=? and password=?", Long.class, username, pwd);//该返回什么类型的值，就传入什么类型的类文件
                if (pwd.length()==0||username.length()==0){
                    JOptionPane.showMessageDialog(jFrame, "内容不能为空", "登录失败", JOptionPane.ERROR_MESSAGE);
                }
              else if (aLong > 0) {
                     jFrame.dispose();
                    Progress progress = new Progress();
                    progress.setVisible(true);
                   // System.exit(0);//退出程序
                } else if (aLong <= 0 && count < 3) {
                    count1 = 3 - count;
                    JOptionPane.showMessageDialog(jFrame, "用户名或密码错误", "您还有" + count1 + "次登录机会！！！！！", JOptionPane.ERROR_MESSAGE);
                    count = count + 1;
                } else if (count >= 3) {
                    count1 = 3 - count;
                    JOptionPane.showInputDialog(jFrame, "请输入root密码或五分钟后再试", "您还有" + count1 + "次登录机会！！！！！", JOptionPane.YES_NO_CANCEL_OPTION);
                }

            }
        });
        jPanel.add(button);
        Button button1 = new Button("取消");
        button1.setBounds(350, 300, 100, 40);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.setText("");
                jPasswordField.setText("");
            }
        });
        jPanel.add(button1);
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
        return jPanel;
    }
    public static void main(String[] args) {
        new Denglu().come_in();
    }

}
