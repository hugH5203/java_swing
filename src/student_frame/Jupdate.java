package student_frame;

import my.ceshi.Druid_connect_pool;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jupdate extends JFrame {


    public JPanel j_update() {


        JFrame jFrame = new JFrame("修改社会人信息");
        jFrame.setSize(800, 800);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        JPanel jPanel = new JPanel(null);

        JLabel jLabel3 = new JLabel("原姓名");
        jLabel3.setBounds(130, 25, 60, 40);
        jPanel.add(jLabel3);

        JTextField jTextField3 = new JTextField(10);
        jTextField3.setBounds(180, 30, 200, 30);
        jTextField3.setFont(new Font("楷体", Font.BOLD, 18));
        jTextField3.setForeground(Color.red);
        jPanel.add(jTextField3);

        JLabel jLabel = new JLabel("姓名");
        jLabel.setBounds(30, 95, 60, 40);
        jPanel.add(jLabel);

        JTextField jTextField = new JTextField(10);
        jTextField.setBounds(80, 100, 200, 30);
        jTextField.setFont(new Font("楷体", Font.BOLD, 18));
        jTextField.setForeground(Color.BLUE);
        jPanel.add(jTextField);

        JLabel jLabel2 = new JLabel("社会号");
        jLabel2.setBounds(30, 200, 60, 40);
        jPanel.add(jLabel2);

        JTextField jTextField2 = new JTextField(10);
        jTextField2.setBounds(80, 200, 200, 30);
        jTextField2.setFont(new Font("楷体", Font.BOLD, 18));
        jTextField2.setForeground(Color.green);
        jPanel.add(jTextField2);

        String[] nmber = {"计科5181", "计科5182", "计科5183", "传销大队"};
        JComboBox jComboBox = new JComboBox(nmber);
        jComboBox.setBounds(450, 200, 90, 40);
        jComboBox.setEditable(true);
        jComboBox.setSelectedIndex(2);
        jPanel.add(jComboBox);

        JRadioButton jRadioButton = new JRadioButton("男");
jRadioButton.setBounds(350, 150, 40, 40);
        JRadioButton jRadioButton1 = new JRadioButton("女");
        jRadioButton1.setBounds(450, 150, 40, 40);
        jRadioButton.setSelected(true);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton);
        buttonGroup.add(jRadioButton1);
        jPanel.add(jRadioButton);
        jPanel.add(jRadioButton1);

        JLabel jLabel1 = new JLabel(new ImageIcon("image/queen.jpg"));
        jLabel1.setBounds(5, 350, 700, 400);
        jPanel.add(jLabel1);

        Button button = new Button("确认修改");
        button.setBounds(150, 300, 100, 40);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sex;
                String name1 = jTextField3.getText();
                String suppername = jTextField.getText();
                String suppernmber = jTextField2.getText();
                String selectedItem = (String) jComboBox.getSelectedItem();
                if (jRadioButton.isSelected()){
                    sex="男";
                }else {
                    sex="女";
                }
                JdbcTemplate template = new JdbcTemplate(Druid_connect_pool.get_druid_DataSource());
                int update1 = template.update("update student set name=?,sex=?,sno=?,classname=? where name=?", suppername, sex, suppernmber, selectedItem, name1);
                if (update1 > 0&&suppername.length()!=0) {
                    JOptionPane.showMessageDialog(jFrame, "修改成功", "系统回应", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(jFrame, "请仔细检查原姓名,且不可为空", "修改失败！！！！", JOptionPane.WARNING_MESSAGE);
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
                jTextField3.setText("");
                jTextField.setText("");
                jTextField2.setText("");
                jComboBox.setSelectedIndex(2);
                jRadioButton.setSelected(true);
            }
        });


        jPanel.add(button1);
      /*  jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);*/
        return jPanel;
    }


    public static void main(String[] args) {
        new Jupdate().j_update();
    }

}
