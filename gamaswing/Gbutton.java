package gamaswing;

import static gamaswing.GamaSwing.all;
import static gamaswing.GamaSwing.delete;
import static gamaswing.GamaSwing.updatePoint;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Gbutton extends JButton {

    static Random rd = new Random();

    private int p = 0;

    public Gbutton() {
        super();
        setText("" + p);
        int w = 50;//getWidth();
        int h = 30;//getHeight();
        setBounds(rd.nextInt(1280 - w), rd.nextInt(720 - h), w, h);
        setBackground(new Color(rd.nextFloat(),
                (float) (rd.nextFloat() * 0.8 + 0.2),
                (float) (rd.nextFloat() * 0.8 + 0.2)));
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.blue, 2, true));

        addActionListener(ae -> {
            setEnabled(false);
            updatePoint(getText());
            delete(this);
            all.remove(this);
        });
    }

    public void randomize() {
        // .ConcurrentModificationException
        Rectangle coord = getBounds();
        coord.x += (rd.nextInt(31) - 15);
        coord.y += (rd.nextInt(31) - 15);
        if ((coord.x > 0) && (coord.x < 1200) && (coord.y > 0) && (coord.y < 700)) {
            setBounds(coord);
        }
        p += Math.round(rd.nextFloat() * 4 - 2);
        if (p < -20) {
            p++;
        }
        setText("" + p);
        repaint();
    }

}
