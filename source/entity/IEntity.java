package entity;

 // @author Jarrod
import java.awt.event.MouseEvent;
import java.util.HashSet;
import main.TriggerEvent;

public interface IEntity {

    //fields

    //signatures
    public void update();
    
    public void paint();
    
    public void destroy();
    
    public void mousePressed(MouseEvent e);
    
    public void mouseReleased(MouseEvent e);
    
    public void trigger(HashSet<TriggerEvent> triggers);

}
