import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
public class okno1   {
    public okno1() {

        final JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setLocationRelativeTo(null);
        
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new okno1();
    }
}
