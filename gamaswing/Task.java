package gamaswing;

import static gamaswing.GamaSwing.all;
import static gamaswing.GamaSwing.frame;
import java.util.ConcurrentModificationException;
import java.util.TimerTask;

public class Task extends TimerTask {

    @Override
    public void run() {
        try {
            all.forEach((b) -> {
                b.randomize();
            });
        } catch (ConcurrentModificationException e) { // or synhronized collection ?
            System.out.println("ERROR");
        }
        if (all.size() < 20) {
            Gbutton b = new Gbutton();
            frame.add(b);
            all.add(b);
        }
    }

}
