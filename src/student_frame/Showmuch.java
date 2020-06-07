package student_frame;

import Student_System.Student;
import my.ceshi.Druid_connect_pool;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Showmuch extends JFrame {


    public JPanel showstudents() {


        JFrame jFrame = new JFrame("查询社会人信息");
        jFrame.setSize(800, 800);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        JPanel jPanel = new JPanel(new BorderLayout());


        JdbcTemplate template = new JdbcTemplate(Druid_connect_pool.get_druid_DataSource());
        List<Student> list1 = template.query("select* from student", new BeanPropertyRowMapper<Student>(Student.class));
        String[] name = {"id", "社会人名字", "性别", "社会号", "部门"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][]{}, name);
        for (Student student : list1) {
            Vector vector = new Vector();
            vector.add(student.getId());
            vector.add(student.getName());
            vector.add(student.getSex());
            vector.add(student.getSno());
            vector.add(student.getClassname());
            defaultTableModel.addRow(vector);
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(24, 24, 530, 342);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        JTable jTable = new JTable(defaultTableModel);
        // jTable.setFont(new Font("楷体",4,16));
        jTable.setSelectionForeground(Color.green);
        jTable.setSelectionBackground(Color.BLACK);
        //jTable.setEnabled(false);//此处为不可编辑，则上面两个设置无效了
        // scrollPane.add(jTable);
        scrollPane.setViewportView(jTable);
        jPanel.add(scrollPane);

        JLabel jLabel = new JLabel("姓名");
        jLabel.setBounds(30, 395, 40, 40);
        jPanel.add(jLabel);

        JTextField jTextField = new JTextField(10);
        jTextField.setBounds(80, 400, 200, 30);
        jTextField.setFont(new Font("楷体", Font.BOLD, 18));
        jTextField.setForeground(Color.BLUE);
        jPanel.add(jTextField);

        JTextArea jTextArea = new JTextArea();
        jTextArea.setBounds(90, 450, 400, 130);
        //jTextArea.setBackground(Color.black);
        jTextArea.setFont(new Font("楷体", Font.BOLD, 20));
        jTextArea.setForeground(Color.BLUE);
        jPanel.add(jTextArea);

        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int clicked = e.getClickCount();//没用到哦
                if (jTable.getValueAt(jTable.getSelectedRow(), jTable.getSelectedColumn()) != null) {
                    String name = (String) jTable.getValueAt(jTable.getSelectedRow(), 1);
                    String sex = (String) jTable.getValueAt(jTable.getSelectedRow(), 2);
                    Integer sno = (Integer) jTable.getValueAt(jTable.getSelectedRow(), 3);
                    String suppernamber = (String) jTable.getValueAt(jTable.getSelectedRow(), 4);
                    jTextArea.setText(name + "  " + sex + "  " + sno + "  " + suppernamber);
                }
            }
        });

        Button button = new Button("查询");
        button.setBounds(150, 600, 100, 40);
        jPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea.setText("");
                String suppername = jTextField.getText();
                Map<String, Object> map = null;
                try {
                    map = template.queryForMap("select * from student where name=?", suppername);
                } catch (DataAccessException ex) {
                    jTextField.setText("");
                    JOptionPane.showMessageDialog(jFrame, "查无此人", "查询失败！！！！", JOptionPane.ERROR_MESSAGE);
                }
                if (map!=null) {
                    for ( String key:map.keySet()) {
                        Object value=  map.get(key);
                        jTextArea.append(value.toString()+"  ");
                    }
                }
            }
        });
        Button button2 = new Button("取消");
        button2.setBounds(350, 600, 100, 40);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.setText("");
                jTextArea.setText("");
            }
        });
        jPanel.add(button2);

////////一个很牛逼的bug!!!!
        Button button1 = new Button("");
        button1.setBounds(50, 900, 500, 40);
        jPanel.add(button1);


        // jFrame.pack();

    /*    jFrame.setContentPane(jPanel);
        jFrame.setVisible(true);*/
        return jPanel;
    }


    public static void main(String[] args) {
        new Showmuch().showstudents();
    }

}
