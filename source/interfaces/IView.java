package interfaces;

// @author Jarrod
import java.awt.Graphics;
import java.util.HashSet;
import main.TriggerEvent;

public interface IView {

    //fields
    //constructors
    //methods
    public void update();

    public void render(Graphics g);

    public void handleTriggers(HashSet<TriggerEvent> triggers);
}
