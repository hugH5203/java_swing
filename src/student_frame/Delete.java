package student_frame;

import my.ceshi.Druid_connect_pool;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JFrame {


    public void delete() {


        JFrame jFrame = new JFrame("删除社会人信息");
        jFrame.setSize(600, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        JPanel jPanel = new JPanel(null);


        JLabel jLabel = new JLabel("姓名");
        jLabel.setBounds(30, 95, 60, 40);
        jPanel.add(jLabel);

        JTextField jTextField = new JTextField(10);
        jTextField.setBounds(80, 100, 200, 30);
        jTextField.setFont(new Font("楷体", Font.BOLD, 18));
        jTextField.setForeground(Color.BLUE);
        jPanel.add(jTextField);

        Button button = new Button("确认删除");
        button.setBounds(150, 300, 100, 40);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String suppername = jTextField.getText();
                JdbcTemplate template = new JdbcTemplate(Druid_connect_pool.get_druid_DataSource());
                int update1 = template.update("delete from student where name=?", suppername);
                if (update1> 0) {
                    JOptionPane.showMessageDialog(jFrame, "删除成功", "系统回应", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(jFrame, "请仔细检查各信息类型", "删除失败！！！！", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        jPanel.add(button);
        // jFrame.pack();
        Button button1 = new Button("取消");
        button1.setBounds(350, 300, 100, 40);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.setText("");
            }
        });


        jPanel.add(button1);
        jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);
    }


    public static void main(String[] args) {
        new Delete().delete();
    }

}
