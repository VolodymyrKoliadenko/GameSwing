package gamaswing;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author Администратор
 */
public class GamaSwing {

    public static JFrame frame;
    static int points = 0;
    static JLabel pointL = new JLabel("0");
    public static ArrayList<Gbutton> all = new ArrayList<>();

    public static void delete(Component comp) {
        frame.remove(comp);
        frame.revalidate();
        frame.repaint();
    }

    public static void updatePoint(String arg) {
        points += Integer.parseInt(arg);
        pointL.setText("" + points);
        pointL.repaint();
    }

    public static void createAndShowGUI() {
        frame = new JFrame("Old SWING game");
        frame.setSize(1280, 738);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        pointL.setBounds(2, 0, 100, 25);
        pointL.setForeground(Color.red);
        frame.add(pointL);

        all = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Gbutton b = new Gbutton();
            frame.add(b);
            all.add(b);
        }

        frame.setVisible(true);
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Task(), 0, 150);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();

            }
        });
    }

}
