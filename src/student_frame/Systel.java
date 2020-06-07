package student_frame;

import javax.swing.*;

public class Systel {
    public static void main(String[] args) {
        UIManager.LookAndFeelInfo info[]=UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo tem:info) {
            System.out.println(tem.getClassName());
            //得到的结果：
            /*javax.swing.plaf.metal.MetalLookAndFeel...........默认的风格
            javax.swing.plaf.nimbus.NimbusLookAndFeel
            com.sun.java.swing.plaf.motif.MotifLookAndFeel
            com.sun.java.swing.plaf.windows.WindowsLookAndFeel
            com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel*/
        }
    }
}
