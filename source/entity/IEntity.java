package entity;

 // @author Jarrod
import java.util.HashSet;
import main.TriggerEvent;

public interface IEntity {

    //fields

    //signatures
    public void updateLocation();

    public void update();

    public void paint();

    public void destroy();

    public void trigger(HashSet<TriggerEvent> triggers);

}
