package student_frame;

import my.ceshi.Druid_connect_pool;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jiaru extends JFrame {
    int count = 1;
    int count1;

    public JPanel tianjia() {


        JFrame jFrame = new JFrame("欢迎来到社会人注册系统");
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

        JLabel jLabel1 = new JLabel(new ImageIcon("image/king.jpg"));
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
        Button button = new Button("注册");
        button.setBounds(150, 300, 100, 40);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = jTextField.getText();
                char[] password = jPasswordField.getPassword();
                String pwd = new String(password);
                JdbcTemplate template = new JdbcTemplate(Druid_connect_pool.get_druid_DataSource());
                int aLong = template.update("insert into admin(username,password) values(?,?)", username, pwd);
                if (aLong > 0&&(username.length()!=0||pwd.length()!=0)) {
                    JOptionPane.showMessageDialog(jFrame, "注册成功，快回去登录吧！", "恭喜恭喜", JOptionPane.INFORMATION_MESSAGE);
                } else if(username.length()==0||pwd.length()==0) {
                    JOptionPane.showMessageDialog(jFrame, "注册失败，内容不能为空？", "失败", JOptionPane.ERROR_MESSAGE);

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
/*        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);*/
        return jPanel;
    }
    public static void main(String[] args) {
        new Jiaru().tianjia();
    }

}

