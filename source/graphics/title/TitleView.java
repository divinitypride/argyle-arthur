package graphics.title;

// @author Jarrod
import graphics.game.MainGameView;
import interfaces.IView;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.TriggerEvent;
import main.Main;

public class TitleView implements IView {

    //fields
    private Timer timer;

    //constructors
    public TitleView(long milliTime) {
        timer = new Timer();
        timer.schedule(new TitleViewTimer(), milliTime);
    }

    public TitleView() {
        this(TimeUnit.SECONDS.toMillis(5));
    }

    //methods
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        try {
            g2d.drawImage(Main.STORE.getImage("splashes\\title\\title"), 0, 0, Main.WORLD.getWindow().getX(), Main.WORLD.getWindow().getY(), null);
        } catch (IOException ex) {
            Logger.getLogger(TitleView.class.getName()).log(Level.SEVERE, null, ex);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void handleTriggers(HashSet<TriggerEvent> triggers) {

    }


    private class TitleViewTimer extends TimerTask {

        @Override
        public void run() {
            Main.setView(new MainGameView());
        }

    }

}
